package kh.spring.dto;

public class AdminDTO {
	private int no;
	private int visitCount;
	private String visitDate;
	
	public AdminDTO(int no, int visitCount, String visitDate) {
		this.no = no;
		this.visitCount = visitCount;
		this.visitDate = visitDate;
	}
	
	public AdminDTO() {
		super();
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getVisitCount() {
		return visitCount;
	}
	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	
	
	
}
