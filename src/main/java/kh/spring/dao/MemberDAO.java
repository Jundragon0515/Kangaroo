package kh.spring.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kh.spring.dto.CommentDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.dto.OrderDTO;
import kh.spring.dto.TenderDTO;

@Component
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate sst;
	@Autowired
	private JdbcTemplate template;
	@Autowired
	private DataSource ds;
	
	public int levelUp(String id, String grade) throws Exception {
		
		String sql ="update members set member_class = ? where id = ?";
		
		try (Connection con = ds.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, grade);
			pstat.setString(2, id);
			
			int result = pstat.executeUpdate();
			
			return result; 
					
		}
		
		
	}
	
	public String level(String id) {
		return sst.selectOne("MemberDAO.level", id);
	}
	
	public int count1(String id) {
		return sst.selectOne("MemberDAO.count1",id);
	}
	public int count2(String id) {
		return sst.selectOne("MemberDAO.count2",id);
	}
	
	public int countComment1(String id) {
		return sst.selectOne("MemberDAO.commentCount1",id);
	}
	public int countComment2(String id) {
		return sst.selectOne("MemberDAO.commentCount2",id);
	}
	
	public int getPoint(String id) {
		return sst.selectOne("MemberDAO.getPoint", id);
	}
	public int insertProc(MemberDTO dto) { // 회원가입 
        String shapw = encryptSHA256(dto.getPw());
        dto.setPw(shapw);
        return sst.insert("MemberDAO.insertProc",dto);
     }
	public int insertSocial(MemberDTO dto) { // 소셜회원가입 
        return sst.insert("MemberDAO.insertSocial",dto);
     }
     public int idcheck(String id) { // 아이디 중복체크
        return sst.selectOne("MemberDAO.selectIdCheck",id);
     }
     public int loginProc(String id,String pw) { // 로그인
        String shapw = encryptSHA256(pw);
        HashMap<String,String> hash = new HashMap<>();
        hash.put("id",id);
        hash.put("pw",shapw);
        System.out.println(shapw);
        return sst.selectOne("MemberDAO.selectloginProc",hash);
     }
     public int pwcheck(String email) { // 비밀번호 찾기 할때 아이디 중복체크
        System.out.println(email);
        return sst.selectOne("MemberDAO.selectPwcheck", email);
     }
     public int pwchange(String id,String pw) { // 비밀번호 변경
        String shapw = encryptSHA256(pw);
        HashMap<String,String> hash = new HashMap<>();
        hash.put("id", id);
        hash.put("pw", shapw);
        return sst.update("MemberDAO.updatePwChange", hash);
     }
 	public static String encryptSHA256(String str){
	       String sha = ""; 
	       try{
	          MessageDigest sh = MessageDigest.getInstance("SHA-256"); 
	          sh.update(str.getBytes()); 
	          byte byteData[] = sh.digest();
	          StringBuffer sb = new StringBuffer(); 
	          for(int i = 0 ; i < byteData.length ; i++){
	             sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
	          }

	          sha = sb.toString();

	       }catch(NoSuchAlgorithmException e){
	          System.out.println("Encrypt Error - NoSuchAlgorithmException");
	          sha = null; 
	       }
	       return sha;
	}
 	public MemberDTO selectById(String id) {
 		return sst.selectOne("MemberDAO.selectById", id);
 	}
 	public int updateProc(MemberDTO dto) {
 		return sst.update("MemberDAO.updateProc",dto);
 	}
 	public int setPoint(String id,int money) {
 		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("point", Integer.toString(money));
 		return sst.update("MemberDAO.setPoint",map);
 	}
 	public String getPw(String id) {
 		return sst.selectOne("MemberDAO.getPw", id);
 	}
	
public int tender(TenderDTO dto) {
return sst.insert("MemberDAO.tender", dto);
}

public int selectMoney(TenderDTO dto) {
return sst.selectOne("MemberDAO.selectMoney", dto);
}

public int minus(TenderDTO dto) {
return sst.update("MemberDAO.minus", dto);
}
// 현재 입찰가
public int currentMoney(int Board_num){
return sst.selectOne("MemberDAO.currentMoney", Board_num);
}

// 현재 보유 금액
public int myMoney(String id) {
return sst.selectOne("MemberDAO.myMoney", id);
}

// 돈 돌려주는 메서드 
public TenderDTO moneyBack(int Board_num) {
return sst.selectOne("MemberDAO.moneyBack", Board_num);
}

// 돈 을 다시 넣어주는 메서드
public int plus(TenderDTO dto) {
return sst.update("MemberDAO.plus", dto);
}

// 입찰 1~5까지의 랭킹
public List<TenderDTO> rank(int Board_num) {
return sst.selectList("MemberDAO.tenderRank", Board_num);// 1값 고정
}

public List<CommentDTO> commentRank(int boardNum){
return sst.selectList("MemberDAO.commentTop5",boardNum);
}

public int insertComment(CommentDTO dto) {
return sst.insert("MemberDAO.commentInsert", dto);
}

public List<CommentDTO> commentList(int currentPage, int boardNum) throws Exception {

int endNum = currentPage * recordCountPerPage;
int startNum = endNum - (recordCountPerPage - 1);

String sql = "select * from (select row_number() over (order by seq desc)rank, seq,  id, contents,time,ipaddress,boardNum,member_class from comments where boardNum=?)\r\n" + 
"where rank between ? and ? order by seq asc";

try (Connection con = ds.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {

pstat.setInt(1, boardNum);
pstat.setInt(2, startNum);
pstat.setInt(3, endNum);

try (ResultSet rs = pstat.executeQuery();){

List<CommentDTO> result = new ArrayList<>();

while (rs.next()) {
	int seq = rs.getInt(2);
	String id = rs.getString(3);
	String contents = rs.getString(4);
	String time = rs.getString(5);
	String ipaddress = rs.getString(6);
	int board_Num = rs.getInt(7);
	String level = rs.getString(8);

	CommentDTO dto = new CommentDTO();
	dto.setSeq(seq);
	dto.setId(id);
	dto.setContents(contents);
	dto.setTime(time);
	dto.setIpaddress(ipaddress);
	dto.setBoardNum(board_Num);
	dto.setMember_class(level);
	result.add(dto);
}

return result;
}

}

}

static int recordCountPerPage = 5;
static int recordCountPerPage2 = 5;


public int commentContentsSize(int no) {
String sql = "select count(*) from comments where boardNum="+no;
return template.queryForObject(sql, int.class);
}

public String getNaviforComment(int currentPage,int boardNum) { // 부트스트랩은 int로 받아야함
int recordTotalCount = this.commentContentsSize(boardNum);
int recordCountPerPage = 5; // 5개의 글이 보이게 한다.
int naviCountPerPage = 5; // 5개의 네비가 보이게 한다.

int pageTotalCount = recordTotalCount / recordCountPerPage;
if (recordTotalCount % recordCountPerPage > 0) {
pageTotalCount++;
}

if (currentPage < 1) {
currentPage = 1;
} else if (currentPage > pageTotalCount) {
currentPage = pageTotalCount;
}

int startNavi = (currentPage - 1) / naviCountPerPage * naviCountPerPage + 1;
int endNavi = startNavi + (naviCountPerPage - 1);

// 네비 끝값이 최대 페이지 번호를 넘어가면 최대 페이지번호로 네비 끝값을 설정한다.
if (endNavi > pageTotalCount) {
endNavi = pageTotalCount;
}

System.out.println("1시작 : 현재 위치 : " + currentPage);
System.out.println("네비 시작 : " + startNavi);
System.out.println("네비 끝 : " + endNavi);

boolean needPrev = true;
boolean needNext = true;

if (startNavi == 1) {
needPrev = false;
}
if (endNavi == pageTotalCount) {
needNext = false;
}

StringBuilder sb = new StringBuilder();
if (needPrev) {
int prevStartNavi = startNavi - 1;
sb.append("   <li class=\"page-item\"><a class=\"page-link\" href=\"used_detailPage?no="+boardNum+"&currentPage=" + prevStartNavi
	+ "\"" + "                     aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span>"
	+ "                  </a></li>");

}
for (int i = startNavi; i <= endNavi; i++) {
sb.append("<li class=\"page-item\"><a class=\"page-link pageNumber1\" href=\"used_detailPage?no="+boardNum+"&currentPage=" + i + "\">"
	+ i + "</a></li>");
}
if (needNext) {
int nextEndNavi = endNavi + 1;
sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"used_detailPage?no="+boardNum+"&currentPage=" + nextEndNavi++ + "\""
	+ "                     aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span>"
	+ "                  </a></li>");
}

return sb.toString();
}
 	

//경매 댓글!!!!!!!!!!!!!

public List<CommentDTO> commentRank2(int boardNum){
return sst.selectList("MemberDAO.commentTop52",boardNum);
}

public int insertComment2(CommentDTO dto) {
return sst.insert("MemberDAO.commentInsert2", dto);
}

public List<CommentDTO> commentList2(int currentPage, int boardNum) throws Exception {

int endNum = currentPage * recordCountPerPage2;
int startNum = endNum - (recordCountPerPage2 - 1);

String sql = "select * from (select row_number() over (order by seq desc)rank, seq,  id, contents,time,ipaddress,boardNum,member_class from comments2 where boardNum=?)\r\n" + 
"where rank between ? and ? order by seq asc";

try (Connection con = ds.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {

pstat.setInt(1, boardNum);
pstat.setInt(2, startNum);
pstat.setInt(3, endNum);

try (ResultSet rs = pstat.executeQuery();){

List<CommentDTO> result = new ArrayList<>();

while (rs.next()) {
	int seq = rs.getInt(2);
	String id = rs.getString(3);
	String contents = rs.getString(4);
	String time = rs.getString(5);
	String ipaddress = rs.getString(6);
	int board_Num = rs.getInt(7);
	String level = rs.getString(8);

	CommentDTO dto = new CommentDTO();
	dto.setSeq(seq);
	dto.setId(id);
	dto.setContents(contents);
	dto.setTime(time);
	dto.setIpaddress(ipaddress);
	dto.setBoardNum(board_Num);
	dto.setMember_class(level);
	result.add(dto);
	
}

return result;
}

}

}


public int commentContentsSize2(int no) {
String sql = "select count(*) from comments2 where boardNum="+no;
return template.queryForObject(sql, int.class);
}

public String getNaviforComment2(int currentPage,int boardNum) { // 부트스트랩은 int로 받아야함
int recordTotalCount = this.commentContentsSize2(boardNum);
int recordCountPerPage2 = 5; // 5개의 글이 보이게 한다.
int naviCountPerPage = 5; // 5개의 네비가 보이게 한다.

int pageTotalCount = recordTotalCount / recordCountPerPage2;
if (recordTotalCount % recordCountPerPage2 > 0) {
pageTotalCount++;
}

if (currentPage < 1) {
currentPage = 1;
} else if (currentPage > pageTotalCount) {
currentPage = pageTotalCount;
}

int startNavi = (currentPage - 1) / naviCountPerPage * naviCountPerPage + 1;
int endNavi = startNavi + (naviCountPerPage - 1);

// 네비 끝값이 최대 페이지 번호를 넘어가면 최대 페이지번호로 네비 끝값을 설정한다.
if (endNavi > pageTotalCount) {
endNavi = pageTotalCount;
}

System.out.println("1시작 : 현재 위치 : " + currentPage);
System.out.println("네비 시작 : " + startNavi);
System.out.println("네비 끝 : " + endNavi);

boolean needPrev = true;
boolean needNext = true;

if (startNavi == 1) {
needPrev = false;
}
if (endNavi == pageTotalCount) {
needNext = false;
}

StringBuilder sb = new StringBuilder();
if (needPrev) {
int prevStartNavi = startNavi - 1;
sb.append("   <li class=\"page-item\"><a class=\"page-link\" href=\"auction_detailPage?no="+boardNum+"&currentPage=" + prevStartNavi
	+ "\"" + "                     aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span>"
	+ "                  </a></li>");

}
for (int i = startNavi; i <= endNavi; i++) {
sb.append("<li class=\"page-item\"><a class=\"page-link pageNumber1\" href=\"auction_detailPage?no="+boardNum+"&currentPage=" + i + "\">"
	+ i + "</a></li>");
}
if (needNext) {
int nextEndNavi = endNavi + 1;
sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"auction_detailPage?no="+boardNum+"&currentPage=" + nextEndNavi++ + "\""
	+ "                     aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span>"
	+ "                  </a></li>");
}

return sb.toString();
}

public int withdrawal(String id) {
	return sst.delete("MemberDAO.withdrawal",id);
}


}
