package kh.spring.aspect;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dao.MemberDAO;

@Component
@Aspect
public class PerfCheckBlackList {

	@Autowired
	HttpSession session;

	@Autowired
	MemberDAO dao = new MemberDAO();
	
	// Advice인 Around 매서드는 자신이 위빙되는 포인트 컷 메서드에 영향을 줄 수 있다.
	@After("execution(* kh.spring.project.*.*(..))")
	public void perfCheck() {		// 매개변수를 상속받은 조인 포인트	
		String id = (String)session.getAttribute("email");	
		try{
			if(!id.equals("")) {
				if(dao.selectById(id).getBlacklist().equals("Y")) {
				session.invalidate();
				} 
			} 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

