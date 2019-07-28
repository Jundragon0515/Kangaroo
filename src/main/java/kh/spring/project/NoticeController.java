package kh.spring.project;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.spring.dto.NoticeDTO;
import kh.spring.service.BuyServiceNotice;

@Controller
public class NoticeController {


	@Autowired
	private BuyServiceNotice buySvc;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value="/noticeupdate.do",method=RequestMethod.POST)
	public String inputupdateinput(NoticeDTO dto,MultipartFile images,HttpServletRequest request) {  // 게시글 수정하기

		request.setAttribute("ndtos", buySvc.noticeupdateinsert(images,dto,request));
		return "notice_board";
	}

	@RequestMapping(value="/noticeupdate",method=RequestMethod.POST)
	public String noticeupdate(NoticeDTO dto,HttpServletRequest request) {// 게시글 수정페이지로 가기

		request.setAttribute("dtos",buySvc.noticeupdate(dto));
		return "notice_update";
	}
	@RequestMapping(value="/noticeinput.do",method=RequestMethod.POST)
	public String noticeinput(MultipartFile image,HttpServletRequest request) {  // 게시글 작성하기
		List<NoticeDTO> dtos = buySvc.noticeinput(image, request);
		request.setAttribute("dtos",dtos);
		return "redirect:notice_main";
	}
	
	@RequestMapping("/notice_main")//바꿔주자
	public String notice_lists(HttpServletRequest request) { // 게시판 리스트 있는곳으로
		int currentPage = 1;
		request.setAttribute("nav",buySvc.NoticeList(currentPage));
		List<NoticeDTO> ndtos = (List<NoticeDTO>) request.getAttribute("arr");
		request.setAttribute("dtos", ndtos);
		return "notice_main";
	}


	@RequestMapping("/notice")
	public String boardserch(int no,int viewcount,HttpServletRequest request) { // 게시글중에 보기

		NoticeDTO dtos = buySvc.notice(no, viewcount);
		System.out.println(dtos.getImage());
		request.setAttribute("ndtos",dtos);
		return "notice_board";
	}
	
	@RequestMapping("/noitceinput")
	public String noticeinput() { //글작성하는 곳으로 가기
		return "notice_input";
	}
	
	@RequestMapping("/Board.board")
	public String noticelist(int currentPage,HttpServletRequest request) { // 네비 게이터 로 페이지 이동
		request.setAttribute("nav",buySvc.NoticeList(currentPage));
		List<NoticeDTO> ndtos = (List<NoticeDTO>) request.getAttribute("arr");
		request.setAttribute("dtos", ndtos);
		return "notice_main";
	}
	@RequestMapping(value="/noticedelet",method=RequestMethod.POST)
	public String noticedelete(MultipartFile image,HttpServletRequest request){ // 게시글 삭제

		request.setAttribute("dtos",buySvc.noticedelete(image,request));

		return "redirect:notice_main";
	}
	@RequestMapping(value="/resetnotice",method=RequestMethod.POST)
	public String noticereset(NoticeDTO dto,HttpServletRequest request) { // 수정에서 뒤로가기
		request.setAttribute("ndtos", buySvc.noticereset(dto,request));;
		return "notice_board";
	}
	
}
