import java.util.List;
import java.util.Optional;

public class Patron {

	private String patronName;
	private String libraryCardNumber;
	private List<Book>  booksBorrowed;
	
	public String getPatronName() {
		return patronName;
	}
	public void setPatronName(String patronName) {
		this.patronName = patronName;
	}
	public String getLibraryCardNumber() {
		return libraryCardNumber;
	}
	public void setLibraryCardNumber(String libraryCardNumber) {
		this.libraryCardNumber = libraryCardNumber;
	}
	public List<Book> getBooksBorrowed() {
		return booksBorrowed;
	}
	public void setBooksBorrowed(List<Book> booksBorrowed) {
		this.booksBorrowed = booksBorrowed;
	}
	public void removeBorrowedBook(Book book) {
		booksBorrowed.removeIf(booksBorrowed -> booksBorrowed.getISNB().equals(book.getISNB()));
	}
	public boolean hasBorrowedBook(Book borrowedBook) {
        Optional<Book> matchingBook = booksBorrowed.stream()
                .filter(book -> book.getISNB() == borrowedBook.getISNB())
                .findFirst();
        
        return matchingBook.orElse(null) != null;	
        }
	public void addBorrowedBook(Book book) {
		booksBorrowed.add(book);
	}
}
