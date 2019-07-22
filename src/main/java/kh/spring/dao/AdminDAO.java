package kh.spring.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.project.HomeController;

@Repository
public class AdminDAO {

	@Autowired
	private SqlSessionTemplate sst;

	public int insertVisitCount() {
		return sst.insert("AdminDAO.insertVisitCount", HomeController.visitCount);
	}		

	public int boardWriteDelete(String no) {
		return sst.delete("AdminDAO.boardWriteDelete",no);
	}
	public int boardImgDelete(String no) {
		return sst.delete("AdminDAO.boardImgDelete",no);
	}

}

