package kh.spring.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.service.PointService;

@Controller
public class PointController {
	@Autowired
	PointService ps;
	
	@RequestMapping("/insert.po")
	@ResponseBody
	public String insert(int amount ) {
		if(ps.insert(amount)>0) {
			return "충전 성공";
		}else {
			return "충전 실패";
		}
	}
}
