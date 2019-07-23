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

	@MessageMapping("/chat2") // 1
	@SendTo("/response") // 3 response를 구독하고 있는 사람에게 send!
	public List<TenderDTO> messageProc(StompHeaderAccessor sha,String boardNum) {// 2
		
		String b = boardNum;
		JsonParser parse = new JsonParser();
		JsonElement boardNo = parse.parse(b);
		String board= boardNo.getAsJsonObject().get("boardNum").toString();
		
		int board_no = Integer.parseInt(board);
		
		return dao.rank(board_no);
		
	}
}
