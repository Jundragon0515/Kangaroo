package kh.spring.project;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dao.AdminDAO;
import kh.spring.dto.Auction_boardDTO;
import kh.spring.service.AuctionService;




@Controller
public class AuctionController {

   @Autowired
   private AuctionService auctionService;

   @Autowired
   private HttpSession session;
   
   @Autowired
   private AdminDAO adao;

   @RequestMapping("/auction")
   public String index(HttpServletRequest request) {

      session.setAttribute("selectCategory", "all");
      session.setAttribute("selectPrice", " ");
      session.setAttribute("selectView", "12");


      int currentPage = 0;
      int recordCountPerPage=12;
      List<Auction_boardDTO> list = null;

      String currentPageResult = request.getParameter("currentPage");
      
      if (currentPageResult!=null ) {
         currentPage = Integer.parseInt(currentPageResult);
         session.setAttribute("auction_currentpage", currentPageResult);
      } else {
         currentPage = 1;
         session.setAttribute("auction_currentpage", currentPage);
      }
      int end = currentPage * recordCountPerPage;
      int start = end - (recordCountPerPage - 1);

      System.out.println("start" + start);
      System.out.println("end" + end);

      list = auctionService.auctionList(start, end);

      // 페이징 버튼
      String resultNavi = auctionService.auctionBoardNavi(currentPage, recordCountPerPage);
      /*request.setAttribute("recordTotalCount", list.size()); // 전체개수 */
        request.setAttribute("list", list);
       request.setAttribute("navi", resultNavi);
       
       request.setAttribute("auctionActiveCount", adao.auctionActiveCount());            // 활성화된 경매  수
      request.setAttribute("totalCount", adao.auctionCount()+adao.directTradeCount()+adao.safeTradeCount());   // 총 거래량
       return "auction";
   }

   @RequestMapping("/auctionOption")
   public String indexList(HttpServletRequest request) {
      List<Auction_boardDTO> list = null;
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
         session.setAttribute("selectSearch", "where title like" + "'%" + search + "%'");
         String searchtext = (String)session.getAttribute("selectSearch");
      }
      
      if(selectCategory==null) {
         session.setAttribute("selectCategory", " ");  
      }else {
         auctionService.checkCategory(session);
      }
      
      if(selectPrice==null) {
         session.setAttribute("selectPrice"," "); 
      }else {
         auctionService.checkPrice(session);
      }
      if(selectView==null) {
         session.setAttribute("selectView", "12");
      }else {
         auctionService.checkView(session);
      }
      
      System.out.println("카테고리값 :" + selectCategory);
      System.out.println("가격 :" + selectPrice);
      System.out.println("정렬 : " + selectView);
      
      String currentPageResult = request.getParameter("currentPage");
      
      String count =(String)session.getAttribute("selectView");
      int recordCountPerPage= Integer.parseInt(count);
      
      if (currentPageResult != null) {
         currentPage = Integer.parseInt(currentPageResult);
         session.setAttribute("auc_currentpage", currentPageResult);
      } else {
         currentPage = 1;
         session.setAttribute("auc_currentpage", currentPage);
      }
      int end = currentPage * recordCountPerPage;
      int start = end - (recordCountPerPage - 1);
      
      System.out.println("컨트롤 start" + start);
      System.out.println("컨트롤 end" + end);
      

      if(search!=null) {
         list = auctionService.auctionList_search(session, start, end);
         resultNavi = auctionService.auctionBoardNavi_search(session, currentPage, recordCountPerPage);
         int listSize = list.size();
         
         if(listSize==0) {
            request.setAttribute("rsearch_result_null", "검색결과가 없습니다.");
         }
      }else {
         list = auctionService.auctionOption(session, start, end);
         resultNavi = auctionService.auctionBoardNaviOption(session, currentPage, recordCountPerPage);
      }
      /* request.setAttribute("recordTotalCount", list.size()); // 전체개수 */
      request.setAttribute("navi", resultNavi);
      request.setAttribute("list", list);
      
      request.setAttribute("auctionActiveCount", adao.auctionActiveCount());            // 활성화된 경매  수
      request.setAttribute("totalCount", adao.auctionCount()+adao.directTradeCount()+adao.safeTradeCount());   // 총 거래량

      return "auction";
   }

/*   @RequestMapping("/auctionWrite")
   public String auctionWrite() {
      return "auctionWrite";
   }*/

}