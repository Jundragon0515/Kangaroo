package kh.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.ReportDTO;

@Repository
public class ReportDAO {

	@Autowired
	private SqlSessionTemplate sst;
	
	public int ReportInsert(ReportDTO dto) {
		return sst.insert("ReportDAO.reportInsert",dto);
	}
	public List<ReportDTO> selectReport(){
		return sst.selectList("ReportDAO.reportSelect");
	}
}
