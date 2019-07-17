package kh.spring.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.Auction_boardDTO;
import kh.spring.dto.Auction_img_boardDTO;
import kh.spring.dto.Used_transaction_boardDTO;
import kh.spring.dto.Used_transaction_img_boardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sst;
	
	public int writeInsert(Used_transaction_boardDTO dto) {
		return sst.insert("BoardDAO.writeInsert",dto);
	}
	
	public int imgInsert(Used_transaction_img_boardDTO dto) {
		return sst.insert("BoardDAO.imgInsert",dto);
	}
	
	public int actionWriteInsert(Auction_boardDTO dto) {
		return sst.insert("BoardDAO.actionWriteInsert",dto);
	}
	
	public int actionImgInsert(Auction_img_boardDTO dto) {
		return sst.insert("BoardDAO.actionImgInsert",dto);
	}
	
}

