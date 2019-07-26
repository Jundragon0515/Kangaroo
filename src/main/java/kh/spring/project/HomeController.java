package kh.spring.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dao.MemberDAO;
import kh.spring.dto.Auction_boardDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.dto.Used_transaction_boardDTO;
import kh.spring.service.MemberService;

@Controller
public class HomeController {
	@Autowired
	private MemberDAO dao;
	@Autowired
	HttpSession se;
	@Autowired
	MemberService mes;
	public static int visitCount = 0;
	
	   @RequestMapping("/")
	   public String visit() {    // 첫 방문
	      System.out.println("반갑습니다.");
	      visitCount++;
	      System.out.println(visitCount);
	      
	      return "index";
	   }
	
	@RequestMapping("/level")
	@ResponseBody
	@Transactional("txManager")
	public int level() { 	
		
		String id = (String)se.getAttribute("email");
		int b1 = dao.count1(id);
		int b2 = dao.count2(id);
		int b = b1+b2;
		int c1 = dao.countComment1(id);
		int c2 = dao.countComment2(id);
		int c = c1+c2;
		
		String level = dao.level(id);
		System.out.println("레벨 테스트 " + b + " : " +c);
		
		try {
		if(level.equals("브론즈")) {
			visitCount++;
			if(b>=100 & c>=100) {
				dao.levelUp(id, "마스터");
				return 6;
			}else if(b>=50 & c>=50){
				dao.levelUp(id, "다이아");
				return 5;
			}else if(b>=10 & c>=10) {
				dao.levelUp(id, "플래티넘");
				return 4;
			}else if(b>=5 & c>=5) {
				dao.levelUp(id, "골드");
				return 3;
			}else if(b>=1 & c>=1) {
				dao.levelUp(id, "실버");
				return 2;
			}
		}else if(level.equals("실버")) {
			visitCount++;
			if(b>=100 & c>=100) {
				dao.levelUp(id, "마스터");
				return 6;
			}else if(b>=50 & c>=50){
				dao.levelUp(id, "다이아");
				return 5;
			}else if(b>=10 & c>=10) {
				dao.levelUp(id, "플래티넘");
				return 4;
			}else if(b>=5 & c>=5) {
				dao.levelUp(id, "골드");
				return 3;
			}
		}else if(level.equals("골드")) {
			visitCount++;
			if(b>=100 & c>=100) {
				dao.levelUp(id, "마스터");
				return 6;
			}else if(b>=50 & c>=50){
				dao.levelUp(id, "다이아");
				return 5;
			}else if(b>=10 & c>=10) {
				dao.levelUp(id, "플래티넘");
				return 4;
			}
		}else if(level.equals("플래티넘")) {
			visitCount++;
			if(b>=100 & c>=100) {
				dao.levelUp(id, "마스터");
				return 6;
			}else if(b>=50 & c>=50){
				dao.levelUp(id, "다이아");
				return 5;
			}
		}else if(level.equals("다이아몬드")) {
			visitCount++;
			if(b>=100 & c>=100) {
				dao.levelUp(id, "마스터");
				return 6;
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	@RequestMapping("/index")
	public String home() { 		//홈
		return "index";
	}
	@RequestMapping("/login_main")
	public String login_main() { // 로그인 메인페이지

		return "login_main";
	}
	@RequestMapping("/login")
	public String login() { // 일반 로그인 페이지

		return "login";
	}
	@RequestMapping("/findIdOrPw")
	public String findIdOrPw() { // 패스워드 찾기
		return "findIdOrPw";
	}
	@RequestMapping("/loginProc")
	@ResponseBody
	public String loginProc(String id,String pw) { // 로그인 기능
		return mes.loginProc(id, pw);
	}
	@RequestMapping("/insert")
	public String insert() { // 회원가입 페이지로 갈때
		return "insert";
	}
	@RequestMapping(value="/insertProc" , method=RequestMethod.POST,  produces="application/String;charset=UTF-8")
	public String insertProc(MemberDTO dto,HttpServletRequest request){ // 회원가입 기능
		return mes.insertProc(dto, request);
	}
	@RequestMapping("/emilAuth.do")
	public ModelAndView emailAuth(HttpServletResponse response,HttpServletRequest request)throws Exception { // 이메일 인증
		String email = request.getParameter("email");
		String authNum = "";
		mes.sendEmail(email.toString());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/emailAuth");
		mv.addObject("email",email);
		mv.addObject("authNum",authNum);
		return mv;
	}
	@ResponseBody
	@RequestMapping("/findIdcheck")
	public String findIdcheck(String id) { // 아이디 찾을때  회원가입 되어있는 아이디 인지 체크
		return mes.findIdcheck(id);
	}
	@ResponseBody
	@RequestMapping("/changePw")
	public String changesendAuthNum(HttpServletRequest request) { // 이메일 인증후 아이디 에 맞는 비밀번호를 변경하는 기능 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		return mes.changesendAuthNum(id, pw);
	}
	@ResponseBody
	@RequestMapping("/sendAuthNum.login")
	public String sendAuthNum(HttpServletRequest request) { // 이메일 인증 기능
		String email = request.getParameter("email");
		request.setAttribute("email", email);
		return mes.sendAuthNum(email);
	}
	@RequestMapping("/emailAuth.login")
	public ModelAndView emailAuth(HttpServletRequest request) { // 회원 가입에서 인증 파업창에 아이디를 보낸다
		ModelAndView mav =new ModelAndView();
		String email = request.getParameter("email");
		mav.addObject("email",email);
		mav.setViewName("emailAuthView");
		return mav;
	}
	@RequestMapping("/idcheck")
	@ResponseBody
	public String idcheck(String id) { // 이미 가입된 아이디 가 있는지 체크
		return mes.idcheck(id);
	}
	@RequestMapping("/infoInsert")
	public String sInsert() {  // 정보입력으로
		return "infoInsert";
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) { //로그아웃
		String old_url = request.getHeader("referer");
		se.invalidate();
		return "redirect:"+old_url;
	}
}
