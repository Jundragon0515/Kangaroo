package kh.spring.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.Used_transaction_boardDTO;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dto.Used_transaction_boardDTO;
import kh.spring.service.GoodsTradeService;


@Controller
public class TradeController {

   @Autowired
   private GoodsTradeService tradeService;

   @Autowired
   private HttpSession session;

   //직거래 게시판 처음
   @RequestMapping("/trade")
   public String direct(HttpServletRequest request) {
      
      session.setAttribute("selectCategory", "all");
      session.setAttribute("selectPrice", " ");
      session.setAttribute("selectView", "16");

      int currentPage = 0;
      int recordCountPerPage=16;
      List<Used_transaction_boardDTO> list = null;

      String currentPageResult = request.getParameter("currentPage");

      if (currentPageResult != null) {
         currentPage = Integer.parseInt(currentPageResult);
      } else {
         currentPage = 1;
      }
      int end = currentPage * recordCountPerPage;
      int start = end - (recordCountPerPage - 1);

      System.out.println("start" + start);
      System.out.println("end" + end);

      list = tradeService.directList(start, end);
      

      // 페이징 버튼
      String resultNavi = tradeService.directBoardNavi(currentPage, recordCountPerPage);
      /*request.setAttribute("recordTotalCount", list.size()); // 전체개수 */
        request.setAttribute("list", list);
       request.setAttribute("navi", resultNavi);
       return "trade";
   }
   
   //직거래 게시판 옵션선택
   @RequestMapping("/tradeOption")
   public String directList(HttpServletRequest request) {
      List<Used_transaction_boardDTO> list = null;
      String resultNavi = null;
      int currentPage = 0;
      String category = request.getParameter("category");
      String price = request.getParameter("price");
      String view = request.getParameter("view");
      String search = request.getParameter("search");
      
      String selectCategory = (String)session.getAttribute("selectCategory");
      String selectPrice = (String)session.getAttribute("selectPrice");
      String selectView = (String)session.getAttribute("selectView");
      String selectSearch = (String)session.getAttribute("selectSearch");
      
      if(category!=null) {
         session.setAttribute("selectCategory", category);
      }
      
      if(price!=null) {
         session.setAttribute("selectPrice", price);
      }
      if(view!=null) {
         session.setAttribute("selectView", view);
      }
	  if(search!=null) {
			System.out.println("검색어 :" +search);
			session.setAttribute("selectSearch", "and title like" + "'%" + search + "%'");
			String searchtext = (String)session.getAttribute("selectSearch");
		}
      
      if(selectCategory==null) {
         session.setAttribute("selectCategory", " ");  
      }else {
         tradeService.checkCategory(session);
      }
      
      if(selectPrice==null) {
         session.setAttribute("selectPrice"," "); 
      }else {
         tradeService.checkPrice(session);
      }
      if(selectView==null) {
         session.setAttribute("selectView", "16");
      }else {
         tradeService.checkView(session);
      }
      
      System.out.println("카테고리값 :" + selectCategory);
      System.out.println("가격 :" + selectPrice);
      System.out.println("정렬 : " + selectView);
      
      String currentPageResult = request.getParameter("currentPage");
      
      String count =(String)session.getAttribute("selectView");
      int recordCountPerPage= Integer.parseInt(count);
      
      if (currentPageResult != null) {
         currentPage = Integer.parseInt(currentPageResult);
      } else {
         currentPage = 1;
      }
      int end = currentPage * recordCountPerPage;
      int start = end - (recordCountPerPage - 1);
      
      System.out.println("컨트롤 start" + start);
      System.out.println("컨트롤 end" + end);
      
		if(search!=null) {
			list = tradeService.directList_search(session, start, end);
			resultNavi = tradeService.directBoardNavi_search(session, currentPage, recordCountPerPage);
			int listSize = list.size();
			
			if(listSize==0) {
				request.setAttribute("rsearch_result_null", "검색결과가 없습니다.");
			}
		}else {
			list = tradeService.directOption(session, start, end);
			resultNavi = tradeService.directBoardNaviOption(session, currentPage, recordCountPerPage);
		}

      /* request.setAttribute("recordTotalCount", list.size()); // 전체개수 */
      request.setAttribute("navi", resultNavi);
      request.setAttribute("list", list);

      return "trade";
   }
   
//   -------------------------------------------------------------------------------------------------------------------------------------------------
   
   //안전거래 게시판 처음
   @RequestMapping("/trade_safe")
   public String safe(HttpServletRequest request) {
      
      session.setAttribute("selectCategory", "all");
      session.setAttribute("selectPrice", " ");
      session.setAttribute("selectView", "16");

      int currentPage = 0;
      int recordCountPerPage=16;
      List<Used_transaction_boardDTO> list = null;

      String currentPageResult = request.getParameter("currentPage");

      if (currentPageResult != null) {
         currentPage = Integer.parseInt(currentPageResult);
      } else {
         currentPage = 1;
      }
      int end = currentPage * recordCountPerPage;
      int start = end - (recordCountPerPage - 1);

      System.out.println("start" + start);
      System.out.println("end" + end);

      list = tradeService.safeList(start, end);
      
      // 페이징 버튼
      String resultNavi = tradeService.safeBoardNavi(currentPage, recordCountPerPage);
      /*request.setAttribute("recordTotalCount", list.size()); // 전체개수 */
        request.setAttribute("list", list);
       request.setAttribute("navi", resultNavi);
       return "trade_safe";
   }
   
   //직거래 게시판 옵션선택
   @RequestMapping("/tradeOption_safe")
   public String safeList(HttpServletRequest request) {
      List<Used_transaction_boardDTO> list = null;
      String resultNavi = null;
      int currentPage = 0;
      String category = request.getParameter("category");
      String price = request.getParameter("price");
      String view = request.getParameter("view");
      String search = request.getParameter("search");

      String selectCategory = (String)session.getAttribute("selectCategory");
      String selectPrice = (String)session.getAttribute("selectPrice");
      String selectView = (String)session.getAttribute("selectView");
      String selectSearch = (String)session.getAttribute("selectSearch");
      
      if(category!=null) {
         session.setAttribute("selectCategory", category);
      }
      
      if(price!=null) {
         session.setAttribute("selectPrice", price);
      }
      if(view!=null) {
         session.setAttribute("selectView", view);
      }
      if(search!=null) {
    	  System.out.println("검색어 :" +search);
    	  session.setAttribute("selectSearch", "and title like" + "'%" + search + "%'");
    	  String searchtext = (String)session.getAttribute("selectSearch");
      }
      
      if(selectCategory==null) {
         session.setAttribute("selectCategory", " ");  
      }else {
         tradeService.checkCategory(session);
      }
      
      if(selectPrice==null) {
         session.setAttribute("selectPrice"," "); 
      }else {
         tradeService.checkPrice(session);
      }
      if(selectView==null) {
         session.setAttribute("selectView", "16");
      }else {
         tradeService.checkView(session);
      }
      
      System.out.println("카테고리값 :" + selectCategory);
      System.out.println("가격 :" + selectPrice);
      System.out.println("정렬 : " + selectView);
      
      String currentPageResult = request.getParameter("currentPage");
      
      String count =(String)session.getAttribute("selectView");
      int recordCountPerPage= Integer.parseInt(count);
      
      if (currentPageResult != null) {
         currentPage = Integer.parseInt(currentPageResult);
      } else {
         currentPage = 1;
      }
      int end = currentPage * recordCountPerPage;
      int start = end - (recordCountPerPage - 1);
      
      System.out.println("컨트롤 start" + start);
      System.out.println("컨트롤 end" + end);
      
		if(search!=null) {
			list = tradeService.safeList_search(session, start, end);
			resultNavi = tradeService.safeBoardNavi_search(session, currentPage, recordCountPerPage);
			int listSize = list.size();
			
			if(listSize==0) {
				request.setAttribute("rsearch_result_null", "검색결과가 없습니다.");
			}
		}else {
			list = tradeService.safeOption(session, start, end);
			resultNavi = tradeService.safeBoardNaviOption(session, currentPage, recordCountPerPage);
		}
		
      /* request.setAttribute("recordTotalCount", list.size()); // 전체개수 */
      request.setAttribute("navi", resultNavi);
      request.setAttribute("list", list);

      return "trade_safe";
   }

   @RequestMapping("/goodsTradeWrite")
   public String goodsTradeWrite() {
      return "goodsTradeWrite";
   }

}