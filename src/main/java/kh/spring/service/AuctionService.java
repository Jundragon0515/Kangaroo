package kh.spring.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.AuctionDAO;
import kh.spring.dto.Auction_boardDTO;
import kh.spring.dto.Used_transaction_boardDTO;

@Service
public class AuctionService {

   @Autowired
   private AuctionDAO adao; 
   
   @Autowired
   private HttpSession session;
   

   //처음 화면
   public List<Auction_boardDTO> auctionList(int start, int end){
      return adao.auctionList(start, end);
   }
   
   //카테고리 설정
   public void checkCategory(HttpSession session) {
      adao.checkCategory(session);
   }
   
   //가격 낮은순 OR 높은순 정렬
   public void checkPrice(HttpSession session) {
      adao.checkPrice(session);
   }
   
   public void checkView(HttpSession session) {
      adao.checkView(session);
   }
   
   //게시판 옵션 설정
   public List<Auction_boardDTO> auctionOption(HttpSession session, int start, int end){
      return adao.auctionOption(session, start, end);
   }
   
   //일반 화면 게시판 네비
   public String auctionBoardNavi(int currentPage, int recordCountPerPage) {
      return adao.getNavi(currentPage, recordCountPerPage);
   }
   
   //옵션선택 후 게시판 네비
   public String auctionBoardNaviOption(HttpSession session, int currentPage, int recordCountPerPage) {
      return adao.getNaviOption(session, currentPage, recordCountPerPage);
   }
  
   //검색어
   public List<Auction_boardDTO> auctionList_search(HttpSession session, int start, int end){
	   return adao.auctionList_search(session, start, end);
   }
   
   //검색어 네비
   public String auctionBoardNavi_search(HttpSession session, int currentPage, int recordCountPerPage){
	   return adao.getNavi_auction_search(session, currentPage, recordCountPerPage);
   }

}