package kh.spring.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dao.ReportDAO;
import kh.spring.dto.ReportDTO;

@Component
public class ReportService {

	@Autowired
	private ReportDAO dao;
	@Autowired
	private HttpSession session;
	
	public void reportInsert(ReportDTO dto) {
		dao.ReportInsert(dto);
	}
}
