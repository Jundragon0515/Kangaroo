package kh.spring.project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import kh.spring.dao.AdminDAO;
import kh.spring.dto.DeliveryDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.dto.TrackingDTO;
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
	@Autowired
	private AdminDAO adao;
	@RequestMapping(value="updateProc" , produces="application/String;charset=UTF-8")
	public String updateProc(MemberDTO dto, HttpServletRequest request) { //멤버 정보 업데이트
		dto.setId(se.getAttribute("email").toString());
		mes.updateProc(dto);
		se.setAttribute("email", dto.getId());
		se.setAttribute("name",dto.getName());
		se.setAttribute("phone",dto.getPhone());
		se.setAttribute("zipcode",dto.getZipcode());
		se.setAttribute("address1", dto.getAddress1());
		se.setAttribute("address2", dto.getAddress2());
		se.setAttribute("info",dto);
		
	    request.setAttribute("auctionActiveCount", adao.auctionActiveCount());            // 활성화된 경매  수
		request.setAttribute("totalCount", adao.auctionCount()+adao.directTradeCount()+adao.safeTradeCount());	// 총 거래량
		return "redirect:/goMyPage";
	}
	@RequestMapping("/goMyPage")
	public String goMyPage(HttpServletRequest request) { // 마이페이지로
		if(se.getAttribute("email")!=null) {
	         mes.setPoint();
	      }
	    request.setAttribute("auctionActiveCount", adao.auctionActiveCount());            // 활성화된 경매  수
		request.setAttribute("totalCount", adao.auctionCount()+adao.directTradeCount()+adao.safeTradeCount());	// 총 거래량
		return "myPage_f/myPage";
	}
	@RequestMapping("/goMyPage_delivery")
	public ModelAndView goMyPage_delivery(int or_currentPage,int te_currentPage) { // 마이페이지 배송조회
		se.setAttribute("or_currentPage", or_currentPage);
		se.setAttribute("te_currentPage", te_currentPage);
		String email=(String)se.getAttribute("email");
		ModelAndView mav = new ModelAndView();
		try {
			email.equals("");
			}catch(Exception e) {
				mav.setViewName("redirect:/");
				return mav;
			}
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
		return "myPage_f/goMyPage_delivery?or_currentPage="+or_currentPage+"&te_currentPage="+te_currentPage+"";
	}
	@RequestMapping("/goRefund")
	public ModelAndView goRefund(int seq) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("seq", seq);
		mav.setViewName("myPage_f/refund");
		return mav;
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
		try {
		email.equals("");
		}catch(Exception e) {
			mav.setViewName("redirect:/");
			return mav;
		}
		mav.addObject("order_list", mps.selectBySeller(or2_currentPage, email));
		mav.addObject("order_navi", mps.getNavi_or2(or2_currentPage, email));
		mav.addObject("auction_list", mps.selectById_au(auc_currentPage, email));
		mav.addObject("auction_navi",mps.getNavi_au(auc_currentPage, email));
		mav.addObject("used_list", mps.selectById_us(used_currentPage, email));
		mav.addObject("used_navi",mps.getNavi_us(used_currentPage, email));
		mav.setViewName("myPage_f/myPage_sold");
//		"myPage_f/myPage_delivery"
		return mav;
	}
	@RequestMapping("/lookup")
	@ResponseBody
	public String lookup(int seq) {
		String result="a";
//		try {
//			result = mps.lookup(seq);
//		}  catch (IOException e) {
//			e.printStackTrace();
//		}
		if(result!=null) {
			se.setAttribute("result", result);
		}
		return result;
	}
	@RequestMapping("/golookup")
	public ModelAndView golookup() {
		ModelAndView mav = new ModelAndView();
		Gson g =new Gson();
		JsonParser parse= new JsonParser();
//		JsonObject jo=parse.parse((String)se.getAttribute("result")).getAsJsonObject();
//		String invoiceNo=jo.get("invoiceNo").getAsString();
//		String receiverName=jo.get("receiverName").getAsString();
//		String senderName=jo.get("senderName").getAsString();
//		String receiverAddr=jo.get("receiverAddr").getAsString();
//		JsonArray ja=jo.get("trackingDetails").getAsJsonArray(); //이거 넣으면 정상 동작 
		
		List <TrackingDTO> list=new ArrayList<>();
		TrackingDTO dto = new TrackingDTO();
		dto.setTimeString("2019-07-23 19:27:55");
		dto.setWhere("러시아 합스부르크");
		dto.setCode("배송출발");
		TrackingDTO dto2 = new TrackingDTO();
		dto2.setTimeString("2019-07-23 22:00:00");
		dto2.setWhere("Nasa 우주 정거장");
		dto2.setCode("게이트 도착");
		TrackingDTO dto3 = new TrackingDTO();
		dto3.setTimeString("2019-07-25 12:05:10");
		dto3.setWhere("북한 평양");
		dto3.setCode("배송 완료");
		list.add(dto);
		list.add(dto2);
		list.add(dto3);
		mav.addObject("invoiceNo", "임시 운송장 번호");
		mav.addObject("receiverName", "김정은");
		mav.addObject("senderName", "최윤성");
		mav.addObject("receiverAddr", "서울시 용산구 후암동 150-7");
		mav.addObject("ja", list);
		mav.setViewName("myPage_f/lookup");
		return mav;
	}
	@RequestMapping("/delivert_insert")
	public ModelAndView delivert_insert(int seq, String reci) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("seq", seq);
		mav.addObject("reci", reci);
		mav.setViewName("myPage_f/delivery_insert");
		return mav;
	}
	@RequestMapping("/withdrawal")
	@ResponseBody
	public String withdrawal() {
		String email=(String)se.getAttribute("email");
		se.invalidate();
		int flag=mps.withdrawal(email);
		if(flag==0) {
			return "fa";
		}else {
			return "su";
		}
	}
	@RequestMapping("/withdrawal_na")
	@ResponseBody
	public String withdrawal_na() {
		String email=(String)se.getAttribute("email");
		String refresh_token=(String)se.getAttribute("refresh_token");
		se.invalidate();
		int flag=0;
		try {
			flag = mps.withdrawal_na(email,refresh_token);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag==0) {
			return "fa";
		}else {
			return "su";
		}
	}
	@RequestMapping("/withdrawal_ka")
	@ResponseBody
	public String withdrawal_ka() {
		String email=(String)se.getAttribute("email");
		String refresh_token=(String)se.getAttribute("refresh_token");
		se.invalidate();
		int flag=0;
		try {
			flag = mps.withdrawal_ka(email,refresh_token);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag==0) {
			return "fa";
		}else {
			return "su";
		}
	}
}
