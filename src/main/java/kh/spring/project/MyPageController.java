package kh.spring.project;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dto.DeliveryDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.service.MemberService;
import kh.spring.service.MyPageService;

@Controller
public class MyPageController {
	@Autowired
	HttpSession se;
	@Autowired
	MemberService mes;
	@Autowired
	MyPageService mps;
	@RequestMapping("/updateProc")
	public String updateProc(MemberDTO dto) { //멤버 정보 업데이트
		dto.setId(se.getAttribute("email").toString());
		mes.updateProc(dto);
		se.setAttribute("email", dto.getId());
		se.setAttribute("name",dto.getName());
		se.setAttribute("phone",dto.getPhone());
		se.setAttribute("zipcode",dto.getZipcode());
		se.setAttribute("address1", dto.getAddress1());
		se.setAttribute("address2", dto.getAddress2());
		se.setAttribute("info",dto);

		return "redirect:myPage_f/goMyPage";
	}
	@RequestMapping("/goMyPage")
	public String goMyPage() { // 마이페이지로
		return "myPage_f/myPage";
	}
	@RequestMapping("/goMyPage_delivery")
	public ModelAndView goMyPage_delivery(int or_currentPage,int te_currentPage) { // 마이페이지 배송조회
		se.setAttribute("or_currentPage", or_currentPage);
		se.setAttribute("te_currentPage", te_currentPage);
		String email=(String)se.getAttribute("email");
		ModelAndView mav = new ModelAndView();
		mav.addObject("order_list", mps.selectByBuyer(or_currentPage, email));
		mav.addObject("tender_list", mps.selectById(te_currentPage,  email));
		mav.addObject("order_navi", mps.getNavi_or(or_currentPage, email));
		mav.addObject("tender_navi",mps.getNavi_ten(te_currentPage, email));
		mav.setViewName("myPage_f/myPage_delivery");
//		"myPage_f/myPage_delivery"
		return mav;
	}
	@RequestMapping("/pwCk")
	@ResponseBody
	public String pwCk(String pw) { //pw 확인
		return Integer.toString(mes.pwCk(pw));
	}
	@RequestMapping("/change_Pw")
	public String changePw() { //비밀번호 변경으로 
		return "changePw";
	}
	@RequestMapping("/confirme")
	public String confirme(int seq) {
		mps.confirme(seq);
		int or_currentPage=(int)se.getAttribute("or_currentPage");
		int te_currentPage=(int)se.getAttribute("te_currentPage");
		return "/goMyPage_delivery?or_currentPage="+or_currentPage+"&te_currentPage="+te_currentPage+"";
	}
	@RequestMapping("/refund")
	@ResponseBody
	public String refund(String message,int seq) {
		System.out.println(message);
		mps.refund(seq);
		return "good";
	}
	@RequestMapping("/preparing")
	@ResponseBody
	public String preparing(int seq) {
		mps.preparing(seq);
		return "good";
	}
	@RequestMapping("/ing")
	@ResponseBody
	public String ing(int seq) {
		mps.ing(seq);
		return "good";
	}
	@RequestMapping("/comp")
	@ResponseBody
	public String comp(int seq) {
		mps.comp(seq);
		return "good";
	}
	@RequestMapping("/refund_comp")
	@ResponseBody
	public String refund_comp(int seq) {
		mps.refund_comp(seq);
		return "good";
	}
	@RequestMapping("/deli_insert")
	@ResponseBody
	public String deli_insert(DeliveryDTO dto) {
		mps.deli_insert(dto);
		return "good";
	}
	@RequestMapping("/goMyPage_sold")
	public ModelAndView goMyPage_sold(int or2_currentPage,int used_currentPage,int auc_currentPage) { // 마이페이지 배송조회
		se.setAttribute("or2_currentPage", or2_currentPage);
		se.setAttribute("used_currentPage", used_currentPage);
		se.setAttribute("auc_currentPage", auc_currentPage);
		String email=(String)se.getAttribute("email");
		ModelAndView mav = new ModelAndView();
		mav.addObject("order_list", mps.selectBySeller(or2_currentPage, email));
		mav.addObject("order_navi", mps.getNavi_or(or2_currentPage, email));
		mav.addObject("auction_list", mps.selectBySeller(auc_currentPage, email));
		mav.addObject("auction_navi",mps.getNavi_ten(auc_currentPage, email));
		mav.addObject("used_list", mps.selectBySeller(auc_currentPage, email));
		mav.addObject("used_navi",mps.getNavi_ten(auc_currentPage, email));
		mav.setViewName("myPage_f/myPage_delivery");
//		"myPage_f/myPage_delivery"
		return mav;
	}
}
