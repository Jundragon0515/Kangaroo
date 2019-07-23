package kh.spring.dto;

import java.sql.Date;

public class TenderDTO {

	private int seq;
	private String id;
	private String pw;
	private int point;
	private int board_num;
	private String time;
	private String ipaddress;
	private String board_title;
	private String board_img;
	private String onGoing;
	
	public TenderDTO(int seq, String id, String pw, int point, int board_num, String time, String ipaddress,
			String board_title, String board_img, String onGoing) {
		super();
		this.seq = seq;
		this.id = id;
		this.pw = pw;
		this.point = point;
		this.board_num = board_num;
		this.time = time;
		this.ipaddress = ipaddress;
		this.board_title = board_title;
		this.board_img = board_img;
		this.onGoing = onGoing;
	}

	public TenderDTO() {
		super();
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_img() {
		return board_img;
	}

	public void setBoard_img(String board_img) {
		this.board_img = board_img;
	}

	public String getOnGoing() {
		return onGoing;
	}

	public void setOnGoing(String onGoing) {
		this.onGoing = onGoing;
	}
	
	
	
	}
