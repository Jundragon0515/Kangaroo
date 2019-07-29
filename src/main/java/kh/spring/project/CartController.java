package kh.spring.project;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dto.CartAuctionDTO;
import kh.spring.dto.CartTradeDTO;
import kh.spring.service.CartService;

@Controller
public class CartController {

	@Autowired
	private HttpSession session;

	@Autowired
	private CartService cs;
	@Autowired
	private TradeController tr; 
	@Autowired
	private AuctionController ar;

	@ResponseBody
	@RequestMapping(value="/steamingTrade" , produces="application/String;charset=UTF-8")
	public String streaming(CartTradeDTO dto) {
		String boardPersonId = dto.getId();//게시글쓴 id
		dto.setId((String) session.getAttribute("email"));
		if(boardPersonId.equals(dto.getId())) {
			return "자신의 글은 찜을 못합니다.";
		}else if(cs.overlapCheck(dto)==1) {
			return "찜 목록에 있습니다.";
		}	
		cs.streaming(dto);
		return dto.getTitle()+"을 찜 하셨습니다 .";		
	}
	@RequestMapping("ggymDelete")
	public String ggymDelete(HttpServletRequest request) {
		String[] value = request.getParameterValues("checkDelete");
		if(value!=null) {
			cs.cartTradeDelete(value);
		}
		return this.cartProc(request);
	}
	
	@RequestMapping("boardGgym")
	public String boardGym(CartTradeDTO dto,HttpServletRequest request,Model model)throws Exception {
		//PrintWriter out = response.getWriter();
		String boardPersonId = dto.getId();
		dto.setId((String) session.getAttribute("email"));
		if(boardPersonId.equals(dto.getId())) {
			//out.println("<script>alert('자신의 글은 찜을 못합니다.1');</script>");
			model.addAttribute("msg", "자신의 글은 찜을 못합니다.");
		}else if(cs.overlapCheck(dto)==1) {
			//out.println("<script>alert('찜 목록에 있습니다.');</script>");
			model.addAttribute("msg", "찜 목록에 있습니다.");
		}else {
			//out.println("<script>alert('"+dto.getTitle()+"을 찜 하셨습니다 .');</script>");
			cs.streaming(dto);	
			model.addAttribute("msg", dto.getTitle()+"을 찜 하셨습니다.");	
		}
		//out.flush();
		model.addAttribute("type","trade");
		return "boardGgymCheck";
	}

	@RequestMapping("boardGgymSafe")
	public String boardGymSafe(CartTradeDTO dto,HttpServletRequest request,Model model)throws Exception {
		String boardPersonId = dto.getId();
		dto.setId((String) session.getAttribute("email"));
		if(boardPersonId.equals(dto.getId())) {
			model.addAttribute("msg", "자신의 글은 찜을 못합니다.");
		}else if(cs.overlapCheck(dto)==1) {
			model.addAttribute("msg", "찜 목록에 있습니다.");
		}else {
			cs.streaming(dto);
			model.addAttribute("msg", dto.getTitle()+"을 찜 하셨습니다.");
		}
		model.addAttribute("type", "safe");
		return "boardGgymCheck";
	}

	@RequestMapping("boardGgymAuction")
	public String boardGgymAuction(CartAuctionDTO dto,HttpServletRequest request,Model model)throws Exception {
		String boardPersonId = dto.getId();
		System.out.println(boardPersonId);
		dto.setId((String) session.getAttribute("email"));
		System.out.println(dto.getId());
		System.out.println(dto.getNo());
		System.out.println(dto.getTitle_img());
		System.out.println(dto.getTitle());
		System.out.println(dto.getEnd_date());
		System.out.println(dto.getCategory());
		System.out.println(dto.getPrice());
		if(boardPersonId.equals(dto.getId())) {
			model.addAttribute("msg", "자신의 글은 찜을 못합니다.");
		}else if(cs.overplapCheckAuction(dto)==1) {
			model.addAttribute("msg", "찜 목록에 있습니다.");
		}else {
			cs.streamingAuction(dto);
			model.addAttribute("msg", dto.getTitle()+"을 찜 하셨습니다.");
		}
		model.addAttribute("type", "auction");
		return "boardGgymCheck";
	}

	@ResponseBody
	@RequestMapping(value="/steamingAuction", produces="application/String;charset=UTF-8")
	public String streamingAuction(CartAuctionDTO dto) {
		String boardPersonId = dto.getId();
		dto.setId((String) session.getAttribute("email"));
		if(boardPersonId.equals(dto.getId())) {
			return "자신의 글은 찜을 못합니다.";
		}else if(cs.overplapCheckAuction(dto)==1) {
			return "찜 목록에 있습니다.";
		}
		cs.streamingAuction(dto);
		return dto.getTitle()+"을 찜 하셨습니다 .";
	}
	@RequestMapping("ggymDeleteAuction")
	public String ggymDeleteAuction(HttpServletRequest request) {
		String[] value = request.getParameterValues("checkDeleteAuction");
		if(value!=null) {
			cs.cartAuctionDelete(value);
		}
		return this.cartProc(request);
	}

	@RequestMapping("/goCart")
	public String cartProc(HttpServletRequest request) {
		List<CartTradeDTO> tList = null;
		List<CartAuctionDTO> cList = null;

		int currentPage = 0;
		int currentPage1 = 0;
		int recordCountPerPage=3;
		int recordCountPerPage1=3;
		String currentPageResult = request.getParameter("currentPage");
		if (currentPageResult != null) {
			currentPage = Integer.parseInt(currentPageResult);
		} else {
			currentPage = 1;
		}

		int end = currentPage * recordCountPerPage;
		int start = end - (recordCountPerPage - 1);
		String currentPageResult1 = request.getParameter("currentPage1");
		if (currentPageResult1 != null) {
			currentPage1 = Integer.parseInt(currentPageResult1);
		} else {
			currentPage1 = 1;
		}
		int end1 = currentPage1 * recordCountPerPage1;
		int start1 = end1 - (recordCountPerPage1 - 1);
		try {
		tList = cs.tradeList(start, end,(String)session.getAttribute("email"));
		cList = cs.auctionList(start1, end1, (String)session.getAttribute("email"));
		// 페이징 버튼
		String tradeNavi = cs.tradeNavi(currentPage, recordCountPerPage);
		String auctionNavi = cs.auctionNavi(currentPage1, recordCountPerPage1);
		request.setAttribute("navi", tradeNavi);
		request.setAttribute("navi1", auctionNavi);
		session.setAttribute("tList", tList);
		session.setAttribute("cList", cList);
		}catch(Exception e) {
			e.printStackTrace();
			return "index";
		}
		/*request.setAttribute("recordTotalCount", list.size()); // 전체개수 */
		
		return "cart";
	}
}
