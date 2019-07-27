package kh.spring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.NoticeDTO;

@Component
public class NoticeDAOImpl{
	
	
	@Autowired
	private SqlSessionTemplate sst;
	
	public NoticeDTO noticereset(NoticeDTO dto) { // 게시글 수정 중 뒤로가기
		return sst.selectOne("NoticeDAOImpl.SelectNotice",dto);
	}
	
	public int noticedelete(int no) { // 게시글 삭제
		return sst.insert("NoticeDAOImpl.DeleteNotice",no);
	}
	
	public int noticeinput(NoticeDTO dto) { // 게시글 작성
		dto.getImage();
		return sst.insert("NoticeDAOImpl.InsertNotice",dto);
	}
	
	public int noticeinputnotimage(NoticeDTO dto) { // 게시글 작성시 이미지 없을때 
		return sst.insert("NoticeDAOImpl.InsertNoticeNotImage",dto);
	}
	
	public int noticeupdatenotimage(NoticeDTO dto) { // 게시글 수정시 이미지 없을떄
		return sst.update("NoticeDAOImpl.UpdateNoticeNotImage",dto);
	}
	
	public int noticeupdate(NoticeDTO dto){ // 게시글 수정
		return sst.update("NoticeDAOImpl.UpdateNotice",dto);
	}
	
	public List<NoticeDTO> noticeviewlist() { // 게시판 리스트 뽑기
		 List<NoticeDTO> dtos = new ArrayList();
		 dtos = sst.selectList("NoticeDAOImpl.SelectViewList");
		 return dtos;
	}
	
	public List<NoticeDTO> NoticeListPage(int last,int first) { // 네이비 페이징 처리
		HashMap<String,Integer> hsm = new HashMap<>();
		hsm.put("last",last);
		hsm.put("first",first);
		return sst.selectList("SelectNav", hsm);
	}
	
	public List<NoticeDTO> Notice(int no) { // 게시글 보기
		List<NoticeDTO> ndto = new ArrayList<>();
		ndto = sst.selectList("NoticeDAOImpl.SelectNotice",no);
		return ndto;
	}
	public int ViewPlus(int no,int viewcount) { // 게시글 볼때 조회수 올라가기
		HashMap<String,Integer> hsm = new HashMap<>();
		hsm.put("viewcount",viewcount);
		hsm.put("no",no);
		return sst.update("NoticeDAOImpl.UpdateViewCount",hsm);
	}
}
