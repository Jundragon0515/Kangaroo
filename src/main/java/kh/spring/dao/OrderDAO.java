package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.OrderDTO;

@Component
public class OrderDAO {
	@Autowired
	private SqlSessionTemplate sst;
	@Autowired
	private HttpSession se;
	static int recordCountPerPage = 10;// 한 페이지에 보여줄 글 개수
	static int naviCountPerPage = 10;// 한페이지에 보여줄 페이지 번호 수
	public List<OrderDTO> selectByBuyer(int currentPage,String buyer){
		int endNum = currentPage * recordCountPerPage;
		int startNum = endNum - 9;
		Map<String,String> map = new HashMap<>();
		map.put("startNum", Integer.toString(startNum));
		map.put("endNum", Integer.toString(endNum));
		map.put("buyer", buyer);
		return sst.selectList("OrderDAO.selectByBuyer", map);
	}
	public List<OrderDTO> selectBySeller(int currentPage,String seller){
		int endNum = currentPage * recordCountPerPage;
		int startNum = endNum - 9;
		Map<String,String> map = new HashMap<>();
		map.put("startNum", Integer.toString(startNum));
		map.put("endNum", Integer.toString(endNum));
		map.put("seller", seller);
		return sst.selectList("OrderDAO.selectBySeller", map);
	}
	public int recordCount(String buyer) { // 글 갯수
		return sst.selectOne("OrderDAO.recordCount",buyer);
	}
	public String getNavi(int currentPage,String buyer) {
		int recordTotalCount = this.recordCount(buyer); // 전체 글 갯수
		int pageTotalCount = 0;
		int te_currentPage=(int)se.getAttribute("te_currentPage");
		if (recordTotalCount % recordCountPerPage > 0) { // 전체 글 갯수 % 한 페이지에 보여줄 글 갯수 -> 나머지 잇으면 한페이지 더 필요
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else if (recordTotalCount % recordCountPerPage == 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		if (currentPage < 1) {// 최소 페이지 보다 작으면 최소페이지로
			currentPage = 1;
		} else if (currentPage > pageTotalCount) { // 현재페이지 번호가 전체페이지보다 크면 최대 페이지로
			currentPage = pageTotalCount;
		} // 보안코드
		int startNavi = (currentPage - 1) / naviCountPerPage * naviCountPerPage + 1;
		int endNavi = startNavi + (naviCountPerPage - 1);
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true; // 이전버튼
		boolean needNext = true; // 다음버튼
		if (startNavi == 1) {
			needPrev = false;
		}
		if (endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if (needPrev) {
			sb.append("<a href='goMyPage_delivery?or_currentPage=" + (startNavi - 1) + "&te_currentPage="+te_currentPage+ "'> <이전 </a>");
		}
		for (int i = startNavi; i <= endNavi; i++) {
			sb.append("<a class='pageNum' href='goMyPage_delivery?or_currentPage=" + i + "&te_currentPage="+te_currentPage+  "'>  " + i + "  </a>");
		}
		if (needNext) {
			sb.append("<a href='goMyPage_delivery?or_currentPage=" + (endNavi + 1) + "&te_currentPage="+te_currentPage+  "'> 다음> </a>");
		}
		return sb.toString();
	}
	public OrderDTO selectBySeq(int seq) {
		return sst.selectOne("OrderDAO.selectBySeq", seq);
	}
	public int update_situation(int seq,String situation) {
		Map<String,String> map = new HashMap<>();
		map.put("seq", Integer.toString(seq));
		map.put("situation", situation);
		return sst.update("OrderDAO.update_situation",map);
	}
}
