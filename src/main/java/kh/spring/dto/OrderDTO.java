package kh.spring.dto;

import java.sql.Timestamp;

public class OrderDTO {
	private int seq;
	private int product_num;
	private String product_title;
	private String product_img;
	private String seller;
	private String buyer;
	private int price;
	private String type;
	private Timestamp join_date;
	private String situation;
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDTO(int seq, int product_num, String product_title, String product_img, String seller, String buyer,
			int price, String type, Timestamp join_date, String situation) {
		super();
		this.seq = seq;
		this.product_num = product_num;
		this.product_title = product_title;
		this.product_img = product_img;
		this.seller = seller;
		this.buyer = buyer;
		this.price = price;
		this.type = type;
		this.join_date = join_date;
		this.situation = situation;
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
	public String getProduct_title() {
		return product_title;
	}
	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Timestamp getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Timestamp join_date) {
		this.join_date = join_date;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	
}
