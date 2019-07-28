package kh.spring.dto;

public class CartAuctionDTO {
	private String id;
	private int no;
	private String title_img;
	private String title;
	private String end_date;
	private String category;
	private int price;
	
	public CartAuctionDTO() {
		super();
	}

	public CartAuctionDTO(String id, int no, String title_img, String title, String end_date, String category,
			int price) {
		super();
		this.id = id;
		this.no = no;
		this.title_img = title_img;
		this.title = title;
		this.end_date = end_date;
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

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
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
