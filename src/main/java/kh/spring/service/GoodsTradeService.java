package kh.spring.service;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSplitPaneUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.GoodsTradeDAO;
import kh.spring.dto.Used_transaction_boardDTO;

@Service
public class GoodsTradeService {

   @Autowired
   private GoodsTradeDAO gdao; 
   
   @Autowired
   private HttpSession session;
   
   
   //카테고리 설정
   public void checkCategory(HttpSession session) {
      gdao.checkCategory(session);
   }
   
   //가격 낮은순 OR 높은순 정렬
   public void checkPrice(HttpSession session) {
      gdao.checkPrice(session);
   }
   
   public void checkView(HttpSession session) {
      gdao.checkView(session);
   }
   
   //직거래 게시판 처음 화면
   public List<Used_transaction_boardDTO> directList(int start, int end){
      return gdao.directList(start, end);
   }
   
   //직거래 게시판 옵션 설정
   public List<Used_transaction_boardDTO> directOption(HttpSession session, int start, int end){
      return gdao.directOption(session, start, end);
   }
   
   //직거래 게시판 일반 화면  네비
   public String directBoardNavi(int currentPage, int recordCountPerPage) {
      return gdao.getNavi_direct(currentPage, recordCountPerPage);
   }
   
   //직거래 게시판 옵션선택 후 네비
   public String directBoardNaviOption(HttpSession session, int currentPage, int recordCountPerPage) {
      return gdao.getNaviOption_direct(session, currentPage, recordCountPerPage);
   }
   
   //---------------------------------------------------------------------------------------------------------------------------
   
   //안전거래 게시판 처음 화면
   public List<Used_transaction_boardDTO> safeList(int start, int end){
      return gdao.safeList(start, end);
   }
  
   //안전거래 게시판 옵션 설정
   public List<Used_transaction_boardDTO> safeOption(HttpSession session, int start, int end){
      return gdao.safeOption(session, start, end);
   }
   
   //안전거래 게시판 일반 화면  네비
   public String safeBoardNavi(int currentPage, int recordCountPerPage) {
      return gdao.getNavi_safe(currentPage, recordCountPerPage);
   }
   
   //안전거래 게시판 옵션선택 후 네비
   public String safeBoardNaviOption(HttpSession session, int currentPage, int recordCountPerPage) {
	   return gdao.getNaviOption_safe(session, currentPage, recordCountPerPage);
   }
   
   //-----------------------------------------------------------------------------------------------------------
   
   //직거래 검색어
   public List<Used_transaction_boardDTO> directList_search(HttpSession session, int start, int end){
	      return gdao.directList_search(session, start, end);
	   }
  //직거래 검색어 네비
   public String directBoardNavi_search(HttpSession session, int currentPage, int recordCountPerPage){
	   return gdao.getNavi_direct_search(session, currentPage, recordCountPerPage);
   }
   
   //안전거래 검색어
   public List<Used_transaction_boardDTO> safeList_search(HttpSession session, int start, int end){
	      return gdao.safeList_search(session, start, end);
	   }
  //안전거래 검색어 네비
   public String safeBoardNavi_search(HttpSession session, int currentPage, int recordCountPerPage){
	   return gdao.getNavi_safe_search(session, currentPage, recordCountPerPage);
   }
   

}