package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dao.BoardDAO;
import kh.spring.dao.DeliveryDAO;
import kh.spring.dao.MailDAO;
import kh.spring.dao.MemberDAO;
import kh.spring.dao.OrderDAO;
import kh.spring.dao.TenderDAO;
import kh.spring.dto.DeliveryDTO;
import kh.spring.dto.OrderDTO;
import kh.spring.dto.TenderDTO;

@Component
public class MyPageService {
	@Autowired
	OrderDAO or;
	@Autowired
	TenderDAO ten;
	@Autowired
	BoardDAO bo;
	@Autowired
	MemberDAO me;
	@Autowired
	MailDAO ma;
	@Autowired
	DeliveryDAO de;
	
	public List<OrderDTO> selectByBuyer(int currentPage,String buyer){//구매 리스트
		return or.selectByBuyer(currentPage, buyer);
	}
	public List<TenderDTO> selectById(int currentPage,String id){//입찰 리스트
		return ten.selectById(currentPage, id);
	}
	public String getNavi_or(int currentPage,String buyer) {
		return or.getNavi(currentPage, buyer);
	}
	public String getNavi_ten(int currentPage,String id) {
		return ten.getNavi(currentPage, id);
	}
	public void confirme(int seq) {
		OrderDTO or_info=or.selectBySeq(seq);//seq로 정보 가지고 오기
		if(or_info.getType().equals("거래")) {//판매면 판매게시판 ongoing n으로
			bo.used_onGoing_n(or_info.getProduct_num());
		}
		int point = or_info.getPrice();
		point+=point*0.1;
		me.setPoint(or_info.getSeller(), point);//포인트  *0.1 만큼 돈 추가하기 
		//ma.send_confirme(to, title);//이메일 보내기 
		or.update_situation(seq, "구매확정");//판매 테이블 상태 수정
	}
	public void refund(int seq) {
		OrderDTO or_info=or.selectBySeq(seq);
		or.update_situation(seq, "환불요청");//판매 테이블 상태 수정	
	}
	public void preparing(int seq) {
		or.update_situation(seq, "배송준비중");
	}
	public void ing(int seq) {
		or.update_situation(seq, "배송중");
	}
	public void comp(int seq) {
		or.update_situation(seq, "배송완료");
	}
	public void refund_comp(int seq) {
		or.update_situation(seq, "환불처리완료");
	}
	public void deli_insert(DeliveryDTO dto) {
		or.update_situation(dto.getProduct_num(), "배송출발");
		de.deli_insert(dto);
	}
	public List<OrderDTO> selectBySeller(int currentPage,String seller){//구매 리스트
		return or.selectBySeller(currentPage, seller);
	}
}
