package kh.spring.dto;

public class Used_transaction_boardDTO {

	private int no;
	private String id;
	private String title;
	private String title_img;
	private String phone;		
	private String contents;		
	private int viewCount;		
	private int price;
	private String member_class;
	private String account;					// 계좌
	private String category;
	private String trade_type;
	private String delivery_type;		// 배송 유형
	private int delivery_cost;			// 배송비용
	private String joinDate;				// 등록일시
	private String onGoing;
	
	public Used_transaction_boardDTO(int no, String id, String title, String title_img, String phone, String contents,
			int viewCount, int price, String member_class, String account, String category, String trade_type,
			String delivery_type, int delivery_cost, String joinDate, String onGoing) {
		this.no = no;
		this.id = id;
		this.title = title;
		this.title_img = title_img;
		this.phone = phone;
		this.contents = contents;
		this.viewCount = viewCount;
		this.price = price;
		this.member_class = member_class;
		this.account = account;
		this.category = category;
		this.trade_type = trade_type;
		this.delivery_type = delivery_type;
		this.delivery_cost = delivery_cost;
		this.joinDate = joinDate;
		this.onGoing = onGoing;
	}
	
	public Used_transaction_boardDTO() {
		super();
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMember_class() {
		return member_class;
	}

	public void setMember_class(String member_class) {
		this.member_class = member_class;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
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

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getOnGoing() {
		return onGoing;
	}

	public void setOnGoing(String onGoing) {
		this.onGoing = onGoing;
	}
	
	
	
}

	