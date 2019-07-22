package kh.spring.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.Auction_boardDTO;
import kh.spring.dto.Auction_img_boardDTO;
import kh.spring.dto.CommentDTO;
import kh.spring.dto.Used_transaction_boardDTO;
import kh.spring.dto.Used_transaction_img_boardDTO;

@Repository
public class DetailPageDAO {
	
	@Autowired
	private SqlSessionTemplate sst;
	
	public Auction_img_boardDTO a_i_selectByNo(int no) {
		return sst.selectOne("DetailPageDAO.a_i_selectByNo", no);
	}
	public Auction_boardDTO a_selectByNo(int no) {
		return sst.selectOne("DetailPageDAO.a_selectByNo", no);
	}
	public Used_transaction_img_boardDTO u_i_selectByNo(int no) {
		return sst.selectOne("DetailPageDAO.u_i_selectByNo", no);
	}
	public Used_transaction_boardDTO u_selectByNo(int no) {
		return sst.selectOne("DetailPageDAO.u_selectByNo", no);
	}
	public int a_updatePrice(Auction_boardDTO dto) {
		return sst.update("DetailPageDAO.a_updatePrice",dto);
	}
	public int a_presentMoney(int board_num) {
		return sst.selectOne("DetailPageDAO.a_presentMoney",board_num );
	}
	public int tenderCount(int board_num) {
		return sst.selectOne("DetailPageDAO.tenderCount", board_num);
	}
	public int deleteComment(CommentDTO dto) {
		return sst.delete("DetailPageDAO.deleteComment",dto);
	}
	public int deleteComment2(CommentDTO dto) {
		return sst.delete("DetailPageDAO.deleteComment2",dto);
	}
}
