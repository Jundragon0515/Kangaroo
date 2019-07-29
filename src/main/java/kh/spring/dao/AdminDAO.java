package kh.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.AdminDTO;
import kh.spring.dto.ReportDTO;
import kh.spring.project.HomeController;

@Repository
public class AdminDAO {

	@Autowired
	private SqlSessionTemplate sst;

	public int insertVisitCount() {
		return sst.insert("AdminDAO.insertVisitCount", HomeController.visitCount);
	}		
	public List<AdminDTO> visitForWeek() {	
		return sst.selectList("AdminDAO.visitForWeek");
	}
	public List<AdminDTO> visitForGraph() {	
		return sst.selectList("AdminDAO.visitForGraph");
	}
	public List<AdminDTO> visitForYear() {
		return sst.selectList("AdminDAO.visitForYear");
	}
	public int safeTradeCount() {
		return sst.selectOne("AdminDAO.safeTradeCount");
	}
	public int directTradeCount() {
		return sst.selectOne("AdminDAO.directTradeCount");
	}
	public int auctionCount() {
		return sst.selectOne("AdminDAO.auctionCount");
	}
	public int auctionActiveCount() {
		return sst.selectOne("AdminDAO.auctionActiveCount");
	}
	public int memberCount() {
		return sst.selectOne("AdminDAO.memberCount");
	}
	public int chargingPoint() {
		return sst.selectOne("AdminDAO.chargingPoint");
	}
	public int emailCheck(String id) {
		return sst.selectOne("AdminDAO.emailCheck", id);
	}
	public int boardWriteDelete(String no) {
		return sst.delete("AdminDAO.boardWriteDelete",no);
	}
	public int boardImgDelete(String no) {
		return sst.delete("AdminDAO.boardImgDelete",no);
	}
	public int auctionBoardDelete(String no) {
		return sst.delete("AdminDAO.auctionBoardDelete",no);
	}
	public int auctionBoardImgDelete(String no) {
		return sst.delete("AdminDAO.auctionBoardImgDelete",no);
	}
	public int cartDelete(String no) {
		return sst.delete("AdminDAO.deleteCart", no);
	}
	public int cartAuctionDelete(String no) {
		return sst.delete("AdminDAO.deleteCartAuction",no);
	}

}

