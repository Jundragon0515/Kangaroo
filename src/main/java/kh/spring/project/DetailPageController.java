package kh.spring.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dao.DetailPageDAO;
import kh.spring.dto.Auction_boardDTO;
import kh.spring.dto.Auction_img_boardDTO;

@Controller
public class DetailPageController {
	@Autowired
	private DetailPageDAO dao;

	@RequestMapping("/detailPage")
	public String detailPage(HttpServletRequest request) {
	 Auction_img_boardDTO a_i_dto = dao.a_i_selectByNo();
	 Auction_boardDTO a_dto = dao.a_selectByNo();
	 request.setAttribute("a_i_dto", a_i_dto);
	 request.setAttribute("a_dto", a_dto);
	 return "detailPage";
	}

}
