package kh.spring.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import kh.spring.dao.DetailPageDAO;
import kh.spring.dao.KakaoDAO;
import kh.spring.dao.MailDAO;
import kh.spring.dao.MemberDAO;
import kh.spring.dao.NaverDAO;
import kh.spring.dto.Auction_boardDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.dto.OrderDTO;
import kh.spring.dto.TenderDTO;

@Component
public class MemberService {
	@Autowired
	MemberDAO me;
	@Autowired
	HttpSession se;
	@Autowired
	private MailDAO maildao;
	@Autowired
	NaverDAO na;
	@Autowired
	KakaoDAO ka;
	@Autowired
	DetailPageDAO ddao;
	
	@Transactional("txManager")
	public int buy(OrderDTO dto) {
		
		ddao.buy_minus(dto);
		ddao.buy(dto);
		ddao.soldOut(dto.getProduct_num());
		ddao.pointUsing(dto);
		
		return 1;
	}
	
	@Transactional("txManager")
	public void tender(TenderDTO dto, int Board_num) {
		me.minus(dto);
		me.tender(dto);
		try {
		me.plus(me.moneyBack(1));//1고정
		}catch(Exception e) {
			System.out.println("첫번째 입찰 발생");
		}
		
		System.out.println(dto.getPoint());
		System.out.println(Board_num);
		
		Auction_boardDTO a_dto = new Auction_boardDTO();
		a_dto.setPresent_price(dto.getPoint());
		a_dto.setNo(Board_num);
		ddao.a_updatePrice(a_dto);
		
	}
	public String loginProc(String id , String pw) { //로그인 
		if(me.loginProc(id,pw) > 0) {
			if(id.equals("admin@admin.com"))
				se.setAttribute("admin", "y");
			se.setAttribute("email", id);
			MemberDTO m_info=me.selectById(id);
			se.setAttribute("name",m_info.getName());
			se.setAttribute("phone",m_info.getPhone());
			se.setAttribute("zipcode",m_info.getZipcode());
			se.setAttribute("address1", m_info.getAddress1());
			se.setAttribute("address2", m_info.getAddress2());
			se.setAttribute("info",m_info);
			se.setAttribute("logintype", m_info.getLogintype());
			se.setAttribute("point", m_info.getPoint());
			se.setAttribute("member_class", m_info.getMember_class());
			return "Y";
		}else {
			return "N";
		}
	}
	public String insertProc(MemberDTO dto,HttpServletRequest request){ //회원가입
		String phonecheckvar = request.getParameter("phonecheckvar");
		String pwcheckvar = request.getParameter("pwcheckvar");
		String idcheckvar = request.getParameter("idcheckvar");
		String namecheckvar = request.getParameter("namecheckvar");
		String idregex = null;
		String pwregex = null;
		String phoneregex = null;
		String nameregex = null;
		Pattern IdPattern = Pattern.compile("(^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$)");
		Matcher IddateMacher = IdPattern.matcher(dto.getId());
		if(IddateMacher.find()){
			System.out.println(IddateMacher.group());
			idregex = IddateMacher.group();
		}
		Pattern PwPattern = Pattern.compile("(^[A-Za-z0-9]{6,12}$)");
		Matcher PwdateMacher = PwPattern.matcher(dto.getPw());
		if(PwdateMacher.find()){
			System.out.println(PwdateMacher.group()); 
			pwregex = PwdateMacher.group();
		}
		Pattern NamePattern = Pattern.compile("(^.{1,6}$)");
		Matcher NamedateMacher = NamePattern.matcher(dto.getName());
		if(NamedateMacher.find()){
			System.out.println(NamedateMacher.group()); 
			nameregex = NamedateMacher.group();
		}
		Pattern PhonePattern = Pattern.compile("(^01([0|1|6|7|8|9]?)-([0-9]{3,4})-([0-9]{4})$)");
		Matcher PhonedateMacher = PhonePattern.matcher(dto.getPhone());
		if(PhonedateMacher.find()){
			System.out.println(PhonedateMacher.group());
			phoneregex = PhonedateMacher.group();
		}
		if(      
				idregex != null && 
				pwregex != null   &&
				phoneregex != null &&
				nameregex != null
				){
			if(
					idcheckvar.equals("사용 가능한 아이디 입니다.") &&
					pwcheckvar.equals("사용가능 합니다.") &&
					phonecheckvar.equals("올바른 양식 입니다.") &&
					namecheckvar.equals("올바른 양식 입니다.")
					){
				dto.setLogintype("email");
				HttpServletRequest   req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
				String ip = req.getHeader("X-FORWARDED-FOR");
				if (ip == null) {
					ip = req.getRemoteAddr();
				}
				dto.setIpaddress(ip);
				if(me.insertProc(dto) > 0 ) {
					System.out.println("성공");
				}else {
					System.out.println("실패");
				}
				return "login";
			}else {
				System.out.println("조건에 맞지 않습니다.");
				return "login";
			}
		}else {
			System.out.println("레직스 단계에서 오류발생");
			return "login";
		}
	}
	public void sendEmail(String email) {//이메일 보내기
		maildao.sendEmail(email);
	}
	public String findIdcheck(String email) {// id 확인
		if(me.pwcheck(email) <= 0) {
			return "-1";
		}else {
			return "1";
		}
	}
	public String changesendAuthNum(String id , String pw) { //비번 변경
		if(me.pwchange(id, pw) <= 0) {
			return "-1";
		}else {
			return "1";
		}
	}
	public String sendAuthNum(String email) {//이메일 인증
		return maildao.sendEmail(email);
	}
	public String idcheck(String id) {
		if(me.idcheck(id) <= 0) {
			if(id.equals("")){
				return "-1";
			}
		}else{
			return "1";
		}
		return "0";
	}
	public String na_login() throws UnsupportedEncodingException { 
		String apiURL=na.login();
		return "redirect:"+apiURL;
	}
	public ModelAndView na_callback(HttpServletRequest request) throws IOException { 
		ModelAndView mav= new ModelAndView();
		Gson g =new Gson();
		JsonParser parse= new JsonParser();
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		String res = na.getToken(code, state);
		String access_token=parse.parse(res.toString()).getAsJsonObject().get("access_token").getAsString();
		String refresh_token=parse.parse(res.toString()).getAsJsonObject().get("refresh_token").getAsString();
		String info=na.getInfo(access_token);
		String email=parse.parse(info).getAsJsonObject().get("id").getAsString();
		MemberDTO dto = new MemberDTO();
		se.setAttribute("email", email);
		dto.setId(email);
		dto.setLogintype("naver");
		HttpServletRequest   req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String ip = req.getHeader("X-FORWARDED-FOR");
		if (ip == null) {
			ip = req.getRemoteAddr();
		}
		dto.setIpaddress(ip);
		if(me.idcheck(email)==0) {
			if(me.insertSocial(dto) > 0 ) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
			MemberDTO m_info=me.selectById(email);
			se.setAttribute("email", email);
			se.setAttribute("name",m_info.getName());
			se.setAttribute("phone",m_info.getPhone());
			se.setAttribute("zipcode",m_info.getZipcode());
			se.setAttribute("address1", m_info.getAddress1());
			se.setAttribute("address2", m_info.getAddress2());
			se.setAttribute("point", m_info.getPoint());
			se.setAttribute("info",m_info);
			se.setAttribute("logintype", m_info.getLogintype());
			se.setAttribute("member_class", m_info.getMember_class());
			mav.setViewName("redirect:/infoInsert");
		}else {
			MemberDTO m_info=me.selectById(email);
			if(m_info.getLogintype().equals("naver")!=true) {
				mav.setViewName("redirect:/login_main");
			}else {
				se.setAttribute("email", email);
				se.setAttribute("name",m_info.getName());
				se.setAttribute("phone",m_info.getPhone());
				se.setAttribute("zipcode",m_info.getZipcode());
				se.setAttribute("address1", m_info.getAddress1());
				se.setAttribute("address2", m_info.getAddress2());
				se.setAttribute("point", m_info.getPoint());
				se.setAttribute("info",m_info);
				se.setAttribute("logintype", m_info.getLogintype());
				se.setAttribute("member_class", m_info.getMember_class());
				mav.setViewName("redirect:/");							
			}
		}
		return mav;
	}
	public String ka_login() throws UnsupportedEncodingException { 
		String apiURL=ka.login();
		return "redirect:"+apiURL;
	}
	public ModelAndView ka_callback(HttpServletRequest request) throws IOException { 
		ModelAndView mav= new ModelAndView();
		Gson g =new Gson();
		JsonParser parse= new JsonParser();
		String code = request.getParameter("code");
		String res = ka.getToken(code);
		String access_token = parse.parse(res.toString()).getAsJsonObject().get("access_token").getAsString();
		String refresh_token = parse.parse(res.toString()).getAsJsonObject().get("refresh_token").getAsString();
		String info = ka.getInfo(access_token);
		String email=parse.parse(info).getAsJsonObject().get("id").getAsString();
		MemberDTO dto = new MemberDTO();
		dto.setId(email);
		dto.setLogintype("kakao");
		HttpServletRequest   req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String ip = req.getHeader("X-FORWARDED-FOR");
		if (ip == null) {
			ip = req.getRemoteAddr();
		}
		dto.setIpaddress(ip);
		if(me.idcheck(email)==0) {
			if(me.insertSocial(dto) > 0 ) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
			MemberDTO m_info=me.selectById(email);
			se.setAttribute("email", email);
			se.setAttribute("name",m_info.getName());
			se.setAttribute("phone",m_info.getPhone());
			se.setAttribute("zipcode",m_info.getZipcode());
			se.setAttribute("address1", m_info.getAddress1());
			se.setAttribute("address2", m_info.getAddress2());
			se.setAttribute("info",m_info);
			se.setAttribute("logintype", m_info.getLogintype());
			se.setAttribute("point", m_info.getPoint());
			se.setAttribute("member_class", m_info.getMember_class());
			mav.setViewName("redirect:/infoInsert");
		}else {
			MemberDTO m_info=me.selectById(email);
			if(m_info.getLogintype().equals("kakao")!=true) {
				mav.setViewName("redirect:/login_main");
			}else {
				se.setAttribute("email", email);
				se.setAttribute("name",m_info.getName());
				se.setAttribute("phone",m_info.getPhone());
				se.setAttribute("zipcode",m_info.getZipcode());
				se.setAttribute("address1", m_info.getAddress1());
				se.setAttribute("address2", m_info.getAddress2());
				se.setAttribute("point", m_info.getPoint());
				se.setAttribute("info",m_info);
				se.setAttribute("logintype", m_info.getLogintype());
				se.setAttribute("member_class", m_info.getMember_class());
				mav.setViewName("redirect:/");				
			}
		}
		return mav;
	}
	public int updateProc(MemberDTO dto) {
		return me.updateProc(dto);
	}
	public void setPoint() {
		se.setAttribute("point", me.getPoint((String)se.getAttribute("email")));
	}
	public int pwCk(String pw) {
		String realPw=me.getPw((String)se.getAttribute("email"));
		if(realPw.equals(MemberDAO.encryptSHA256(pw))) {
			return 1; 
		}else {
			return -1;
		}
	}
}
