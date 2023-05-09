package training_java_collections_book;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		Author author1 = new Author(13,"simbu",8192038473l,"simbu@simbu.com");
		Author author2 = new Author(14,"jai",7192038473l,"jai@jai.com");
		Author author3 = new Author(15,"jeva",6192038473l,"jeva@jeva.com");
		
		Publisher publisher1 = new Publisher(113,"b.k.books","no,1,b block");
		Publisher publisher2 = new Publisher(131,"d.k.books","no,2,d block");
		Publisher publisher3 = new Publisher(133,"e.k.books","no,3,e block");
		
		Book book1 = new Book(131513,"jailer",author1,3013,2013,350,publisher1);
		Book book2 = new Book(131514,"leo",author2,3013,2023,450,publisher1);
		Book book3 = new Book(131515,"vikram",author1,3013,2023,550,publisher2);
		
		Map<String, Book> map = new HashMap<>();
		BookServiceImp book = new BookServiceImp(map);
		
		map.put("book1", book1);
		map.put("book2", book2);
		map.put("book3", book3);
		
		System.out.println(book.getBookByAuthorName("simbu"));
		System.out.println(book.getBookByAuthorName("jai"));
		System.out.println(book.getBookByName("leo"));
		System.out.println(book.getBookByNoOfPages(3013));
		System.out.println(book.getBookByPrice(500, "Gerater Than"));
		System.out.println(book.getBookByPublisher("b.k.books"));
		System.out.println(book.getBookByYear(2013));
	}

}
