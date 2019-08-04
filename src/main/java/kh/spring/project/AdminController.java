package kh.spring.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.dao.AdminDAO;
import kh.spring.dao.MemberDAO;
import kh.spring.dao.ReportDAO;
import kh.spring.dto.MemberDTO;
import kh.spring.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminDAO dao; 
	@Autowired
	private AdminService sv;
	@Autowired
	private TradeController tc;
	@Autowired
	private AuctionController ac;
	@Autowired
	private MemberDAO mdao;
	@Autowired
	private ReportDAO rdao;
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/admin")
	public String admin(HttpServletRequest request) {
		String id = (String) session.getAttribute("id");		
		request.setAttribute("visitCount", HomeController.visitCount);					 // 금일 방문자
		request.setAttribute("visitForWeek", dao.visitForWeek());						 // 최근 일주일간 방문자
		request.setAttribute("visitForGraph", dao.visitForGraph());			 			// 최근 일주일간 방문자 백분율
		request.setAttribute("visitForYear", dao.visitForYear());		  				 // 최근 일년간 방문자
		request.setAttribute("safeTradeCount", dao.safeTradeCount());  					 // 안전 거래 완료 수
		request.setAttribute("directTradeCount", dao.directTradeCount());    			// 직거래 완료 수
		request.setAttribute("auctionCount", dao.auctionCount());           			 // 경매 완료 수
		request.setAttribute("memberCount", dao.memberCount());							 // 총 회원수
		request.setAttribute("chargingPoint", dao.chargingPoint());						 // 포인트 충전 총액
		request.setAttribute("auctionActiveCount", dao.auctionActiveCount());            // 활성화된 경매  수
		request.setAttribute("totalCount", dao.auctionCount()+dao.directTradeCount()+dao.safeTradeCount());	// 총 거래량
		request.setAttribute("selectReport", rdao.selectReport());						 // 신고 접수 내역
		
		return "admin/admin";
	}

	@ResponseBody						// @ResponseBody를 붙이면 스프링은 return값을 forward나 redirect가 아닌 String 그 자체로 봄.
	@RequestMapping(value="emailCheck", produces="application/Json;charset=utf-8")		// produces : 한글 타입 전송
	public int emailCheck(String id) {
		int result = dao.emailCheck(id);
		return result;
	}

	@RequestMapping("/userManage")
	public String userManage(HttpServletRequest request) {
		String id = request.getParameter("id");
		MemberDTO mdto = new MemberDTO();
		request.setAttribute("mdto", mdao.selectById(id));
		return "admin/userManage";
	}
	
	@RequestMapping("/blackList")
	public String blackList(HttpServletRequest request) {
		String id = request.getParameter("id");
		mdao.addBlackList(id);
		return "admin/userManage";
	}

	@RequestMapping("/releaseBlackList")
	public String releaseBlackList(HttpServletRequest request) {
		String id = request.getParameter("id");
		mdao.releaseBlackList(id);
		return "admin/userManage";
	}
	
	@RequestMapping("boardWriteDelete")
	public String boardWriteDelete(HttpServletRequest request) {
		String[] value =  request.getParameterValues("checkDelete");
		if(value!=null) {
			sv.boardDelete(value);
		}
		return tc.direct(request);
	}
	
	@RequestMapping("boardWriteSafeDelete")
	public String boardWritesafeDelete(HttpServletRequest request) {
		String[] value =  request.getParameterValues("checkDelete");
		if(value!=null) {
			sv.boardDelete(value);
		}
		return tc.safe(request);
	}
	
	@RequestMapping("auctionBoardDelete")
	public String acutionWriteDelete(HttpServletRequest request) {
		String[] value =  request.getParameterValues("checkDelete");
		if(value!=null) {
			sv.auctionBoardDelete(value);
		}
		return ac.index(request);
	}

}


