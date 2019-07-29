package kh.spring.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.dao.AdminDAO;
import kh.spring.service.MemberService;
import kh.spring.service.PointService;

@Controller
public class PointController {
	@Autowired
	PointService ps;
	@Autowired
	HttpSession se;
	@Autowired
	MemberService mes;
	@Autowired
	private AdminDAO adao;
	@RequestMapping("/insert.po")
	@ResponseBody
	public String insert(int amount ) {
		if(ps.insert(amount)>0) {
			return "충전 성공";
		}else {
			return "충전 실패";
		}
	}
	@RequestMapping("/toPoint")
	public String toPoint(HttpServletRequest request) { //포인트 충전
		if(se.getAttribute("email")!=null) {
			mes.setPoint();
		}
	    request.setAttribute("auctionActiveCount", adao.auctionActiveCount());            // 활성화된 경매  수
		request.setAttribute("totalCount", adao.auctionCount()+adao.directTradeCount()+adao.safeTradeCount());	// 총 거래량
		return "point_f/point";
	}
	@RequestMapping("/toPoint_exc")
	public String toPoint_exc(HttpServletRequest request) { //포인트 환급
		if(se.getAttribute("email")!=null) {
			mes.setPoint();
		}
	    request.setAttribute("auctionActiveCount", adao.auctionActiveCount());            // 활성화된 경매  수
		request.setAttribute("totalCount", adao.auctionCount()+adao.directTradeCount()+adao.safeTradeCount());	// 총 거래량
		return "point_f/point_exc";
	}
	@RequestMapping(value="p_exc" , produces="application/String;charset=UTF-8")
	@ResponseBody
	public String p_exc(int money) { //포인트 환급
		return ps.minus(money);
	}
}
