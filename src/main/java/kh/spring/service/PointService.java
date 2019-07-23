package kh.spring.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.dao.MemberDAO;
import kh.spring.dao.PointDAO;

@Component
public class PointService {
	@Autowired
	MemberDAO me;
	@Autowired
	HttpSession se;
	@Autowired
	PointDAO pdao;
	@Transactional("txManager")
	public int insert(int amount) {
		String email=(String)se.getAttribute("email");
		int money=me.getPoint(email)+amount;
		me.setPoint(email, money);
		return pdao.insert(email,money);
	}
}

