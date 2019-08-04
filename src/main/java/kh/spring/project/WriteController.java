package kh.spring.project;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kh.spring.dao.AdminDAO;
import kh.spring.dto.Auction_boardDTO;
import kh.spring.dto.Auction_img_boardDTO;
import kh.spring.dto.Used_transaction_boardDTO;
import kh.spring.dto.Used_transaction_img_boardDTO;
import kh.spring.service.WriteService;

@Controller
public class WriteController {


   @Autowired
   private WriteService sv;
   @Autowired
   private HttpSession session;
   @Autowired
   private TradeController tc;
   @Autowired
   private AuctionController ac;
   @Autowired
   private AdminDAO adao;
   @Autowired
   HttpSession se;
   
   @RequestMapping("tradeGoodsWrite")
   public String write(HttpServletRequest request) {
	   String type = request.getParameter("type");
	   if(type.equals("ggic")) {
		   request.setAttribute("type", type);
		   return "goodsTradeWrite";
	   }
	  request.setAttribute("type", type); 
	  request.setAttribute("auctionActiveCount", adao.auctionActiveCount());            // 활성화된 경매  수
	  request.setAttribute("totalCount", adao.auctionCount()+adao.directTradeCount()+adao.safeTradeCount());	// 총 거래량
      return "goodsTradeWrite";
   } //중고 글쓰기로 가기

   @ResponseBody
   @RequestMapping(value="imageUpdate" , produces="application/String;charset=UTF-8")
   public String imageUpdateProc(MultipartFile formData) {
      String uploadPath = session.getServletContext().getRealPath("/resources/img/title");
      String originFileName = formData.getOriginalFilename();
      System.out.println(uploadPath);
      String name = uploadPath+"/"+System.currentTimeMillis()+originFileName;
      String result=null;
      Pattern p  =Pattern.compile(".png$");
      Matcher m = p.matcher(originFileName);
      Pattern p1  =Pattern.compile(".jpg$");
      Matcher m1 = p1.matcher(originFileName);
      if((m.find()) || (m1.find())) {
    	  try {
    	         File newFile = new File(name);
    	         formData.transferTo(newFile);
    	         result=newFile.getName();
    	      } catch (Exception e) {
    	         e.printStackTrace();
    	      }
    	      return result;
      }else {
    	  return "jpg,png확장자만 업로드 가능합니다.";
      }
   
   } //타이틀이미지 ajax로 바로 띄어주는 것

   @RequestMapping("goodsRegister")
   public String goodsRegisterProc(HttpServletRequest request,MultipartHttpServletRequest mtfRequest,Used_transaction_boardDTO dto,Used_transaction_img_boardDTO udto) {
         try {
            dto.setId((String) se.getAttribute("email"));
            dto.setMember_class((String) se.getAttribute("member_class"));            
            sv.goodsInsert(mtfRequest,dto,udto);
         } catch (Exception e) {
            e.printStackTrace();
         }
      if(dto.getTrade_type().equals("직거래")) {
    	  return "redirect:"+tc.direct(request);
      }
      request.setAttribute("auctionActiveCount", adao.auctionActiveCount());            // 활성화된 경매  수
	  request.setAttribute("totalCount", adao.auctionCount()+adao.directTradeCount()+adao.safeTradeCount());	// 총 거래량
      return "redirect:"+tc.safe(request);
   }  //중고 거래 등록하는 것

   @RequestMapping("auctionWrite")
   public String auctionWriteProc(HttpServletRequest request) {
	  request.setAttribute("auctionActiveCount", adao.auctionActiveCount());            // 활성화된 경매  수
	  request.setAttribute("totalCount", adao.auctionCount()+adao.directTradeCount()+adao.safeTradeCount());	// 총 거래량
      return "auctionWrite";
   } //경매 글쓰기로 가는 것

   @RequestMapping("auctionWriteComplete")
   public String ActionWriteCompleteProc(HttpServletRequest request,MultipartHttpServletRequest mtfRequest,Auction_boardDTO adto,Auction_img_boardDTO idto) {
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date time = new Date();
      String time1 = sdf.format(time);
      try {
         //sv.addDate(time1,adto.getPeriod());
         adto.setId((String) se.getAttribute("email"));
         adto.setMember_class((String) se.getAttribute("member_class"));
         sv.actionInsert(mtfRequest,adto, idto,time1,adto.getPeriod());
      } catch (Exception e) {
         e.printStackTrace();
      }

      request.setAttribute("auctionActiveCount", adao.auctionActiveCount());            // 활성화된 경매  수
	  request.setAttribute("totalCount", adao.auctionCount()+adao.directTradeCount()+adao.safeTradeCount());	// 총 거래량
      return "redirect:"+ac.index(request);

   } //경매 글쓰기 완성 등록하면 홈으로가는 것


}