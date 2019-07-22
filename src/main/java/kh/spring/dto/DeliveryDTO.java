package kh.spring.dto;

public class DeliveryDTO {
	private int seq;
	private int product_num;
	private int company_code;
	private String waybill_num;
	private String sender;
	private String recipient;
	public DeliveryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeliveryDTO(int seq, int product_num, int company_code, String waybill_num, String sender,
			String recipient) {
		super();
		this.seq = seq;
		this.product_num = product_num;
		this.company_code = company_code;
		this.waybill_num = waybill_num;
		this.sender = sender;
		this.recipient = recipient;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getProduct_num() {
		return product_num;
	}
	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}
	public int getCompany_code() {
		return company_code;
	}
	public void setCompany_code(int company_code) {
		this.company_code = company_code;
	}
	public String getWaybill_num() {
		return waybill_num;
	}
	public void setWaybill_num(String waybill_num) {
		this.waybill_num = waybill_num;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
	
}
