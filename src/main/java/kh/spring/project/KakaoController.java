package kh.spring.project;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.service.MemberService;
@Controller
public class KakaoController {
	@Autowired
	MemberService mes;
	@RequestMapping("/login.ka")
	public String login() throws UnsupportedEncodingException { 
		return mes.ka_login();
	}
	@RequestMapping("/callback.ka")
	public ModelAndView callback(HttpServletRequest request) throws IOException { 
		return mes.ka_callback(request);
	}
}
