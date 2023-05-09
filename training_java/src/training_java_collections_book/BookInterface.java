package training_java_collections_book;

import java.util.List;

public interface BookInterface {
	
	List<String> getBookByAuthorName(String authorName);
	
	List<Book> getBookByPublisher(String publisherName);
	
	List<Book> getBookByYear(int year);
	
	List<Book> getBookByNoOfPages(int noOfPages);
	
	List<Book> getBookByName(String BookName);
	
	List<Book> getBookByPrice(double price, String operation);

}
