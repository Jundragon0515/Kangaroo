package kh.spring.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.Auction_boardDTO;



@Repository
public class AuctionDAO {
   
   @Autowired
   private HttpSession session;

   @Autowired
   private SqlSessionTemplate sst;
   
   //경매 기본 네비코드
   public String naviAuctionCode(int currentPage, int recordCountPerPage, int recordTotalCount) {
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
	      String link = "<a href='auction?currentPage=";
	      
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
   
   //경매 옵션선택 네비코드
   public String naviAuctionOptionCode(int currentPage, int recordCountPerPage, int recordTotalCount) {
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
	      String link = "<a href='auctionOption?currentPage=";
	      
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
   
   
   
   
   // 카테고리 설정값
   public void checkCategory(HttpSession session) {

      String category = (String)session.getAttribute("selectCategory");
      System.out.println("DAO설정값" + category);
      
      if(category.equals("art") || category.equals("where category='미술품'")) {
         session.setAttribute("selectCategory", "where category='미술품'");
      }else if(category.equals("book") || category.equals("where category='도서'")) {
         session.setAttribute("selectCategory", "where category='도서'");
      }else if(category.equals("electric")|| category.equals("where category='가전제품'")) {
         session.setAttribute("selectCategory", "where category='가전제품'");
      }else if(category.equals("hobby")|| category.equals("where category='취미/수집'")) {
         session.setAttribute("selectCategory", "where category='취미/수집'");
      }else if(category.equals("life")|| category.equals("where category='생활용품'")) {
         session.setAttribute("selectCategory", "where category='생활용품'");
      }else if(category.equals("sports")|| category.equals("where category='스포츠/레저'")) {
         session.setAttribute("selectCategory", "where category='스포츠/레저'");
      }else if(category.equals("etc")|| category.equals("where category='기타'")) {
         session.setAttribute("selectCategory", "where category='기타'");
      }else {
         session.setAttribute("selectCategory", " ");
      }

   }
   
   
   
   // n개씩 보기 개수 설정
   public void checkView(HttpSession session) {
      String view =(String)session.getAttribute("selectView");
      if(view.equals("12")) {
         session.setAttribute("selectView", "12");
      }else if(view.equals("16")) {
         session.setAttribute("selectView", "16");
      }else if(view.equals("20")) {
         session.setAttribute("selectView", "20");
      }else {
         session.setAttribute("selectView", "12");
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
   //옵션선택
   public List<Auction_boardDTO> auctionOption(HttpSession session, int start, int end){
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
         
   return sst.selectList("AuctionDAO.auctionPrice", param);

   }
   
   //처음 화면
   public List<Auction_boardDTO> auctionList(int start, int end){
      HashMap<String, Object> param = new HashMap<>();
      param.put("start", start);
      param.put("end", end);
      return sst.selectList("AuctionDAO.auctionList",param);
   }
   
   
   public String boardMainImg(int no) {
      return sst.selectOne("AuctionDAO.boardMainImg", no);
   }
   
   public int delete() {
      return sst.delete("AuctionDAO.delete");
   }
   
   //경매게시판 전체 카운트
   public int recordTotalCount() {
      return sst.selectOne("AuctionDAO.recordTotalCount");
   }
   //경매게시판 옵션 카운트
   public int recordTotalCountOption(HttpSession session) {
      String selectCategory = (String)session.getAttribute("selectCategory");
      HashMap<String, String> param = new HashMap<>();
      param.put("category", selectCategory);
      return sst.selectOne("AuctionDAO.recordTotalCountOption");
      }
   
   //경매 게시판 첫화면 네비메뉴
   public String getNavi(int currentPage, int recordCountPerPage) {
      int recordTotalCount = this.recordTotalCount(); //레코드 수
     String result =  this.naviAuctionCode(currentPage, recordCountPerPage, recordTotalCount);
     return result;
   }
   
   //경매 게시판 옵션 선택 후 네비메뉴
   public String getNaviOption(HttpSession session, int currentPage, int recordCountPerPage) {
      int recordTotalCount = this.recordTotalCountOption(session); //레코드 수
      String result = this.naviAuctionOptionCode(currentPage, recordCountPerPage, recordTotalCount);
      return result;
   }
   
   
   //경매게시판 검색 전체개수
   public int recordTotalCount_auction_search(HttpSession session) {
	   		String selectSearch = (String)session.getAttribute("selectSearch");
	   		HashMap<String, String> param = new HashMap<>();
	   		param.put("search", selectSearch);
	      return sst.selectOne("AuctionDAO.recordTotalCount_auction_search", param);
	   }
   
   //경매게시판 검색어
   public List<Auction_boardDTO> auctionList_search(HttpSession session, int start, int end){
	   HashMap<String, String> param = new HashMap<>();
	   String search = (String)session.getAttribute("selectSearch");
	   String startNum = Integer.toString(start);
	   String endNum = Integer.toString(end);

	   param.put("search", search);
	   param.put("start", startNum);
	   param.put("end", endNum);
	   return sst.selectList("AuctionDAO.auctionList_search", param);
   }
   
   //경매 게시판 검색 네비메뉴
   public String getNavi_auction_search(HttpSession session, int currentPage, int recordCountPerPage) {
      int recordTotalCount = this.recordTotalCount_auction_search(session);
      System.out.println("검색 토탈 카운트" + recordTotalCount);
      String result = this.naviAuctionOptionCode(currentPage, recordCountPerPage, recordTotalCount);
      return result;
   }
   
   //조회수 업데이트
   public void viewCountUpdate(int no) {
	   sst.update("AuctionDAO.viewCountUpdate", no);
   }
   
   //메인페이지 경매리스트
   public List<Auction_boardDTO> main_Auction_List(){
	   HashMap<String, Object> param = new HashMap<>();
	   param.put("start", "1");
	   param.put("end", "8");
	   return sst.selectList("AuctionDAO.mainAuctionList", param);
   }
   
   
}