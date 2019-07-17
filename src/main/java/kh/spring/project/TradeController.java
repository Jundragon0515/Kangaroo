package kh.spring.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dto.GoodsTradeDTO;
import kh.spring.service.GoodsTradeService;


@Controller
public class TradeController {

   @Autowired
   private GoodsTradeService tradeService;

   @Autowired
   private HttpSession session;
   @RequestMapping("/trade")
   public String index(HttpServletRequest request) {
      
      int currentPage = 0;
      int recordCountPerPage = 16; // 한 페이지에 보여줄 개수

      List<GoodsTradeDTO> list = null;
      String price = request.getParameter("price");
      
      if(price!=null) {
         session.setAttribute("price", price);
      }
      
      String currentPageResult = request.getParameter("currentPage");
      String view = (String)request.getAttribute("view");

      if(currentPageResult!=null) {
         currentPage = Integer.parseInt(currentPageResult);
      }else {
         currentPage = 1;
      }
      int end = currentPage * recordCountPerPage;
      int start = end - (recordCountPerPage-1);

      System.out.println("start" + start);
      System.out.println("end" + end);

      //낮은가격순 or 높은가격순
      if(session.getAttribute("price")==null) {
         list = tradeService.tradeList(start, end);
      }else {
         list = tradeService.tradeListPrice(start, end, (String)session.getAttribute("price"));
      }

      //페이징 버튼
      String resultNavi = tradeService.tradeBoardNavi(currentPage, recordCountPerPage);
      	request.setAttribute("recordTotalCount", list.size()); // 전체개수
      	request.setAttribute("list", list);
      	request.setAttribute("navi", resultNavi);
      	request.setAttribute("view", view);
      	request.setAttribute("price", price);
      return "trade";
   }

   @RequestMapping("/tradeList")
   public String indexList(HttpServletRequest request) {
      
      int currentPage = 0;
      int recordCountPerPage = 0; // 한 페이지에 보여줄 개수
      List<GoodsTradeDTO> list = null;
      String view = request.getParameter("view");
      String price = (String)session.getAttribute("price");
      String currentPageResult = request.getParameter("currentPage");
      System.out.println(view);
      System.out.println(currentPageResult);
      
      recordCountPerPage = Integer.parseInt(view);
      
      if(currentPageResult!=null) {
         currentPage = Integer.parseInt(currentPageResult);
      }else {
         currentPage = 1;
      }
      int end = currentPage * recordCountPerPage;
      int start = end - (recordCountPerPage-1);

      if(price==null) {
         list = tradeService.tradeList(start, end);
      }else {
         list = tradeService.tradeListPrice(start, end, price);
      }
      //페이징 버튼
      if(price==null) {
         String resultNavi = tradeService.tradeBoardNaviView(currentPage, recordCountPerPage,recordCountPerPage);
         request.setAttribute("navi", resultNavi);
      }else {
      String resultNavi = tradeService.tradeBoardNaviView(currentPage, recordCountPerPage,recordCountPerPage,price);
      request.setAttribute("navi", resultNavi);
      }
      
      request.setAttribute("view", view);
      request.setAttribute("recordTotalCount", list.size());
      request.setAttribute("list", list);

      return "trade";
   }


}