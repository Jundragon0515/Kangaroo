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
	
	public void cartTradeDelete(String value[]) {
		for(int i=0; i<value.length; i++) {
			dao.cartTradeDelete(value[i]);
		}
	}	
	public void cartAuctionDelete(String  value[]) {
		for(int i=0; i<value.length; i++) {
			dao.cartAuctionDelete(value[i]);
		}
	}
	
	//일반 화면 게시판 네비
	public String tradeNavi(int currentPage, int recordCountPerPage,String email) {
	   return dao.getNavi(currentPage, recordCountPerPage,email);
	}
	public String auctionNavi(int currentPage1, int recordCountPerPage1,String email) {
		return dao.getNaviA(currentPage1, recordCountPerPage1,email);
	}
	
	public int streaming(CartTradeDTO dto) {
		return dao.stream(dto);
	}
	
	
	public int overlapCheck(CartTradeDTO dto) {
		return dao.overlap(dto);
	}
	
	public int streamingAuction(CartAuctionDTO dto) {
		return dao.streamimgAuction(dto);
	}
	
	public int overplapCheckAuction(CartAuctionDTO dto) {
		return dao.overlapAuction(dto);
	}
}
