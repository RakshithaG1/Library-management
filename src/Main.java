import java.util.ArrayList;
import java.util.Scanner;
import java.util.SplittableRandom;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Library library = new Library();
		int choice = 0;
		while(true)
		{
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch(choice)
			{
			case 0 :
			Book book = new Book();
			System.out.println("Enter book title:");
            book.setTitle(scanner.next());
            System.out.println("Enter book author name");
            Author author = new Author();
            author.setAuthorName("MadhwaAcharya");
            book.setAuthor(author);
            System.out.println("Enter book quantity:");
            book.setQuantity(scanner.nextInt());
            int ISBN = new SplittableRandom().nextInt(0, 1_001);
            book.setISNB(String.valueOf(ISBN));
            List<Book> listOfBooks= new ArrayList<Book>();
            listOfBooks.add(book);
            library.addBooks(listOfBooks);
            break;
			case 1:
				break;
				
			case 2:
				library.displayBooks();
				break;
			case 3:
				System.out.println("Enter book Id");
				String bookId= scanner.next();
				Book book1 = library.findBookByISBN(bookId);
				System.out.println(book1.getTitle());
				System.out.println(book1.getAuthor());
				break;
			case 4:
				break;	
			}
		}
	}

}
