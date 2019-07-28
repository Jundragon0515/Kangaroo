package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.Auction_boardDTO;
import kh.spring.dto.Auction_img_boardDTO;
import kh.spring.dto.Used_transaction_boardDTO;
import kh.spring.dto.Used_transaction_img_boardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sst;
	@Autowired
	private HttpSession se;
	static int recordCountPerPage = 5;// 한 페이지에 보여줄 글 개수
	static int naviCountPerPage = 10;// 한페이지에 보여줄 페이지 번호 수
	public List<Auction_boardDTO> selectById_au(int currentPage,String id){
		int endNum = currentPage * recordCountPerPage;
		int startNum = endNum - 4;
		Map<String,String> map = new HashMap<>();
		map.put("startNum", Integer.toString(startNum));
		map.put("endNum", Integer.toString(endNum));
		map.put("id", id);
		return sst.selectList("BoardDAO.selectById_au", map);
	}
	public int recordCount_au(String id) { // 글 갯수
		return sst.selectOne("BoardDAO.recordCount_au",id);
	}
	public String getNavi_au(int currentPage,String id) {
		int recordTotalCount = this.recordCount_au(id); // 전체 글 갯수
		int pageTotalCount = 0;
		int or2_currentPage=(int)se.getAttribute("or2_currentPage");
		int used_currentPage=(int)se.getAttribute("used_currentPage");
		if (recordTotalCount % recordCountPerPage > 0) { // 전체 글 갯수 % 한 페이지에 보여줄 글 갯수 -> 나머지 잇으면 한페이지 더 필요
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else if (recordTotalCount % recordCountPerPage == 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		if (currentPage < 1) {// 최소 페이지 보다 작으면 최소페이지로
			currentPage = 1;
		} else if (currentPage > pageTotalCount) { // 현재페이지 번호가 전체페이지보다 크면 최대 페이지로
			currentPage = pageTotalCount;
		} // 보안코드
		int startNavi = (currentPage - 1) / naviCountPerPage * naviCountPerPage + 1;
		int endNavi = startNavi + (naviCountPerPage - 1);
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true; // 이전버튼
		boolean needNext = true; // 다음버튼
		if (startNavi == 1) {
			needPrev = false;
		}
		if (endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<nav aria-label='Page navigation example'><ul class='pagination justify-content-center'>");
		if (needPrev) {
			sb.append("<li class='page-item'><a class='page-link' href='goMyPage_sold?auc_currentPage=" + (startNavi - 1) + "&used_currentPage="+used_currentPage+"&or2_currentPage="+or2_currentPage+"'> <이전 </a></li>");
		}
		for (int i = startNavi; i <= endNavi; i++) {
			sb.append("<li class='page-item'><a class='page-link' class='pageNum' href='goMyPage_sold?auc_currentPage=" + i + "&used_currentPage="+used_currentPage+"&or2_currentPage="+or2_currentPage+"'>  " + i + "  </a></li>");
		}
		if (needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='goMyPage_sold?auc_currentPage=" + (endNavi + 1) + "&used_currentPage="+used_currentPage+"&or2_currentPage="+or2_currentPage+"'> 다음> </a></li>");
		}
		sb.append("</ul></nav>");
		return sb.toString();
	}
	public List<Used_transaction_boardDTO> selectById_us(int currentPage,String id){
		int endNum = currentPage * recordCountPerPage;
		int startNum = endNum - 4;
		Map<String,String> map = new HashMap<>();
		map.put("startNum", Integer.toString(startNum));
		map.put("endNum", Integer.toString(endNum));
		map.put("id", id);
		return sst.selectList("BoardDAO.selectById_us", map);
	}
	public int recordCount_us(String id) { // 글 갯수
		return sst.selectOne("BoardDAO.recordCount_us",id);
	}
	public String getNavi_us(int currentPage,String id) {
		int recordTotalCount = this.recordCount_us(id); // 전체 글 갯수
		int pageTotalCount = 0;
		int or2_currentPage=(int)se.getAttribute("or2_currentPage");
		int auc_currentPage=(int)se.getAttribute("auc_currentPage");
		if (recordTotalCount % recordCountPerPage > 0) { // 전체 글 갯수 % 한 페이지에 보여줄 글 갯수 -> 나머지 잇으면 한페이지 더 필요
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else if (recordTotalCount % recordCountPerPage == 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		if (currentPage < 1) {// 최소 페이지 보다 작으면 최소페이지로
			currentPage = 1;
		} else if (currentPage > pageTotalCount) { // 현재페이지 번호가 전체페이지보다 크면 최대 페이지로
			currentPage = pageTotalCount;
		} // 보안코드
		int startNavi = (currentPage - 1) / naviCountPerPage * naviCountPerPage + 1;
		int endNavi = startNavi + (naviCountPerPage - 1);
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true; // 이전버튼
		boolean needNext = true; // 다음버튼
		if (startNavi == 1) {
			needPrev = false;
		}
		if (endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<nav aria-label='Page navigation example'><ul class='pagination justify-content-center'>");
		if (needPrev) {
			sb.append("<li class='page-item'><a class='page-link' href='goMyPage_sold?used_currentPage=" + (startNavi - 1) + "&auc_currentPage="+auc_currentPage+"&or2_currentPage="+or2_currentPage+"'> <이전 </a></li>");
		}
		for (int i = startNavi; i <= endNavi; i++) {
			sb.append("<li class='page-item'><a class='page-link' class='pageNum' href='goMyPage_sold?used_currentPage=" + i + "&auc_currentPage="+auc_currentPage+"&or2_currentPage="+or2_currentPage+"'>  " + i + "  </a></li>");
		}
		if (needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='goMyPage_sold?used_currentPage=" + (endNavi + 1) + "&auc_currentPage="+auc_currentPage+"&or2_currentPage="+or2_currentPage+"'> 다음> </a></li>");
		}
		sb.append("</ul></nav>");
		return sb.toString();
	}
	public int writeInsert(Used_transaction_boardDTO dto) {
		return sst.insert("BoardDAO.writeInsert",dto);
	}
	
	public int imgInsert(Used_transaction_img_boardDTO dto) {
		return sst.insert("BoardDAO.imgInsert",dto);
	}
	
	public int actionWriteInsert(Auction_boardDTO dto) {
		return sst.insert("BoardDAO.actionWriteInsert",dto);
	}
	
	public int actionImgInsert(Auction_img_boardDTO dto) {
		return sst.insert("BoardDAO.actionImgInsert",dto);
	}
	public int used_onGoing_n(int no) {
		return sst.update("BoardDAO.used_onGoing_n",no);
	}
	
}

