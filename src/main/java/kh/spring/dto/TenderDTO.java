package kh.spring.dto;

import java.sql.Timestamp;

public class TenderDTO {
	private int seq;
	private int board_num;
	private String board_title;
	private String board_img;
	private String id;
	private int point;
	private Timestamp time;
	private String ipaddress;
	public TenderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TenderDTO(int seq, int board_num, String board_title, String board_img, String id, int point, Timestamp time,
			String ipaddress) {
		super();
		this.seq = seq;
		this.board_num = board_num;
		this.board_title = board_title;
		this.board_img = board_img;
		this.id = id;
		this.point = point;
		this.time = time;
		this.ipaddress = ipaddress;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	
 }
