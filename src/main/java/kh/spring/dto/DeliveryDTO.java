package kh.spring.dto;

public class DeliveryDTO {
	private int seq;
	private int product_num;
	private int company_num;
	private String waybill_num;
	private String sender;
	private String recipient;
	public DeliveryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeliveryDTO(int seq, int product_num, int company_num, String waybill_num, String sender, String recipient) {
		super();
		this.seq = seq;
		this.product_num = product_num;
		this.company_num = company_num;
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
	public int getCompany_num() {
		return company_num;
	}
	public void setCompany_num(int company_num) {
		this.company_num = company_num;
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
