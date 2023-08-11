
public class Book {

	private String ISNB;
	private String title;
	private Author author;
	private int quantity;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getISNB() {
		return ISNB;
	}
	public void setISNB(String iSNB) {
		ISNB = iSNB;
	}
	public void incrementQuantity() {
		this.quantity++;
	}
	public void decrementQuantity() {
		this.quantity--;		
	}
}
