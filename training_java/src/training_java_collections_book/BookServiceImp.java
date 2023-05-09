package training_java_collections_book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookServiceImp implements BookInterface {

	Map<String, Book> map = new HashMap<>();

	public BookServiceImp(Map<String, Book> map) {
		super();
		this.map = map;
	}

	public Map<String, Book> getMap() {
		return map;
	}

	public void setMap(Map<String, Book> map) {
		this.map = map;
	}

	@Override
	public List<String> getBookByAuthorName(String authorName) {
		List<String> bookList = new ArrayList<>();
		for (Book book : map.values()) {
			if (book.getAuthor().getAuthorName().equalsIgnoreCase(authorName)) {
				bookList.add(book.getBookName());
			}
		}
		return bookList;
	}

	@Override
	public List<Book> getBookByPublisher(String publisherName) {
		List<Book> bookList = new ArrayList<>();
		for (Book book : map.values()) {
			if (book.getPublisher().getPublisherName().equalsIgnoreCase(publisherName)) {
				bookList.add(book);
			}
		}
		return bookList;
	}

	@Override
	public List<Book> getBookByYear(int year) {
		List<Book> bookList = new ArrayList<>();
		for (Book book : map.values()) {
			if (book.getPublishedYear() == year) {
				bookList.add(book);
			}
		}
		return bookList;
	}

	@Override
	public List<Book> getBookByNoOfPages(int noOfPages) {
		List<Book> bookList = new ArrayList<>();
		for (Book book : map.values()) {
			if (book.getNoOfPages() == noOfPages) {
				bookList.add(book);
			}
		}
		return bookList;
	}

	@Override
	public List<Book> getBookByName(String BookName) {
		List<Book> bookList = new ArrayList<>();
		for (Book book : map.values()) {
			if (book.getBookName().equalsIgnoreCase(BookName)) {
				bookList.add(book);
			}
		}
		return bookList;
	}

	@Override
	public List<Book> getBookByPrice(double price, String operation) {
		List<Book> bookList = new ArrayList<>();
		for (Book book : map.values()) {
			switch (operation) {
			case "Gerater Than":
				if (book.getPrice() > price)
					bookList.add(book);
				break;
			case "Lesser Than":
				if (book.getPrice() < price)
					bookList.add(book);
				break;
			case "Gerater Than Or Equal":
				if (book.getPrice() >= price)
					bookList.add(book);
				break;
			case "Lesser Than Or Equal":
				if (book.getPrice() <= price)
					bookList.add(book);
				break;
			}

		}
		return bookList;
	}

}
