package kh.spring.stomp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import kh.spring.dao.MemberDAO;
import kh.spring.dto.TenderDTO;

@Controller
public class TenderController {
	
	@Autowired
	private MemberDAO dao;

	@MessageMapping("/chat1") // 1
	   @SendTo("/ten1") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   
	   @MessageMapping("/chat2") // 1
	   @SendTo("/ten2") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc2(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat3") // 1
	   @SendTo("/ten3") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc3(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat4") // 1
	   @SendTo("/ten4") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc4(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   
	   @MessageMapping("/chat5") // 1
	   @SendTo("/ten5") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc5(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat6") // 1
	   @SendTo("/ten6") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc6(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat7") // 1
	   @SendTo("/ten7") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc7(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat8") // 1
	   @SendTo("/ten8") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc8(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat9") // 1
	   @SendTo("/ten9") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc9(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat10") // 1
	   @SendTo("/ten10") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc10(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat11") // 1
	   @SendTo("/ten11") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc11(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat12") // 1
	   @SendTo("/ten12") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc12(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat13") // 1
	   @SendTo("/ten13") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc13(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat14") // 1
	   @SendTo("/ten14") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc14(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat15") // 1
	   @SendTo("/ten15") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc15(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat16") // 1
	   @SendTo("/ten16") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc16(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat17") // 1
	   @SendTo("/ten17") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc17(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat18") // 1
	   @SendTo("/ten18") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc18(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat19") // 1
	   @SendTo("/ten19") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc19(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat20") // 1
	   @SendTo("/ten20") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc20(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat21") // 1
	   @SendTo("/ten21") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc21(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat22") // 1
	   @SendTo("/ten22") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc22(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat23") // 1
	   @SendTo("/ten23") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc23(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat24") // 1
	   @SendTo("/ten24") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc24(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat25") // 1
	   @SendTo("/ten25") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc25(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat26") // 1
	   @SendTo("/ten26") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc26(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat27") // 1
	   @SendTo("/ten27") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc27(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat28") // 1
	   @SendTo("/ten28") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc28(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat29") // 1
	   @SendTo("/ten29") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc29(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat30") // 1
	   @SendTo("/ten30") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc30(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat31") // 1
	   @SendTo("/ten31") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc31(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat32") // 1
	   @SendTo("/ten32") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc32(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat33") // 1
	   @SendTo("/ten33") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc33(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat34") // 1
	   @SendTo("/ten34") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc34(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat35") // 1
	   @SendTo("/ten35") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc35(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat36") // 1
	   @SendTo("/ten36") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc36(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat37") // 1
	   @SendTo("/ten37") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc37(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat38") // 1
	   @SendTo("/ten38") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc38(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat39") // 1
	   @SendTo("/ten39") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc39(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat40") // 1
	   @SendTo("/ten40") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc40(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat41") // 1
	   @SendTo("/ten41") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc41(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat42") // 1
	   @SendTo("/ten42") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc42(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat43") // 1
	   @SendTo("/ten43") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc43(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat44") // 1
	   @SendTo("/ten44") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc44(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat45") // 1
	   @SendTo("/ten45") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc45(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat46") // 1
	   @SendTo("/ten46") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc46(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat47") // 1
	   @SendTo("/ten47") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc47(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat48") // 1
	   @SendTo("/ten48") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc48(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat49") // 1
	   @SendTo("/ten49") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc49(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   
	   @MessageMapping("/chat50") // 1
	   @SendTo("/ten50") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc50(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat51") // 1
	   @SendTo("/ten51") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc51(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat52") // 1
	   @SendTo("/ten52") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc52(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat53") // 1
	   @SendTo("/ten53") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc53(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat54") // 1
	   @SendTo("/ten54") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc54(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat55") // 1
	   @SendTo("/ten55") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc55(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat56") // 1
	   @SendTo("/ten56") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc56(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat57") // 1
	   @SendTo("/ten57") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc57(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat58") // 1
	   @SendTo("/ten58") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc58(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat59") // 1
	   @SendTo("/ten59") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc59(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat60") // 1
	   @SendTo("/ten60") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc60(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat61") // 1
	   @SendTo("/ten61") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc61(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat62") // 1
	   @SendTo("/ten62") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc62(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat63") // 1
	   @SendTo("/ten63") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc63(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat64") // 1
	   @SendTo("/ten64") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc64(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat65") // 1
	   @SendTo("/ten65") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc65(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat66") // 1
	   @SendTo("/ten66") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc66(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat67") // 1
	   @SendTo("/ten67") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc67(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat68") // 1
	   @SendTo("/ten68") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc68(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat69") // 1
	   @SendTo("/ten69") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc69(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat70") // 1
	   @SendTo("/ten70") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc70(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat71") // 1
	   @SendTo("/ten71") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc71(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat72") // 1
	   @SendTo("/ten72") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc72(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat73") // 1
	   @SendTo("/ten73") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc73(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat74") // 1
	   @SendTo("/ten74") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc74(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat75") // 1
	   @SendTo("/ten75") // 3 response를 구독하고 있는 사람에게 send!
	   public List<TenderDTO> messageProc75(StompHeaderAccessor sha,String boardNum) {// 2
	      
	      String b = boardNum;
	      JsonParser parse = new JsonParser();
	      JsonElement boardNo = parse.parse(b);
	      String board= boardNo.getAsJsonObject().get("boardNum").toString();
	      
	      int board_no = Integer.parseInt(board);
	      
	      return dao.rank(board_no);
	      
	   }
	   @MessageMapping("/chat76") // 1
       @SendTo("/ten76") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc76(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat77") // 1
       @SendTo("/ten77") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc77(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat78") // 1
       @SendTo("/ten78") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc78(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat79") // 1
       @SendTo("/ten79") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc79(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat80") // 1
       @SendTo("/ten80") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc80(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat81") // 1
       @SendTo("/ten81") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc81(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat82") // 1
       @SendTo("/ten82") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc82(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat83") // 1
       @SendTo("/ten83") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc83(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat84") // 1
       @SendTo("/ten84") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc84(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat85") // 1
       @SendTo("/ten85") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc85(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat86") // 1
       @SendTo("/ten86") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc86(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat87") // 1
       @SendTo("/ten87") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc87(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat88") // 1
       @SendTo("/ten88") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc88(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat89") // 1
       @SendTo("/ten89") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc89(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat90") // 1
       @SendTo("/ten90") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc90(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat91") // 1
       @SendTo("/ten91") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc91(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat92") // 1
       @SendTo("/ten92") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc92(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat93") // 1
       @SendTo("/ten93") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc93(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat94") // 1
       @SendTo("/ten94") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc94(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat95") // 1
       @SendTo("/ten95") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc95(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat96") // 1
       @SendTo("/ten96") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc96(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat97") // 1
       @SendTo("/ten97") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc97(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat98") // 1
       @SendTo("/ten98") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc98(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat99") // 1
       @SendTo("/ten99") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc99(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
       @MessageMapping("/chat100") // 1
       @SendTo("/ten100") // 3 response를 구독하고 있는 사람에게 send!
       public List<TenderDTO> messageProc100(StompHeaderAccessor sha,String boardNum) {// 2
          
          String b = boardNum;
          JsonParser parse = new JsonParser();
          JsonElement boardNo = parse.parse(b);
          String board= boardNo.getAsJsonObject().get("boardNum").toString();
          
          int board_no = Integer.parseInt(board);
          
          return dao.rank(board_no);
          
       }
	   
	   
	   
}
