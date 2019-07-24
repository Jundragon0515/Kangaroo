package kh.spring.dto;

public class CartTradeDTO {
	private String id;
	private int no;
	private String title_img;
	private String title;
	private String trade_type;
	private String category;
	private int price;
	
	public CartTradeDTO() {
		super();
	}

	public CartTradeDTO(String id, int no, String title_img, String title, String trade_type, String category,
			int price) {
		super();
		this.id = id;
		this.no = no;
		this.title_img = title_img;
		this.title = title;
		this.trade_type = trade_type;
		this.category = category;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle_img() {
		return title_img;
	}

	public void setTitle_img(String title_img) {
		this.title_img = title_img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
}
