package kh.spring.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.Used_transaction_boardDTO;
import kh.spring.dto.GoodsTradeDTO;


@Repository
public class GoodsTradeDAO {
   
   @Autowired
   private HttpSession session;

   @Autowired
   private SqlSessionTemplate sst;
   // 카테고리 설정값
   public void checkCategory(HttpSession session) {
      String category = (String)session.getAttribute("selectCategory");
      System.out.println("DAO설정값" + category);
      
      if(category.equals("art") || category.equals("and category='미술품'")) {
         session.setAttribute("selectCategory", "and category='미술품'");
      }else if(category.equals("book") || category.equals("and category='도서'")) {
         session.setAttribute("selectCategory", "and category='도서'");
      }else if(category.equals("electric")|| category.equals("and category='가전제품'")) {
         session.setAttribute("selectCategory", "and category='가전제품'");
      }else if(category.equals("hobby")|| category.equals("and category='취미/수집'")) {
         session.setAttribute("selectCategory", "and category='취미/수집'");
      }else if(category.equals("life")|| category.equals("and category='생활용품'")) {
         session.setAttribute("selectCategory", "and category='생활용품'");
      }else if(category.equals("sports")|| category.equals("and category='스포츠/레저'")) {
         session.setAttribute("selectCategory", "and category='스포츠/레저'");
      }else if(category.equals("etc")|| category.equals("and category='기타'")) {
         session.setAttribute("selectCategory", "and category='기타'");
      }else {
         session.setAttribute("selectCategory", " ");
      }
   }
   
   
   
   // n개씩 보기 개수 설정
   public void checkView(HttpSession session) {
      String view =(String)session.getAttribute("selectView");
      if(view.equals("16")) {
         session.setAttribute("selectView", "16");
      }else if(view.equals("24")) {
         session.setAttribute("selectView", "24");
      }else if(view.equals("32")) {
         session.setAttribute("selectView", "32");
      }else {
         session.setAttribute("selectView", "16");
      }
   }
   
   // 낮은가격순 OR 높은가격순 설정
   public void checkPrice(HttpSession session) {
      String price = (String)session.getAttribute("selectPrice");
      if(price.equals("low")) {
         session.setAttribute("selectPrice", "asc");
      }else if(price.equals("high")){
         session.setAttribute("selectPrice", "desc");
      }else {
         session.setAttribute("selectPrice", " ");
      }
   }
   
   //직거래 게시판 옵션 list
   public List<Used_transaction_boardDTO> directOption(HttpSession session, int start, int end){
      HashMap<String, String> param = new HashMap<>();
      String startNum = Integer.toString(start);
      String endNum = Integer.toString(end);
      String selectCategory = (String)session.getAttribute("selectCategory");
      String selectPrice = (String)session.getAttribute("selectPrice");
      
      System.out.println("category " + selectCategory);
      System.out.println("price " + selectPrice);
      System.out.println("start" + startNum);
      System.out.println("end" + endNum);
      
         param.put("category", selectCategory);
         param.put("price", selectPrice);
         param.put("start", startNum);
         param.put("end", endNum);
         
   return sst.selectList("GoodsTradeDAO.directPrice", param);
      
   }
   
   //직거래 게시판 처음 list
   public List<Used_transaction_boardDTO> directList(int start, int end){
      HashMap<String, Object> param = new HashMap<>();
      param.put("start", start);
      param.put("end", end);
      return sst.selectList("GoodsTradeDAO.directList",param);
   }
   
   //직거래 게시판 전체개수
   public int recordTotalCount_direct() {
      return sst.selectOne("GoodsTradeDAO.recordTotalCount_direct");
   }
   
   //직거래 게시판 옵션 선택개수
   public int recordTotalCountOption_direct(HttpSession session) {
      String selectCategory = (String)session.getAttribute("selectCategory");
      HashMap<String, String> param = new HashMap<>();
      param.put("category", selectCategory);
      return sst.selectOne("GoodsTradeDAO.recordTotalCountOption_direct");
   }
  
   
   //직거래 게시판 첫화면 네비메뉴
   public String getNavi_direct(int currentPage, int recordCountPerPage) {
      int recordTotalCount = this.recordTotalCount_direct(); //레코드 수
      int naviCountPerPage = 5; // 한 페이지 네비 개수
      int pageTotalCount=0;

      if(recordTotalCount % recordCountPerPage > 0) {
         pageTotalCount = recordTotalCount / recordCountPerPage + 1;
      }else {
         pageTotalCount = recordTotalCount / recordCountPerPage;
      }

      if(currentPage < 1) {
         currentPage = 1;
      }else if(currentPage > pageTotalCount) {
         currentPage = pageTotalCount;
      }


      int startNavi = (currentPage -1) / naviCountPerPage * naviCountPerPage + 1;
      int endNavi = startNavi + (naviCountPerPage-1);
      // 현재 위치에 따른 네비 시작과 끝을 구하기

      if(endNavi > pageTotalCount) {
         endNavi = pageTotalCount;
      }
      //네비 끝값이 최대 페이지 번호를 넘어가면 최대 페이지번호로 네비 끝값을 설정한다.
      boolean needPrev = true;
      boolean needNext = true;

      if(startNavi == 1) {
         needPrev=false;
      }

      if(endNavi == pageTotalCount) {
         needNext = false;
      }
      
      
      StringBuilder sb = new StringBuilder();
      String bootTag = "<button type='button' class='btn btn-outline-secondary'>";
      String link = "<a href='trade?currentPage=";
      
      if(needPrev) {
         int prev = startNavi -1;
         sb.append(link + prev + "'" + ">" + bootTag + "<< Prev " + "</button></a>");
      }

      for(int i = startNavi; i <= endNavi; i++) {
         sb.append(link + i + "'" + ">" + bootTag + i + "</button></a>");
      }
      
      if(needNext) {
         int next = endNavi + 1;
         sb.append(link + next + "'" + ">" + bootTag + " Next >> " + "</button></a>");
      }
      return sb.toString();
   }
   
   //직거래 게시판 옵션 선택 후 네비메뉴
   public String getNaviOption_direct(HttpSession session, int currentPage, int recordCountPerPage) {
      int recordTotalCount = this.recordTotalCountOption_direct(session); //레코드 수
      int naviCountPerPage = 5; // 한 페이지 네비 개수
      int pageTotalCount=0;

      if(recordTotalCount % recordCountPerPage > 0) {
         pageTotalCount = recordTotalCount / recordCountPerPage + 1;
      }else {
         pageTotalCount = recordTotalCount / recordCountPerPage;
      }

      if(currentPage < 1) {
         currentPage = 1;
      }else if(currentPage > pageTotalCount) {
         currentPage = pageTotalCount;
      }


      int startNavi = (currentPage -1) / naviCountPerPage * naviCountPerPage + 1;
      int endNavi = startNavi + (naviCountPerPage-1);
      // 현재 위치에 따른 네비 시작과 끝을 구하기

      if(endNavi > pageTotalCount) {
         endNavi = pageTotalCount;
      }
      //네비 끝값이 최대 페이지 번호를 넘어가면 최대 페이지번호로 네비 끝값을 설정한다.
      boolean needPrev = true;
      boolean needNext = true;

      if(startNavi == 1) {
         needPrev=false;
      }

      if(endNavi == pageTotalCount) {
         needNext = false;
      }
      
      
      StringBuilder sb = new StringBuilder();
      String bootTag = "<button type='button' class='btn btn-outline-secondary'>";
      String link = "<a href='tradeOption?currentPage=";
      
      if(needPrev) {
         int prev = startNavi -1;
         sb.append(link + prev + "'" + ">" + bootTag + "<< Prev " + "</button></a>");
      }

      for(int i = startNavi; i <= endNavi; i++) {
         sb.append(link + i + "'" + ">" + bootTag + i + "</button></a>");
      }
      
      if(needNext) {
         int next = endNavi + 1;
         sb.append(link + next + "'" + ">" + bootTag + " Next >> " + "</button></a>");
      }
      return sb.toString();
   }
   
   //안전거래 게시판 옵션 list
   public List<Used_transaction_boardDTO> safeOption(HttpSession session, int start, int end){
      HashMap<String, String> param = new HashMap<>();
      String startNum = Integer.toString(start);
      String endNum = Integer.toString(end);
      String selectCategory = (String)session.getAttribute("selectCategory");
      String selectPrice = (String)session.getAttribute("selectPrice");
      
      System.out.println("category " + selectCategory);
      System.out.println("price " + selectPrice);
      System.out.println("start" + startNum);
      System.out.println("end" + endNum);
      
         param.put("category", selectCategory);
         param.put("price", selectPrice);
         param.put("start", startNum);
         param.put("end", endNum);
         
   return sst.selectList("GoodsTradeDAO.safePrice", param);
      
   }
   
   //안전거래 게시판 처음 list
   public List<Used_transaction_boardDTO> safeList(int start, int end){
      HashMap<String, Object> param = new HashMap<>();
      param.put("start", start);
      param.put("end", end);
      return sst.selectList("GoodsTradeDAO.safeList",param);
   }
   
   //안전거래 게시판 전체개수
   public int recordTotalCount_safe() {
      return sst.selectOne("GoodsTradeDAO.recordTotalCount_safe");
   }
   
   //안전거래 게시판 옵션 선택개수
   public int recordTotalCountOption_safe(HttpSession session) {
      String selectCategory = (String)session.getAttribute("selectCategory");
      HashMap<String, String> param = new HashMap<>();
      param.put("category", selectCategory);
      return sst.selectOne("GoodsTradeDAO.recordTotalCountOption_safe");
   }
   
   //안전거래 게시판 첫화면 네비메뉴
   public String getNavi_safe(int currentPage, int recordCountPerPage) {
      int recordTotalCount = this.recordTotalCount_safe(); //레코드 수
      int naviCountPerPage = 5; // 한 페이지 네비 개수
      int pageTotalCount=0;

      if(recordTotalCount % recordCountPerPage > 0) {
         pageTotalCount = recordTotalCount / recordCountPerPage + 1;
      }else {
         pageTotalCount = recordTotalCount / recordCountPerPage;
      }

      if(currentPage < 1) {
         currentPage = 1;
      }else if(currentPage > pageTotalCount) {
         currentPage = pageTotalCount;
      }


      int startNavi = (currentPage -1) / naviCountPerPage * naviCountPerPage + 1;
      int endNavi = startNavi + (naviCountPerPage-1);
      // 현재 위치에 따른 네비 시작과 끝을 구하기

      if(endNavi > pageTotalCount) {
         endNavi = pageTotalCount;
      }
      //네비 끝값이 최대 페이지 번호를 넘어가면 최대 페이지번호로 네비 끝값을 설정한다.
      boolean needPrev = true;
      boolean needNext = true;

      if(startNavi == 1) {
         needPrev=false;
      }

      if(endNavi == pageTotalCount) {
         needNext = false;
      }
      
      
      StringBuilder sb = new StringBuilder();
      String bootTag = "<button type='button' class='btn btn-outline-secondary'>";
      String link = "<a href='trade_safe?currentPage=";
      
      if(needPrev) {
         int prev = startNavi -1;
         sb.append(link + prev + "'" + ">" + bootTag + "<< Prev " + "</button></a>");
      }

      for(int i = startNavi; i <= endNavi; i++) {
         sb.append(link + i + "'" + ">" + bootTag + i + "</button></a>");
      }
      
      if(needNext) {
         int next = endNavi + 1;
         sb.append(link + next + "'" + ">" + bootTag + " Next >> " + "</button></a>");
      }
      return sb.toString();
   }
   
   //안전거래 게시판 옵션 선택 후 네비메뉴
   public String getNaviOption_safe(HttpSession session, int currentPage, int recordCountPerPage) {
      int recordTotalCount = this.recordTotalCountOption_safe(session); //레코드 수
      int naviCountPerPage = 5; // 한 페이지 네비 개수
      int pageTotalCount=0;

      if(recordTotalCount % recordCountPerPage > 0) {
         pageTotalCount = recordTotalCount / recordCountPerPage + 1;
      }else {
         pageTotalCount = recordTotalCount / recordCountPerPage;
      }

      if(currentPage < 1) {
         currentPage = 1;
      }else if(currentPage > pageTotalCount) {
         currentPage = pageTotalCount;
      }


      int startNavi = (currentPage -1) / naviCountPerPage * naviCountPerPage + 1;
      int endNavi = startNavi + (naviCountPerPage-1);
      // 현재 위치에 따른 네비 시작과 끝을 구하기

      if(endNavi > pageTotalCount) {
         endNavi = pageTotalCount;
      }
      //네비 끝값이 최대 페이지 번호를 넘어가면 최대 페이지번호로 네비 끝값을 설정한다.
      boolean needPrev = true;
      boolean needNext = true;

      if(startNavi == 1) {
         needPrev=false;
      }

      if(endNavi == pageTotalCount) {
         needNext = false;
      }
      
      
      StringBuilder sb = new StringBuilder();
      String bootTag = "<button type='button' class='btn btn-outline-secondary'>";
      String link = "<a href='tradeOption_safe?currentPage=";
      
      if(needPrev) {
         int prev = startNavi -1;
         sb.append(link + prev + "'" + ">" + bootTag + "<< Prev " + "</button></a>");
      }

      for(int i = startNavi; i <= endNavi; i++) {
         sb.append(link + i + "'" + ">" + bootTag + i + "</button></a>");
      }
      
      if(needNext) {
         int next = endNavi + 1;
         sb.append(link + next + "'" + ">" + bootTag + " Next >> " + "</button></a>");
      }
      return sb.toString();
   }
   
//   public String getNaviView(int currentPage, int recordCountPerPage, String price) {
//      int recordTotalCount = this.recordTotalCount(); //레코드 수
//      int naviCountPerPage = 5; // 한 페이지 네비 개수
//      int pageTotalCount=0;
//
//      if(recordTotalCount % recordCountPerPage > 0) {
//         pageTotalCount = recordTotalCount / recordCountPerPage + 1;
//      }else {
//         pageTotalCount = recordTotalCount / recordCountPerPage;
//      }
//
//      if(currentPage < 1) {
//         currentPage = 1;
//      }else if(currentPage > pageTotalCount) {
//         currentPage = pageTotalCount;
//      }
//
//
//      int startNavi = (currentPage -1) / naviCountPerPage * naviCountPerPage + 1;
//      int endNavi = startNavi + (naviCountPerPage-1);
//      // 현재 위치에 따른 네비 시작과 끝을 구하기
//
//      if(endNavi > pageTotalCount) {
//         endNavi = pageTotalCount;
//      }
//      //네비 끝값이 최대 페이지 번호를 넘어가면 최대 페이지번호로 네비 끝값을 설정한다.
//
//
//      boolean needPrev = true;
//      boolean needNext = true;
//
//      if(startNavi == 1) {
//         needPrev=false;
//      }
//
//      if(endNavi == pageTotalCount) {
//         needNext = false;
//      }
//      
//      
//      StringBuilder sb = new StringBuilder();
//      String bootTag = "<button type='button' class='btn btn-outline-secondary'>";
//      String link = "<a href='index?currentPage=";
//      
//      if(needPrev) {
//         int prev = startNavi -1;
//         sb.append(link + prev + "&price=" + price + "'" + ">" + bootTag + "<< Prev " + "</button></a>");
//      }
//
//      for(int i = startNavi; i <= endNavi; i++) {
//         sb.append(link + i + "&price=" + price + "'" + ">" + bootTag + i + "</button></a>");
//      }
//      
//      if(needNext) {
//         int next = endNavi + 1;
//         sb.append(link + next + "'" + "&price=" + price + ">" + bootTag + " Next >> " + "</button></a>");
//      }
//      return sb.toString();
//   }
   
   
   
   
   
}