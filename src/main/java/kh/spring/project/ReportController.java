package kh.spring.project;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.xapi.data.PlatformData;
import com.nexacro.xapi.data.VariableList;
import com.nexacro.xapi.tx.HttpPlatformRequest;

import kh.spring.dto.ReportDTO;
import kh.spring.service.ReportService;
@Controller
public class ReportController {

	@Autowired
	private ReportService sv;
	@Autowired
	private HttpSession session;
	
	
	@RequestMapping("report")
	public String sin(HttpServletRequest request)throws Exception {
		ReportDTO dto = new ReportDTO();
		HttpPlatformRequest req = new HttpPlatformRequest(request); //nexacro로 맞게 cating
		req.receiveData();//써야되는 것(ResertSet과 같은 개념)
		
		PlatformData pdata = req.getData();
		VariableList params = pdata.getVariableList();
		dto.setTitle(params.getString("title"));
		dto.setSender(params.getString("writer"));
		dto.setReason(params.getString("cause"));
		dto.setContents(params.getString("contents"));

		sv.reportInsert(dto);
		
		return "redirect:resources/index.html";
	}
	
}
