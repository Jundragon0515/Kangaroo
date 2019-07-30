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
	@MessageMapping("/time1")//
	@SendTo("/response1")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc1(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/board1")//
	@SendTo("/board_re1")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc_bo1(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/board2")//
	@SendTo("/board_re2")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc_bo2(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/board3")//
	@SendTo("/board_re3")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc_bo3(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/board4")//
	@SendTo("/board_re4")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc_bo4(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/board5")//
	@SendTo("/board_re5")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc_bo5(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/board6")//
	@SendTo("/board_re6")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc_bo6(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/board7")//
	@SendTo("/board_re7")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc_bo7(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/board8")//
	@SendTo("/board_re8")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc_bo8(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/board9")//
	@SendTo("/board_re9")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc_bo9(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/board10")//
	@SendTo("/board_re10")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc_bo10(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time2")//
	@SendTo("/response2")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc2(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time3")//
	@SendTo("/response3")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc3(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time4")//
	@SendTo("/response4")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc4(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time5")//
	@SendTo("/response5")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc5(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time6")//
	@SendTo("/response6")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc6(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time7")//
	@SendTo("/response7")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc7(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time8")//
	@SendTo("/response8")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc8(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time9")//
	@SendTo("/response9")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc9(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time10")//
	@SendTo("/response10")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc10(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time11")//
	@SendTo("/response11")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc11(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time12")//
	@SendTo("/response12")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc12(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time13")//
	@SendTo("/response13")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc13(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time14")//
	@SendTo("/response14")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc14(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time15")//
	@SendTo("/response15")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc15(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time16")//
	@SendTo("/response16")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc16(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time17")//
	@SendTo("/response17")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc17(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time18")//
	@SendTo("/response18")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc18(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time19")//
	@SendTo("/response19")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc19(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time20")//
	@SendTo("/response20")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc20(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time21")//
	@SendTo("/response21")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
	public List<String> timeProc21(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
	@MessageMapping("/time22")//
    @SendTo("/response22")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc22(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
 
 @MessageMapping("/time23")//
    @SendTo("/response23")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc23(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
 
 
 
 
 @MessageMapping("/time24")//
    @SendTo("/response24")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc24(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
 
 
 @MessageMapping("/time25")//
    @SendTo("/response25")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc25(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
 
 
 @MessageMapping("/time26")//
    @SendTo("/response26")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc26(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
 
 
 
 @MessageMapping("/time27")//
    @SendTo("/response27")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc27(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
 
 
 
 @MessageMapping("/time28")//
    @SendTo("/response28")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc28(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
 
 
 
 
 @MessageMapping("/time29")//
    @SendTo("/response29")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc29(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
 
 
 
 @MessageMapping("/time30")//
    @SendTo("/response30")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc30(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
 
 
	@MessageMapping("/time31")//
    @SendTo("/response31")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc31(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
 @MessageMapping("/time32")//
    @SendTo("/response32")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc32(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
 
    @MessageMapping("/time33")//
    @SendTo("/response33")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc33(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
    
    @MessageMapping("/time34")//
    @SendTo("/response34")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc34(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
    
    @MessageMapping("/time35")//
    @SendTo("/response35")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc35(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
    
    @MessageMapping("/time36")//
    @SendTo("/response36")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc36(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
    
    @MessageMapping("/time37")//
    @SendTo("/response37")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc37(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
    
    @MessageMapping("/time38")//
    @SendTo("/response38")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc38(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
    
    @MessageMapping("/time39")//
    @SendTo("/response39")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc39(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
    
    @MessageMapping("/time40")//
    @SendTo("/response40")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc40(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
    @MessageMapping("/time41")//
    @SendTo("/response41")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc41(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
    
    @MessageMapping("/time42")//
    @SendTo("/response42")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc42(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
    
    @MessageMapping("/time43")//
    @SendTo("/response43")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc43(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
    
    @MessageMapping("/time44")//
    @SendTo("/response44")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc44(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
    
    @MessageMapping("/time45")//
    @SendTo("/response45")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc45(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
    
    @MessageMapping("/time46")//
    @SendTo("/response46")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc46(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
    
    @MessageMapping("/time47")//
    @SendTo("/response47")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc47(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
    
    @MessageMapping("/time48")//
    @SendTo("/response48")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc48(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
    
    @MessageMapping("/time49")//
    @SendTo("/response49")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc49(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
    
    @MessageMapping("/time50")//
    @SendTo("/response50")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc50(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
    @MessageMapping("/time51")//
    @SendTo("/response51")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc51(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   
   @MessageMapping("/time52")//
    @SendTo("/response52")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc52(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
  
  
   @MessageMapping("/time53")//
    @SendTo("/response53")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc53(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
  
   @MessageMapping("/time54")//
    @SendTo("/response54")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc54(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
  
   @MessageMapping("/time55")//
    @SendTo("/response55")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc55(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
  
   @MessageMapping("/time56")//
    @SendTo("/response56")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc56(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
  
   @MessageMapping("/time57")//
    @SendTo("/response57")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc57(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
  
   @MessageMapping("/time58")//
    @SendTo("/response58")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc58(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
  
   @MessageMapping("/time59")//
    @SendTo("/response59")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc59(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
  
   @MessageMapping("/time60")//
    @SendTo("/response60")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc60(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
  
   @MessageMapping("/time61")//
    @SendTo("/response61")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc61(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time62")//
    @SendTo("/response62")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc62(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time63")//
    @SendTo("/response63")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc63(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time64")//
    @SendTo("/response64")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc64(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time65")//
    @SendTo("/response65")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc65(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time66")//
    @SendTo("/response66")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc66(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time67")//
    @SendTo("/response67")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc67(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time68")//
    @SendTo("/response68")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc68(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time69")//
    @SendTo("/response69")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc69(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time70")//
    @SendTo("/response70")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc70(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
  
   @MessageMapping("/time71")//
    @SendTo("/response71")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc71(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time72")//
    @SendTo("/response72")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc72(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time73")//
    @SendTo("/response73")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc73(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time74")//
    @SendTo("/response74")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc74(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time75")//
    @SendTo("/response75")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc75(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time76")//
    @SendTo("/response76")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc76(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time77")//
    @SendTo("/response77")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc77(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time78")//
    @SendTo("/response78")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc78(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time79")//
    @SendTo("/response79")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc79(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time80")//
    @SendTo("/response80")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
    public List<String> timeProc80(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time81")//
   @SendTo("/response81")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc81(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
 @MessageMapping("/time82")//
   @SendTo("/response82")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc82(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time83")//
   @SendTo("/response83")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc83(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time84")//
   @SendTo("/response84")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc84(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time85")//
   @SendTo("/response85")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc85(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time86")//
   @SendTo("/response86")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc86(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time87")//
   @SendTo("/response87")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc87(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time88")//
   @SendTo("/response88")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc88(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time89")//
   @SendTo("/response89")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc89(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   @MessageMapping("/time90")//
   @SendTo("/response90")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc90(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
   
      @MessageMapping("/time91")//
   @SendTo("/response91")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc91(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
      @MessageMapping("/time92")//
   @SendTo("/response92")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc92(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
      @MessageMapping("/time93")//
   @SendTo("/response93")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc93(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
      @MessageMapping("/time94")//
   @SendTo("/response94")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc94(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
      @MessageMapping("/time95")//
   @SendTo("/response95")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc95(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
      @MessageMapping("/time96")//
   @SendTo("/response96")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc96(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
      @MessageMapping("/time97")//
   @SendTo("/response97")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc97(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
      @MessageMapping("/time98")//
   @SendTo("/response98")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc98(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
      @MessageMapping("/time99")//
   @SendTo("/response99")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc99(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
      @MessageMapping("/time100")//
   @SendTo("/response100")//chat으로 들어오면 이런작업을하고 response를 구독하고 있는애들 한테 보내라 
   public List<String> timeProc100(StompHeaderAccessor sha, String end_dates) throws ParseException {
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
