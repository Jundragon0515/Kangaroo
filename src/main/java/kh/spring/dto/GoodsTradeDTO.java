package kh.spring.dto;


public class GoodsTradeDTO {

	private int no;
	private String id;  //
	private String title;//
	private String title_img;//
	private String phone;
	private String contents;//
	private int viewcount;//
	private int price;//
	private String member_class;//
	private String account;//
	private String category;   //
	private String trade_type;//
	private String delivery;
	private int delivery_cost;
	private String joindate;//
	private String ongoing;//

	public GoodsTradeDTO() {
		super();
	}

	public GoodsTradeDTO(int no, String id, String title, String title_img, String phone, String contents,
			int viewcount, int price, String member_class, String account, String category, String trade_type,
			String delivery, int delivery_cost, String joindate, String ongoing) {
		super();
		this.no = no;
		this.id = id;
		this.title = title;
		this.title_img = title_img;
		this.phone = phone;
		this.contents = contents;
		this.viewcount = viewcount;
		this.price = price;
		this.member_class = member_class;
		this.account = account;
		this.category = category;
		this.trade_type = trade_type;
		this.delivery = delivery;
		this.delivery_cost = delivery_cost;
		this.joindate = joindate;
		this.ongoing = ongoing;
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

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
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

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public int getDelivery_cost() {
		return delivery_cost;
	}

	public void setDelivery_cost(int delivery_cost) {
		this.delivery_cost = delivery_cost;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public String getOngoing() {
		return ongoing;
	}

	public void setOngoing(String ongoing) {
		this.ongoing = ongoing;
	}



}