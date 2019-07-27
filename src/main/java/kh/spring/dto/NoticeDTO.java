package kh.spring.dto;

import java.sql.Timestamp;

public class NoticeDTO {
	private int no;
	private String title;
	private String contents;
	private String image;
	private int viewcount;
	private Timestamp joindate;
	
	public NoticeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NoticeDTO(int no, String title, String contents, String image) {
		super();
		this.no = no;
		this.title = title;
		this.contents = contents;
		this.image = image;
	}
	
	
	public NoticeDTO(int no, String title, String contents) {
		super();
		this.no = no;
		this.title = title;
		this.contents = contents;
	}

	public NoticeDTO(String title, String contents, String image) {
		super();
		this.title = title;
		this.contents = contents;
		this.image = image;
	}

	public NoticeDTO(int no, String title, String contents, String image, int viewcount, Timestamp joindate) {
		super();
		this.no = no;
		this.title = title;
		this.contents = contents;
		this.image = image;
		this.viewcount = viewcount;
		this.joindate = joindate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	public Timestamp getJoindate() {
		return joindate;
	}

	public void setJoindate(Timestamp joindate) {
		this.joindate = joindate;
	}

	
	 
	
}
