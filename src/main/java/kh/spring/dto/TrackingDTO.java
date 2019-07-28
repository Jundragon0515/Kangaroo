package kh.spring.dto;

public class TrackingDTO {
	private String timeString;
	private String where;
	private String code;
	public TrackingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrackingDTO(String timeString, String where, String code) {
		super();
		this.timeString = timeString;
		this.where = where;
		this.code = code;
	}
	public String getTimeString() {
		return timeString;
	}
	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
