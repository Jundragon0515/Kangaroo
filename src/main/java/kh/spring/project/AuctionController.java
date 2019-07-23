package kh.spring.project;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.Auction_boardDTO;
import kh.spring.service.AuctionService;




@Controller
public class AuctionController {

   @Autowired
   private AuctionService auctionService;

   @Autowired
   private HttpSession session;

   @RequestMapping("/auction")
   public String index(HttpServletRequest request) {

      session.removeAttribute("selectCategory");
      session.removeAttribute("selectPrice");
      session.removeAttribute("selectView");


      int currentPage = 0;
      int recordCountPerPage=16;
      List<Auction_boardDTO> list = null;

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

      list = auctionService.auctionList(start, end);

      // 페이징 버튼
      String resultNavi = auctionService.tradeBoardNavi(currentPage, recordCountPerPage);
      /*request.setAttribute("recordTotalCount", list.size()); // 전체개수 */
        request.setAttribute("list", list);
       request.setAttribute("navi", resultNavi);
       return "auction";
   }

   @RequestMapping("/auctionOption")
   public String indexList(HttpServletRequest request) {
      List<Auction_boardDTO> list = null;
      int currentPage = 0;
      String category = request.getParameter("category");
      String price = request.getParameter("price");
      String view = request.getParameter("view");

      String selectCategory = (String)session.getAttribute("selectCategory");
      String selectPrice = (String)session.getAttribute("selectPrice");
      String selectView = (String)session.getAttribute("selectView");
      
      
      if(category!=null) {
         session.setAttribute("selectCategory", category);
      }
      
      if(price!=null) {
         session.setAttribute("selectPrice", price);
      }
      if(view!=null) {
         session.setAttribute("selectView", view);
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
         session.setAttribute("selectView", "16");
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
      } else {
         currentPage = 1;
      }
      int end = currentPage * recordCountPerPage;
      int start = end - (recordCountPerPage - 1);
      
      System.out.println("컨트롤 start" + start);
      System.out.println("컨트롤 end" + end);
      list = auctionService.selectOption(session, start, end);




      String resultNavi = auctionService.tradeBoardNaviOption(session, currentPage, recordCountPerPage);
      /* request.setAttribute("recordTotalCount", list.size()); // 전체개수 */
      request.setAttribute("navi", resultNavi);
      request.setAttribute("list", list);

      return "trade";
   }

/*   @RequestMapping("/auctionWrite")
   public String auctionWrite() {
      return "auctionWrite";
   }*/

}