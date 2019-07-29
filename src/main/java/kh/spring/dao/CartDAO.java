package kh.spring.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.CartAuctionDTO;
import kh.spring.dto.CartTradeDTO;
import kh.spring.dto.Used_transaction_boardDTO;

@Repository
public class CartDAO {

	@Autowired
	private SqlSessionTemplate sst;

	public List<CartTradeDTO> tradeCart(String email){
		return sst.selectList("CartDAO.tradeCart",email);
	}

	public List<CartAuctionDTO> auctionCart(String email){
		return sst.selectList("CartDAO.auctionCart",email);
	}

	public int recordTotalCount(String email) {
		return sst.selectOne("CartDAO.recordTotalCount",email);
	}
	public List<CartTradeDTO> selectList(int start, int end,String email){
		HashMap<String, Object> param = new HashMap<>();
		param.put("start", start);
		param.put("end", end);
		param.put("email",email);
		return sst.selectList("CartDAO.selectList",param);
	}
	
	public int cartTradeDelete(String no) {
		return sst.delete("CartDAO.cartTradeDelete",no);
	}
	
	public int cartAuctionDelete(String no) {
		return sst.delete("CartDAO.cartAuctionDelete",no);
	}
	
	public String getNavi(int currentPage, int recordCountPerPage,String email) {
		int recordTotalCount = this.recordTotalCount(email); //레코드 수
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
		String link = "<a href='goCart?currentPage=";

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


	public List<CartAuctionDTO> selectListA(int start1, int end1,String email){
		HashMap<String, Object> param = new HashMap<>();
		param.put("start", start1);
		param.put("end", end1);
		param.put("email",email);
		return sst.selectList("CartDAO.selectListA",param);
	}

	public String getNaviA(int currentPage1, int recordCountPerPage1,String email) {
		int recordTotalCountA = this.recordTotalCountA(email); //레코드 수
		int naviCountPerPage = 5; // 한 페이지 네비 개수
		int pageTotalCount=0;

		if(recordTotalCountA % recordCountPerPage1 > 0) {
			pageTotalCount = recordTotalCountA / recordCountPerPage1 + 1;
		}else {
			pageTotalCount = recordTotalCountA / recordCountPerPage1;
		}

		if(currentPage1 < 1) {
			currentPage1 = 1;
		}else if(currentPage1 > pageTotalCount) {
			currentPage1 = pageTotalCount;
		}


		int startNavi = (currentPage1 -1) / naviCountPerPage * naviCountPerPage + 1;
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
		String link = "<a href='goCart?currentPage1=";

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

	public int recordTotalCountA(String email) {
		return sst.selectOne("CartDAO.recordTotalCountA",email);
	}

	public int stream(CartTradeDTO dto){
		return sst.insert("CartDAO.stream",dto);
	}

	public int overlap(CartTradeDTO dto) {
		return sst.selectOne("CartDAO.overlapCheck", dto);
	} 
	
	public int streamimgAuction(CartAuctionDTO dto) {
		return sst.insert("CartDAO.streamAuction",dto);
	}
	
	public int overlapAuction(CartAuctionDTO dto) {
		return sst.selectOne("CartDAO.overlapCheckAuction",dto);
	}

}
