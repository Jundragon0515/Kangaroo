package kh.spring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.GoodsTradeDTO;


@Repository
public class GoodsTradeDAO {

   @Autowired
   private SqlSessionTemplate sst;
   
   public String test(String name) {
      return name;
   }
   
   public List<GoodsTradeDTO> selectList(int start, int end){
      HashMap<String, Object> param = new HashMap<>();
      param.put("start", start);
      param.put("end", end);
      return sst.selectList("GoodsTradeDAO.selectList",param);
   }
   
   
   public List<GoodsTradeDTO> selectListLowPrice(int start, int end){
         HashMap<String, Object> param = new HashMap<>();
         param.put("start", start);
         param.put("end", end);
         return sst.selectList("GoodsTradeDAO.selectListLowPrice",param);
   }
   
   public List<GoodsTradeDTO> selectListHighPrice(int start, int end){
      HashMap<String, Object> param = new HashMap<>();
      param.put("start", start);
      param.put("end", end);
      return sst.selectList("GoodsTradeDAO.selectListHighPrice",param);
   }
   
   public String boardMainImg(int no) {
      return sst.selectOne("GoodsTradeDAO.boardMainImg", no);
   }
   
   public int delete() {
      return sst.delete("GoodsTradeDAO.delete");
   }
   
   //경매게시판 전체 리스트 
   public int recordTotalCount() {
      return sst.selectOne("GoodsTradeDAO.recordTotalCount");
   }
   
   
   public String getNavi(int currentPage, int recordCountPerPage) {
      int recordTotalCount = this.recordTotalCount(); //레코드 수
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
      String link = "<a href='index?currentPage=";
      
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
   
   public String getNaviView(int currentPage, int recordCountPerPage ,int view , String price) {
      int recordTotalCount = this.recordTotalCount(); //레코드 수
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
      String link = "<a href='indexList?price="+price+"&view="+view+"&currentPage=";
      
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
   
   public String getNaviView(int currentPage, int recordCountPerPage ,int view) {
      int recordTotalCount = this.recordTotalCount(); //레코드 수
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
      String link = "<a href='indexList?view="+view+"&currentPage=";
      
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