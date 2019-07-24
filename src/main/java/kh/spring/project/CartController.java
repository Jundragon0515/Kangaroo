package kh.spring.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.dto.CartAuctionDTO;
import kh.spring.dto.CartTradeDTO;
import kh.spring.service.CartService;

@Controller
public class CartController {

	@Autowired
	private HttpSession session;

	@Autowired
	private CartService cs;

	@ResponseBody
	@RequestMapping(value="/steaming" , produces="application/String;charset=UTF-8")
	public String streaming(CartTradeDTO dto) {
		dto.setId((String) session.getAttribute("email"));

		if(cs.overlapCheck(dto.getNo())==1) {
			return "찜 목록에 있습니다.";
		}else {
			cs.streaming(dto);
		}
		return dto.getTitle()+"찜을 하셨습니다.";
	}


	@RequestMapping("/goCart")
	public String cartProc(HttpServletRequest request) {
		List<CartTradeDTO> tList = null;
		List<CartAuctionDTO> cList = null;

		int currentPage = 0;
		int currentPage1 = 0;
		int recordCountPerPage=3;

		String currentPageResult = request.getParameter("currentPage");
		String currentPageResult1 = request.getParameter("currentPage1");
		System.out.println("asd : "+currentPageResult1);
		if (currentPageResult != null) {
			currentPage = Integer.parseInt(currentPageResult);
		} else {
			currentPage = 1;
		}

		if (currentPageResult1 != null) {
			currentPage1 = Integer.parseInt(currentPageResult1);
		} else {
			currentPage1 = 1;
		}
		System.out.println("zxczx : "+currentPage1);
		int end = currentPage * recordCountPerPage;
		int start = end - (recordCountPerPage - 1);
		int end1 = currentPage1 * recordCountPerPage;
		int start1 = end1 - (recordCountPerPage - 1);
		tList = cs.tradeList(start, end,(String)session.getAttribute("email"));
		cList = cs.auctionList(start1, end1, (String)session.getAttribute("email"));
		// 페이징 버튼
		String tradeNavi = cs.tradeNavi(currentPage, recordCountPerPage);
		String auctionNavi = cs.auctionNavi(currentPage1, recordCountPerPage);
		/*request.setAttribute("recordTotalCount", list.size()); // 전체개수 */
		request.setAttribute("navi", tradeNavi);
		request.setAttribute("navi1", auctionNavi);
		session.setAttribute("tList", tList);
		session.setAttribute("cList", cList);
		return "cart";
	}
}
