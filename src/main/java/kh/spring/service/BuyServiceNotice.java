package kh.spring.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import ch.qos.logback.core.net.SyslogOutputStream;
import kh.spring.dao.NoticeDAOImpl;
import kh.spring.dto.NoticeDTO;
@Component
public class BuyServiceNotice{
	
	@Autowired
	private NoticeDAOImpl dao;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpSession session;
	
	@Transactional("txManager")
	public NoticeDTO noticereset(NoticeDTO dto , HttpServletRequest request) { // 수정에서 뒤로가기
		String resourcePath = session.getServletContext().getRealPath("/resources");
		String image = "";
		int no = 0;
		File file = null;
		int maxSize = 10 * 1924 * 1024;
		File orifile = null;
		try {
			 
		MultipartRequest multi = new MultipartRequest(request,resourcePath,maxSize,
				"utf-8",new DefaultFileRenamePolicy());
		
		no = Integer.parseInt(multi.getParameter("no"));
		image = multi.getParameter("image").substring(0,10);
		orifile = multi.getFile("image");
		System.out.println("resourcePath :"+resourcePath);
		System.out.println("no :"+no);
		System.out.println("orifile :"+orifile);
		System.out.println("image :"+image);
		
		dto.setNo(no);
		
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return dao.noticereset(dto);
	}
	
	
	@Transactional("txManager")
	public List<NoticeDTO> noticedelete(MultipartFile image,HttpServletRequest request) { //게시글 삭제
		List<NoticeDTO> dtos = null;
		NoticeDTO dto = new NoticeDTO();
		String resourcePath = session.getServletContext().getRealPath("/resources/");
		System.out.println("resourcePath :"+resourcePath);
		System.out.println("asdadada");
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("no :"+ no);
		String imagename = request.getParameter("image");
		System.out.println("image :"+imagename);
		boolean as = imagename == null;
		boolean ab = imagename.equals("");
		System.out.println(as+" : "+ab);
		try {
			if(imagename != null) {
				String images = resourcePath.substring(0,92)+"/"+imagename;
				File file = new File(images);
				System.out.println("파일 이름 : "+file);
				if(file.exists() == true) {
					file.delete();
					System.out.println("중복된파일 삭제");
					dao.noticedelete(Integer.parseInt(request.getParameter("no")));
				}
			}else {
				dao.noticedelete(Integer.parseInt(request.getParameter("no")));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		dtos = dao.noticeviewlist();
		return dtos;
	}


	@Transactional("txManager")
	public List<NoticeDTO> noticeinput(MultipartFile image,HttpServletRequest request){ // 게시글 작성
		List<NoticeDTO> dtos = null;
		NoticeDTO dto = new NoticeDTO();
		String resourcePath = session.getServletContext().getRealPath("/resources/");
		System.out.println(resourcePath);
		File file = new File(resourcePath+System.currentTimeMillis()+"notice.png");
		String imagename = null;
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		try {
			dto.setTitle(title);
			dto.setContents(contents);
		if(image.getOriginalFilename().equals("")) { // 이미지가 없으면
			System.out.println("없다");
			if(dao.noticeinputnotimage(dto) > 0){
				System.out.println("없다 그리도 들어갔다");
				dtos = dao.noticeviewlist();
			}
		}else { // 이미지 있으면
			image.transferTo(file);
			
			imagename = "resources/"+file.getName();
			System.out.println(imagename);
			dto.setImage(imagename);
			
			if(dao.noticeinput(dto) > 0) {
				System.out.println("있다 그리도 들어갔다");
				dtos = dao.noticeviewlist();
			}
		}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return dtos;
	}
	
	@Transactional("txManager")
	public NoticeDTO noticeupdate(NoticeDTO dto){ // 게시글 수정 페이지로
		int no = dto.getNo();
		System.out.println(no);
		List<NoticeDTO> dtos = dao.Notice(no);
		return dtos.get(0);
	}
	@Transactional("txManager")
	public NoticeDTO noticeupdateinsert(MultipartFile images,NoticeDTO dto,HttpServletRequest request) { // 게시글 수정 하기
		List<NoticeDTO> dtos = null;
		String resourcePath = session.getServletContext().getRealPath("/resources/");
		System.out.println(resourcePath);
		System.out.println("asdadada");
		String title = dto.getTitle();/*request.getParameter("title");*/
		String contents = dto.getContents();/*request.getParameter("contents");*/
		int no = dto.getNo();/*Integer.parseInt(request.getParameter("no"));*/
		String image = request.getParameter("image");
		System.out.println(images.getOriginalFilename());
		System.out.println(images.getName());
		File file = new File(resourcePath+images);
		try {
		if(images.getOriginalFilename() == "") { // 이미지가 없으면
			if(dao.noticeupdatenotimage(dto) > 0){
				System.out.println("없다 수정에 성공했다.");
				 dtos = dao.Notice(no);
			}
		}else { // 이미지 있으면
			
			if(file.exists() == true) {
				file.delete();
			}
			images.transferTo(file);
			dto.setImage("resources/"+file.getName());
			if(dao.noticeupdate(dto) > 0) {
				System.out.println("있다 수정에 성공했다.");
				 dtos = dao.Notice(no);
			}
		}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return dtos.get(0);

	}
	
	
	@Transactional("txManager")
	public List<NoticeDTO> noticeviewlist() { // 게시글 리스트 보기
		
		return dao.noticeviewlist();
		
	}
	
	@Transactional("txManager")
	public NoticeDTO notice(int no,int viewcount){ // 게시글 보기
		List<NoticeDTO> arr = null;
		int a = dao.ViewPlus(no, viewcount);
		if(a > 0 ) {
			arr = dao.Notice(no);
		}
		return arr.get(0);
	}
	
	@Transactional("txManager")
	public String NoticeList(int currentPage) { // 페이지 이동하면서 게시글 보기
		List<NoticeDTO> arr = dao.noticeviewlist();
		int recode = arr.size();
		//네이게이터 제작을 위한 step
		//0. currentPage = 현재 내가 존재하는 페이지가 몇 페이지인지

		
		int last = currentPage * 10;
		int first  = last-9;
	
		request.setAttribute("arr", dao.NoticeListPage(last, first));
		
		//1. 전체 레코드 개수가 몇 개인지
		int recordTotalCount = recode; // 원래는 메소드를 통해 rs.getInt(1)로 받아와야 함
		
		//2. 한 페이지에 몇 개의 글이 보이게 할 것인지 - 개발자가 결정
		int recordCountPerPage = 10;
		
		//3. 한 페이지에 네이게이터가 총 몇 개가 보여지게 할 것인지
		int naviCountPerPage = 10;
		
		//4. 총 페이지의 개수
		int pageTotalCount = 0;
		
		//자바에서는 int 나누기 int를 double로 반환할 수 없기 때문에, 소수점 뒤를 자른 정수값을 반환한다
		//그러나 우리는 올림한 페이지 개수가 필요하므로, +1을 해주는 것이 하나의 방법이 될 수 있다 ex) pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		//이 때 페이지가 딱 떨어져 나뉜다면 필요없는 빈 페이지가 하나 추가되는 것이므로 위와같은 식도 언제나 바람직하진 않다
		//그러므로 경우의 수를 나눠 나머지 값이 있을 때만 +1을 해주는 방향으로 코드를 작성해야 한다
		//5. 가지고 있는 게시글 수에 맞는 페이지의 개수를 구한다
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else{
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		//---------------------------------------------------------------하단부의 네비게이터를 만들기위해 기본적으로 필요한 옵션

		//---------------------------------------------------------------보안기법 및 현재페이지 오류 검출/정정(현재 페이지 위치를 파악해 올바른 위치가 아닐경우 제 위치로 위치 수정)
		if(currentPage < 1) {
			currentPage = 1; // 현재 페이지가 1보다 작을 경우에는 현재 페이지를 1로 설정
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount; // 현재 페이지가 마지막 페이지를 넘어갈 경우 마지막 페이지로 설정
		}

		int startNavi = ((currentPage-1) / naviCountPerPage) * naviCountPerPage + 1;
		// 현재 페이지를 기준으로 정해지는 시작 페이지
		// Java에서만 가능한 수학식, int 나누기 int 했을경우 소수점을 버리는 특성 활용!! 중요!!
		// 이때 30같이 딱 떨어지는 수는 30페이지에 위치하더라도 네비는 31-40번을 보여주게 되기 때문에 옳지 않다 -> currentPage - 1를 페이지 위치 기준으로 식 활용
		int endNavi = startNavi + (naviCountPerPage-1);;
		// 현재 페이지를 기준으로 정해지는 마지막 페이지
		// 그러나 마지막 페이지가 최대 페이지 개수를 넘을 수는 없기 때문에 경우의 수를 나눠야 한다

		if(startNavi + (naviCountPerPage-1)>pageTotalCount) {
			endNavi = pageTotalCount;
		}
		// 마지막 페이지가 최대 페이지 번호를 넘어갈 경우 마지막페이지를 최대 페이지 번호로 설정


//		System.out.println("현재 위치 : " + currentPage);
//		System.out.println("네비 시작 : " + startNavi);
//		System.out.println("네비 끝 : " + endNavi);		
		
		boolean needPrev = true;
		boolean needNext = true;
		
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
		 sb.append("<nav aria-label='Page navigation example'><ul class='pagination justify-content-center'>");
		if(needPrev) {
			sb.append("<li class='page-item'><a class='page-link' href='Board.board?currentPage="+(startNavi-1)+"'> 이전 </a></li>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<li class='page-item'><a class='page-link' href='Board.board?currentPage="+i+"'>" + i + " </a></li>");
		}
		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='Board.board?currentPage="+(endNavi+1)+"'>"+ "다음" +"</a></li>");
		}
		sb.append("</ul></nav>");
		return sb.toString();
	}
	
}
