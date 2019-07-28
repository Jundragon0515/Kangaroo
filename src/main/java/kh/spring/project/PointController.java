package kh.spring.project;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.service.MemberService;
import kh.spring.service.PointService;

@Controller
public class PointController {
	@Autowired
	PointService ps;
	@Autowired
	HttpSession se;
	@Autowired
	MemberService mes;
	@RequestMapping("/insert.po")
	@ResponseBody
	public String insert(int amount ) {
		if(ps.insert(amount)>0) {
			return "충전 성공";
		}else {
			return "충전 실패";
		}
	}
	@RequestMapping("/toPoint")
	public String toPoint() { //포인트 충전
		if(se.getAttribute("email")!=null) {
			mes.setPoint();
		}
		return "point_f/point";
	}
	@RequestMapping("/toPoint_exc")
	public String toPoint_exc() { //포인트 환급
		if(se.getAttribute("email")!=null) {
			mes.setPoint();
		}
		return "point_f/point_exc";
	}
	@RequestMapping(value="p_exc" , produces="application/String;charset=UTF-8")
	@ResponseBody
	public String p_exc(int money) { //포인트 환급
		return ps.minus(money);
	}
}
