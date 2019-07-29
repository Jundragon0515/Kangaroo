package kh.spring.dto;

public class ReportDTO {
	
	private int no;
	private String sender;
	private String type;
	private String joindate;
	private String ipaddress;
	private String title;
	private String reason;
	private String contents;	
	
	public ReportDTO() {
		super();
	}

	public ReportDTO(int no, String sender, String type, String joindate, String ipaddress, String title, String reason,
			String contents) {
		super();
		this.no = no;
		this.sender = sender;
		this.type = type;
		this.joindate = joindate;
		this.ipaddress = ipaddress;
		this.title = title;
		this.reason = reason;
		this.contents = contents;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
