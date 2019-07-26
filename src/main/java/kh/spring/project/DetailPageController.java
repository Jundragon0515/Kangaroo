package kh.spring.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kh.spring.dao.AuctionDAO;
import kh.spring.dao.DetailPageDAO;
import kh.spring.dao.GoodsTradeDAO;
import kh.spring.dao.MemberDAO;
import kh.spring.dto.Auction_boardDTO;
import kh.spring.dto.Auction_img_boardDTO;
import kh.spring.dto.CommentDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.dto.OrderDTO;
import kh.spring.dto.TenderDTO;
import kh.spring.dto.Used_transaction_boardDTO;
import kh.spring.dto.Used_transaction_img_boardDTO;
import kh.spring.service.MemberService;

@Controller
public class DetailPageController {
	@Autowired
	private DetailPageDAO dao;

	@Autowired
	private MemberDAO mdao;
	
	@Autowired
	private MemberService sdao;
	
	@Autowired
	private GoodsTradeDAO gtdao;
	
	@Autowired
	private AuctionDAO acdao;
	
	@Autowired
	HttpSession session;
	
	
	@RequestMapping("/topTender")
	@ResponseBody
	@Transactional("txManager")
	public void topTender(String boardNum, String seller) {
		
		TenderDTO dto = dao.topTender(Integer.parseInt(boardNum));
		
		int num = dto.getBoard_num();
		String title = dto.getBoard_title();
		String img = dto.getBoard_img();
		String buyer = dto.getId();
		int price = dto.getPoint();
		String type = "경매";
		
		OrderDTO odto = new OrderDTO();
		odto.setProduct_num(num);
		odto.setProduct_title(title);
		odto.setProduct_img(img);
		odto.setBuyer(buyer);
		odto.setPrice(price);
		odto.setType(type);
		odto.setSeller(seller);
		
		dao.buy(odto);
		
	}
	
	@RequestMapping("/timeStop")
	@ResponseBody
	public int stop(String boardNum) {
		
		System.out.println("2 테스트" + " : " + boardNum);
		return dao.soldOut_Auction(Integer.parseInt(boardNum));
		
	}
	
	
	@RequestMapping("/buy")
	@ResponseBody
	public int buy(HttpServletRequest request) {
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		int price = Integer.parseInt(request.getParameter("price"));
		String img = request.getParameter("img");
		String title = request.getParameter("title");
		String s_id = request.getParameter("s_id");
		String b_id = request.getParameter("b_id");
		String type = "거래";
		OrderDTO dto = new OrderDTO();
		
		dto.setProduct_num(boardNum);
		dto.setProduct_title(title);
		dto.setProduct_img(img);
		dto.setSeller(s_id);
		dto.setBuyer(b_id);
		dto.setPrice(price);
		dto.setType(type);
		
		int result = sdao.buy(dto);
		
		if(result>0) {
			
			return 1;
			
		}else {
			
			return 0;
		}
		
	}
	
	
	@RequestMapping("/used_detailPage")								// 중고 거래_상세 페이지
	public String used_detailPage(HttpServletRequest request) {
		int no = Integer.parseInt(request.getParameter("no"));
		Used_transaction_img_boardDTO i_dto = dao.u_i_selectByNo(no);	
		Used_transaction_boardDTO dto = dao.u_selectByNo(no);
		//조회수 올리기
		gtdao.viewCountUpdate(no);
		
		int currentPage = 1;

		String id = (String) session.getAttribute("email");
		if(id!=null) {
			request.setAttribute("myMoney", mdao.myMoney(id));
			}else {
				request.setAttribute("myMoney", 0);
			}
		
		
		if(request.getParameter("currentPage")!=null) {
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int boardNum = no;
		try {
			List<CommentDTO> result = mdao.commentList(currentPage, boardNum);
			
			request.setAttribute("list", result);
			request.setAttribute("getNavi", mdao.getNaviforComment(currentPage,no));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("i_dto", i_dto);
		request.setAttribute("dto", dto);
		return "used_detailPage";
	}

	@RequestMapping("/auction_detailPage")							// 경매_상세 페이지
	public String auction_detailPage(HttpServletRequest request) {
	      int no = Integer.parseInt(request.getParameter("no"));
	      Auction_img_boardDTO i_dto = dao.a_i_selectByNo(no);   
	      Auction_boardDTO dto = dao.a_selectByNo(no);
		  //조회수 올리기
		  acdao.viewCountUpdate(no);
	      int currentMoney = 0;
	      int currentPage = 1;
	      
	      if(request.getParameter("currentPage")!=null) {
	         currentPage=Integer.parseInt(request.getParameter("currentPage"));
	      }
	      
	      int boardNum = no;
	      try {
	         List<CommentDTO> result = mdao.commentList2(currentPage, boardNum);
	         try {
	         currentMoney = mdao.currentMoney(no);
	         System.out.println(currentMoney);
	         }catch(Exception e) {
	         }
	         
	         request.setAttribute("list", result);
	         request.setAttribute("getNavi", mdao.getNaviforComment2(currentPage,no));
	         String id = (String) session.getAttribute("email");

	         List<TenderDTO> rank = mdao.rank(no);// 1~5까지의 랭크
	         request.setAttribute("rank", rank);
	         request.setAttribute("currentMoney", currentMoney);
	         if((String) session.getAttribute("email")!=null) {
	         request.setAttribute("myMoney", mdao.myMoney(id));
	         }else {
	            request.setAttribute("myMoney", 0);
	         }
	         int tenderCount = dao.tenderCount(boardNum);
	         request.setAttribute("tenderCount", tenderCount);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      System.out.println("사진 확인용" + i_dto.getTitle_img());
	      request.setAttribute("i_dto", i_dto);
	      request.setAttribute("dto", dto);
	      return "auction_detailPage";
	}

	@RequestMapping("/deleteComment")
	@ResponseBody
	public String deleteComment(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String id = request.getParameter("name");
		
		CommentDTO dto = new CommentDTO();
		dto.setSeq(seq);
		dto.setId(id);
		
		return dao.deleteComment(dto)+"";
	}
	@RequestMapping("/a_deleteComment")
	@ResponseBody
	public String deleteComment2(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String id = request.getParameter("name");
		
		CommentDTO dto = new CommentDTO();
		dto.setSeq(seq);
		dto.setId(id);
		
		return dao.deleteComment2(dto)+"";
	}
	
	@RequestMapping("/tenderCount")
	@ResponseBody
	public String tender_c(HttpServletRequest request) {
		
		return dao.tenderCount(Integer.parseInt(request.getParameter("boardNum")))+""; 
		
	}
	
	//실시간 반응 현재가격
	@RequestMapping("/currentPrice")
	@ResponseBody
	public String currentPrice(HttpServletRequest request) {
		
		return dao.a_presentMoney(Integer.parseInt(request.getParameter("boardNum")))+""; 
		
	}
	
	@RequestMapping(value = "commentsTop5", produces = "application/text;charset=utf8")
	@ResponseBody
	public String comment5(HttpServletRequest request) {

		System.out.println("여기");
		// int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));

		List<CommentDTO> list = mdao.commentRank(boardNum);

		return new Gson().toJson(list);

	}
	@RequestMapping(value = "a_commentsTop5", produces = "application/text;charset=utf8")
	@ResponseBody
	public String comment52(HttpServletRequest request) {

		System.out.println("여기");
		// int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));

		List<CommentDTO> list = mdao.commentRank2(boardNum);

		return new Gson().toJson(list);

	}
//	@RequestMapping("commentsNavi")
//	@ResponseBody
//	public String commentsNavi(HttpServletRequest request) {
//
//		String navi = mdao.getNaviforComment((int) request.getAttribute("currentPage"));
//
//		return navi;
//
//	}

	@RequestMapping("comments")
	@ResponseBody
	public String comments(HttpServletRequest request) {

		// String id = request.getParameter("id");
		// int board_num = Integer.parseInt(request.getParameter("board_num"));
		String id = (String)session.getAttribute("email");
		int board_num = Integer.parseInt(request.getParameter("boardNum"));
		String ipaddress = request.getRemoteAddr();
		String msg = request.getParameter("msg");
		int currentPage1 = 1;

		MemberDTO mdto = mdao.selectById(id);
		String level = mdto.getMember_class();
		
		CommentDTO dto = new CommentDTO();
		dto.setId(id);
		dto.setBoardNum(board_num);
		dto.setIpaddress(ipaddress);
		dto.setContents(msg);
		dto.setMember_class(level);
		
		mdao.insertComment(dto);

		List<CommentDTO> contents = null;

		try {

			contents = mdao.commentList(currentPage1, board_num);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Gson().toJson(contents);
	}
	@RequestMapping("a_comment")
	@ResponseBody
	public String comments2(HttpServletRequest request) {

		
		System.out.println("여기까지");
		// String id = request.getParameter("id");
		// int board_num = Integer.parseInt(request.getParameter("board_num"));
		String id = (String)session.getAttribute("email");
		int board_num = Integer.parseInt(request.getParameter("boardNum"));
		String ipaddress = request.getRemoteAddr();
		String msg = request.getParameter("msg");
		int currentPage = 1;
		
		MemberDTO mdto = mdao.selectById(id);
		String level = mdto.getMember_class();
		
		CommentDTO dto = new CommentDTO();

		dto.setId(id);
		dto.setBoardNum(board_num);
		dto.setIpaddress(ipaddress);
		dto.setContents(msg);
		dto.setMember_class(level);
		
		System.out.println(dto.getId() + " : " + dto.getContents() + " : " + dto.getBoardNum());
		mdao.insertComment2(dto);

		List<CommentDTO> contents = null;

		try {

			contents = mdao.commentList2(currentPage, board_num);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Gson().toJson(contents);
	}
	// AJAX 입찰+랭크
		@RequestMapping("/tender")
		@ResponseBody
		public String tender(HttpServletRequest request) {

			int money = Integer.parseInt(request.getParameter("money"));
			String id = (String) session.getAttribute("email");
			String ipaddr = request.getRemoteAddr();
			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			String title = request.getParameter("title");
			String img = request.getParameter("img");
			
			System.out.println("입찰 정보 : " + money +  " : " + id + " :  " + ipaddr + " : " + boardNum + " : " + title  + " : "  +img);
			
			TenderDTO dto = new TenderDTO();

			dto.setBoard_num(boardNum);
			dto.setIpaddress(ipaddr);
			dto.setPoint(money);
			dto.setId(id);
			dto.setBoard_title(title);
			dto.setBoard_img(img);
			
			System.out.println(id);
			System.out.println(money);

			int result = mdao.selectMoney(dto);
			System.out.println(result);

			if (result>0) {
				try {
					sdao.tender(dto, boardNum);
				} catch (Exception e) {
					System.out.println("입찰 오류");
					e.printStackTrace();
				}
				;

				List<TenderDTO> rank = mdao.rank(boardNum);
				return new Gson().toJson(rank);

			} else {
				return null;
			}
		}

		@RequestMapping("/firstMoney")
		@ResponseBody
		public String firstMoney() {
			System.out.println("hereS");
			String firstMoney = mdao.currentMoney(1) + "";
			System.out.println(firstMoney);

			return firstMoney;
		}
	
}
