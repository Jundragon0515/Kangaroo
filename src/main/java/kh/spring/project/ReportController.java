package kh.spring.project;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
      String no = (String) session.getAttribute("no");
      int no1 = Integer.parseInt(no);
      String type = (String)session.getAttribute("type");
      dto.setNo(no1);
      dto.setSender((String)session.getAttribute("email"));
      dto.setType(type);
      dto.setIpaddress((String)session.getAttribute("ipaddress"));
      
      HttpPlatformRequest req = new HttpPlatformRequest(request); //nexacro로 맞게 cating
      req.receiveData();//써야되는 것(ResertSet과 같은 개념)
      
      PlatformData pdata = req.getData();
      VariableList params = pdata.getVariableList();
      dto.setTitle(params.getString("title"));
      dto.setReason(params.getString("cause"));
      dto.setContents(params.getString("contents"));
      System.out.println(dto.getNo());
      System.out.println(dto.getSender());
      System.out.println(dto.getType());
      System.out.println(dto.getTitle());
      System.out.println(dto.getReason());
      System.out.println(dto.getContents());
      System.out.println(dto.getTitle());
      System.out.println(dto.getIpaddress());
      session.removeAttribute("no");
      session.removeAttribute("type");
      session.removeAttribute("ipaddress");
      sv.reportInsert(dto);
      
      return "redirect:resources/index.html";
   }
   
   @ResponseBody
   @RequestMapping("go")
   public String go(HttpServletRequest request) {
      String no = request.getParameter("no");
      String type = request.getParameter("type"); 
      String sender = request.getParameter("sender");
      request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = request.getHeader("X-FORWARDED-FOR");
        if (ip == null)
            ip = request.getRemoteAddr();
        
      session.setAttribute("type", type);
      session.setAttribute("no", no);
      session.setAttribute("ipaddress", ip);
      return "장난 신고는 금지합니다.";
   }
   
   
}