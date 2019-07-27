package kh.spring.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.Used_transaction_boardDTO;


@Repository
public class GoodsTradeDAO {
	
	@Autowired
	private HttpSession session;

   @Autowired
   private SqlSessionTemplate sst;
   
   
   //직거래 기본 네비코드
   public String naviDirectCode(int currentPage, int recordCountPerPage, int recordTotalCount) {
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
   
   //직거래 옵션선택 네비코드
   public String naviDirectOptionCode(int currentPage, int recordCountPerPage, int recordTotalCount) {
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
   
   //안전거래 기본 네비코드
   public String naviSafeCode(int currentPage, int recordCountPerPage, int recordTotalCount) {
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
   
   
   //안전거래 옵션선택 네비코드
   public String naviSafeOptionCode(int currentPage, int recordCountPerPage, int recordTotalCount) {
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
   
   // 카테고리 설정값
   public void checkCategory(HttpSession session) {
	   String category = (String)session.getAttribute("selectCategory");
	   
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
   
   //직거래 게시판 검색어
   public List<Used_transaction_boardDTO> directList_search(HttpSession session, int start, int end){
	   HashMap<String, String> param = new HashMap<>();
	   String search = (String)session.getAttribute("selectSearch");
	   String startNum = Integer.toString(start);
	   String endNum = Integer.toString(end);

	   param.put("search", search);
	   param.put("start", startNum);
	   param.put("end", endNum);
	   return sst.selectList("GoodsTradeDAO.directList_search", param);
   }
   
  
   //직거래 게시판 옵션 list
   public List<Used_transaction_boardDTO> directOption(HttpSession session, int start, int end){
	   HashMap<String, String> param = new HashMap<>();
	   String startNum = Integer.toString(start);
	   String endNum = Integer.toString(end);
	   String selectCategory = (String)session.getAttribute("selectCategory");
	   String selectPrice = (String)session.getAttribute("selectPrice");
	   
	   System.out.println("category :" + selectCategory);
	   System.out.println("price :" + selectPrice);
	   System.out.println("start :" + startNum);
	   System.out.println("end :" + endNum);
	   
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
	   return sst.selectOne("GoodsTradeDAO.recordTotalCountOption_direct", param);
   }
  
   //직거래 게시판 검색 전체개수
   public int recordTotalCount_direct_search(HttpSession session) {
	   		String selectSearch = (String)session.getAttribute("selectSearch");
	   		HashMap<String, String> param = new HashMap<>();
	   		param.put("search", selectSearch);
	      return sst.selectOne("GoodsTradeDAO.recordTotalCount_direct_search", param);
	   }
   
   //직거래 게시판 첫화면 네비메뉴
   public String getNavi_direct(int currentPage, int recordCountPerPage) {
      int recordTotalCount = this.recordTotalCount_direct(); //레코드 수
      String navi = this.naviDirectCode(currentPage, recordCountPerPage, recordTotalCount);
      return navi;
   }
   
   //직거래 게시판 옵션 선택 후 네비메뉴
   public String getNaviOption_direct(HttpSession session, int currentPage, int recordCountPerPage) {
      int recordTotalCount = this.recordTotalCountOption_direct(session); //레코드 수
      String navi = this.naviDirectOptionCode(currentPage, recordCountPerPage, recordTotalCount);
      return navi;
   }
   
   //직거래 게시판 검색 네비메뉴
   public String getNavi_direct_search(HttpSession session, int currentPage, int recordCountPerPage) {
      int recordTotalCount = this.recordTotalCount_direct_search(session); //
      System.out.println("검색 토탈 카운트" + recordTotalCount);
      String result = this.naviDirectOptionCode(currentPage, recordCountPerPage, recordTotalCount);
      return result;
   }
   
   //안전거래 게시판 검색 전체개수
   public int recordTotalCount_safe_search(HttpSession session) {
	   		String selectSearch = (String)session.getAttribute("selectSearch");
	   		HashMap<String, String> param = new HashMap<>();
	   		param.put("search", selectSearch);
	      return sst.selectOne("GoodsTradeDAO.recordTotalCount_safe_search", param);
	   }
   
   //안전거래 게시판 검색어
   public List<Used_transaction_boardDTO> safeList_search(HttpSession session, int start, int end){
	   HashMap<String, String> param = new HashMap<>();
	   String search = (String)session.getAttribute("selectSearch");
	   String startNum = Integer.toString(start);
	   String endNum = Integer.toString(end);
	   
	   param.put("search", search);
	   param.put("start", startNum);
	   param.put("end", endNum);
	   return sst.selectList("GoodsTradeDAO.safeList_search", param);
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
	   return sst.selectOne("GoodsTradeDAO.recordTotalCountOption_safe", param);
   }
   
   //안전거래 게시판 첫화면 네비메뉴
   public String getNavi_safe(int currentPage, int recordCountPerPage) {
      int recordTotalCount = this.recordTotalCount_safe(); //레코드 수
      String navi = this.naviSafeCode(currentPage, recordCountPerPage, recordTotalCount);
     return navi;
   }
   
   //안전거래 게시판 옵션 선택 후 네비메뉴
   public String getNaviOption_safe(HttpSession session, int currentPage, int recordCountPerPage) {
      int recordTotalCount = this.recordTotalCountOption_safe(session); //레코드 수
      String navi = this.naviSafeOptionCode(currentPage, recordCountPerPage, recordTotalCount);
      return navi;
   }
   
   //안전거래 게시판 검색 네비메뉴
   public String getNavi_safe_search(HttpSession session, int currentPage, int recordCountPerPage) {
      int recordTotalCount = this.recordTotalCount_safe_search(session); //
      System.out.println("검색 토탈 카운트" + recordTotalCount);
      String result = this.naviSafeOptionCode(currentPage, recordCountPerPage, recordTotalCount);
      return result;
   }
   
   //조회수 업데이트
   public void viewCountUpdate(int no) {
	   sst.update("GoodsTradeDAO.viewCountUpdate", no);
   }
   
   //메인페이지 직거래 리스트
   public List<Used_transaction_boardDTO>main_direct_list(){
	      HashMap<String, String> param = new HashMap<>();
	      param.put("start", "1");
	      param.put("end", "8");
	      return sst.selectList("GoodsTradeDAO.mainDirectList",param);
	   }
   
   //메인 안전거래 리스트
   public List<Used_transaction_boardDTO> main_safe_list(){
	      HashMap<String, Object> param = new HashMap<>();
	      param.put("start", "1");
	      param.put("end", "8");
	   return sst.selectList("GoodsTradeDAO.mainSafeList", param);
   }
   

   public int cancleTrade(int no) {
	   return sst.delete("GoodsTradeDAO.cancleTrade",no);
   }

   //상세 안전거래 리스트
   public List<Used_transaction_boardDTO> d_main_safe_list(){
	      HashMap<String, Object> param = new HashMap<>();
	      param.put("start", "1");
	      param.put("end", "6");
	   return sst.selectList("GoodsTradeDAO.mainSafeList", param);
   }

}