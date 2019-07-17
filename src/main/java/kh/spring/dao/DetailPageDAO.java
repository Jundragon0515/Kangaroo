package kh.spring.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.Auction_boardDTO;
import kh.spring.dto.Auction_img_boardDTO;

@Repository
public class DetailPageDAO {
	
	@Autowired
	private SqlSessionTemplate sst;
	
	public Auction_img_boardDTO a_i_selectByNo() {
		return sst.selectOne("DetailPageDAO.a_i_selectByNo", 2);
	}
	public Auction_boardDTO a_selectByNo() {
		return sst.selectOne("DetailPageDAO.a_selectByNo", 1);
	}
}
