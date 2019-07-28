package kh.spring.dto;

public class CommentDTO {

	private int seq;
	private int boardNum;
	private String id;
	private String contents;
	private String time;
	private String ipaddress;
	private String member_class;
	public CommentDTO(int seq, int boardNum, String id, String contents, String time, String ipaddress,
			String member_class) {
		super();
		this.seq = seq;
		this.boardNum = boardNum;
		this.id = id;
		this.contents = contents;
		this.time = time;
		this.ipaddress = ipaddress;
		this.member_class = member_class;
	}
	public CommentDTO() {
		super();
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
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
	public String getMember_class() {
		return member_class;
	}
	public void setMember_class(String member_class) {
		this.member_class = member_class;
	}
	
	
	
}
