package kh.spring.dto;

public class ReportDTO {
	
	private int no;
	private String title;
	private String sender;
	private String reason;
	private String contents;	
	
	public ReportDTO() {
		super();
	}
	public ReportDTO(int no, String title, String sender, String reason, String contents) {
		super();
		this.no = no;
		this.title = title;
		this.sender = sender;
		this.reason = reason;
		this.contents = contents;
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
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}	
}
