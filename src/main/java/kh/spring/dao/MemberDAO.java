package kh.spring.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.MemberDTO;

@Component
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate sst;

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
}
