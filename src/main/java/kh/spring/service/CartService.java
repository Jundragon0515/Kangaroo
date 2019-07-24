package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import kh.spring.dao.CartDAO;
import kh.spring.dto.CartAuctionDTO;
import kh.spring.dto.CartTradeDTO;

@Component
public class CartService {

	@Autowired
	private CartDAO dao;

	public List<CartTradeDTO> tradeList(int start, int end,String email){
	    return dao.selectList(start, end,email);
	}
	
	public List<CartAuctionDTO> auctionList(int start1, int end1,String email){
	    return dao.selectListA(start1, end1,email);
	}
	//일반 화면 게시판 네비
	public String tradeNavi(int currentPage, int recordCountPerPage) {
	   return dao.getNavi(currentPage, recordCountPerPage);
	}
	public String auctionNavi(int currentPage1, int recordCountPerPage) {
		return dao.getNaviA(currentPage1, recordCountPerPage);
	}
	
	public int streaming(CartTradeDTO dto) {
		return dao.stream(dto);
	}
	
	public int overlapCheck(int no) {
		return dao.overlap(no);
	}

}
