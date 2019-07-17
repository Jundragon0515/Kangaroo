package kh.spring.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dto.MemberDTO;
import kh.spring.service.MemberService;

@Controller
public class HomeController {
	@Autowired
	HttpSession se;
	@Autowired
	MemberService mes;

	@RequestMapping("/")
	public String home() { //홈
		return "index";
	}
	@RequestMapping("/toPoint")
	public String toPoint() { //포인트 충전
		mes.setPoint();
		return "point";
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
	@RequestMapping(value="/insertProc" , method=RequestMethod.POST)
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
	public String sInsert() {
		return "infoInsert";
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		String old_url = request.getHeader("referer");
		se.invalidate();
		return "redirect:"+old_url;
	}
	@RequestMapping("/updateProc")
	public String updateProc(MemberDTO dto) {
		dto.setId(se.getAttribute("email").toString());
		mes.updateProc(dto);
		se.setAttribute("email", dto.getId());
		se.setAttribute("name",dto.getName());
		se.setAttribute("phone",dto.getPhone());
		se.setAttribute("zipcode",dto.getZipcode());
		se.setAttribute("address1", dto.getAddress1());
		se.setAttribute("address2", dto.getAddress2());
		se.setAttribute("info",dto);
		se.setAttribute("logintype", dto.getLogintype());
		return "redirect:/";
	}
}
