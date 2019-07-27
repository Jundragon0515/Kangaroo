package kh.spring.dto;

public class Auction_boardDTO {
	private int no;
	private String id;
	private String title;
	private String title_img;          
	private String phone;         
	private String contents;         // 내용
	private int viewCount;            // 조회수
	private String start_date;          // 시작일
	private int period;               // 남은 시간
	private String end_date;         // 종료일 
	private int starting_price;          // 시작가
	private int min_price;             // 최소단위
	private int present_price;         // 현재가
	private String member_class;      // 회원등급
	private int bid_count;            // 몇 명이 입찰했는지?
	private String category;         // 물품 카테고리
	private String delivery_type;      // 배송 유형
	private int delivery_cost;         // 배송비용
	private String onGoing;            // 진행중인지?
	public Auction_boardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Auction_boardDTO(int no, String id, String title, String title_img, String phone, String contents,
			int viewCount, String start_date, int period, String end_date, int starting_price, int min_price,
			int present_price, String member_class, int bid_count, String category, String delivery_type,
			int delivery_cost, String onGoing) {
		super();
		this.no = no;
		this.id = id;
		this.title = title;
		this.title_img = title_img;
		this.phone = phone;
		this.contents = contents;
		this.viewCount = viewCount;
		this.start_date = start_date;
		this.period = period;
		this.end_date = end_date;
		this.starting_price = starting_price;
		this.min_price = min_price;
		this.present_price = present_price;
		this.member_class = member_class;
		this.bid_count = bid_count;
		this.category = category;
		this.delivery_type = delivery_type;
		this.delivery_cost = delivery_cost;
		this.onGoing = onGoing;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle_img() {
		return title_img;
	}
	public void setTitle_img(String title_img) {
		this.title_img = title_img;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getStarting_price() {
		return starting_price;
	}
	public void setStarting_price(int starting_price) {
		this.starting_price = starting_price;
	}
	public int getMin_price() {
		return min_price;
	}
	public void setMin_price(int min_price) {
		this.min_price = min_price;
	}
	public int getPresent_price() {
		return present_price;
	}
	public void setPresent_price(int present_price) {
		this.present_price = present_price;
	}
	public String getMember_class() {
		return member_class;
	}
	public void setMember_class(String member_class) {
		this.member_class = member_class;
	}
	public int getBid_count() {
		return bid_count;
	}
	public void setBid_count(int bid_count) {
		this.bid_count = bid_count;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDelivery_type() {
		return delivery_type;
	}
	public void setDelivery_type(String delivery_type) {
		this.delivery_type = delivery_type;
	}
	public int getDelivery_cost() {
		return delivery_cost;
	}
	public void setDelivery_cost(int delivery_cost) {
		this.delivery_cost = delivery_cost;
	}
	public String getOnGoing() {
		return onGoing;
	}
	public void setOnGoing(String onGoing) {
		this.onGoing = onGoing;
	}
	


}