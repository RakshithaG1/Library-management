import java.util.List;
import java.util.Optional;

public class Library {

	private List<Book>  books;
	private List<Author>  authors;
	private List<Patron>  patrons;
	
	public List<Book> getBooks() {
		return books;
	}
	public void addBooks(List<Book> books) {
		this.books = books;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void addAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public List<Patron> getPatrons() {
		return patrons;
	}
	public void addPatrons(List<Patron> patrons) {
		this.patrons = patrons;
	}
	public void borrowBook(Patron patron, String bookISBN) {
        Book book = findBookByISBN(bookISBN);
        if (book != null && book.getQuantity() > 0) {
            book.decrementQuantity();
            patron.addBorrowedBook(book);
            System.out.println("Book successfully borrowed.");
        } else {
            System.out.println("Book not available for borrowing.");
        }
    }

    public void returnBook(Patron patron, String bookISBN) {
        Book book = findBookByISBN(bookISBN);
        if (book != null && patron.hasBorrowedBook(book)) {
            book.incrementQuantity();
            patron.removeBorrowedBook(book);
            System.out.println("Book successfully returned.");
        } else {
            System.out.println("Book not found or not borrowed by this patron.");
        }
    }
    
    public Book findBookByISBN(String bookISBN) {
        Optional<Book> matchingBook = books.stream()
                .filter(book -> book.getISNB().equals(bookISBN))
                .findFirst();
        
        return matchingBook.orElse(null); // Returns the book or null if not found
    }
    
	public void displayBooks() {
		books.stream()
        .forEach(book -> {
        	System.out.println("ISBN number: " + book.getISNB());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Quantity: " + book.getQuantity());
            System.out.println();
        });
	}
}
