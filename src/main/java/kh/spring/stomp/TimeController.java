package kh.spring.stomp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import kh.spring.dao.DetailPageDAO;
import kh.spring.dao.MemberDAO;

@Controller
public class TimeController {
	
	@Autowired
	MemberDAO me;
	@Autowired
	DetailPageDAO de;
	@MessageMapping("/time")//
	@SendTo("/response")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc(StompHeaderAccessor sha, String end_dates) throws ParseException {
		List<String> result=new ArrayList<>();
		Gson gs = new Gson();
		JsonParser parse = new JsonParser();
		JsonElement ele = parse.parse(end_dates);
		JsonArray end=ele.getAsJsonObject().get("end_dates").getAsJsonArray();
		for(int i = 0 ; i<end.size();i++) {
			SimpleDateFormat a=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date b=a.parse(a.format(new Date()));
			Date c=a.parse(end.get(i).getAsString());
			if(b.getTime()>=c.getTime()) {
				result.add("종료");
			}else {
				SimpleDateFormat t = new SimpleDateFormat("dd HH:mm:ss");
				String time=t.format(c.getTime()-b.getTime()-(1*24*60*60*1000)-(9*60*60*1000));
				String [] times= time.split(" ");
				String day = times[0];
				if(day.equals("31")) {
					day="0";
				}
				String rest_time = times[1];
				String sum = day+"일 "+rest_time;
				result.add(sum);
			}
		}
		return result;
	}
	@MessageMapping("/end")
	public void end(StompHeaderAccessor sha, String no) {
		System.out.println(no);
		Gson gs = new Gson();
		JsonParser parse = new JsonParser();
		JsonElement ele = parse.parse(no);
		String end=ele.getAsJsonObject().get("no").getAsString();
		de.soldOut_Auction(Integer.parseInt(end));
	}
}
