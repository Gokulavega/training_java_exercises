package training_java_collections_book;

public class Book {
	
	private long bookIsbn;
	private String bookName;
	private Author author;
	private int noOfPages;
	private int publishedYear;
	private int price;
	private Publisher publisher;
	
	public Book() {
		
	}
	public Book(int bookId, String bookName, Author author, int noOfPages, int publishedYear, int price,
			Publisher publisher) {
		super();
		this.bookIsbn = bookId;
		this.bookName = bookName;
		this.author = author;
		this.noOfPages = noOfPages;
		this.publishedYear = publishedYear;
		this.price = price;
		this.publisher = publisher;
	}
	public long getBookId() {
		return bookIsbn;
	}
	public void setBookId(int bookId) {
		this.bookIsbn = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public int getNoOfPages() {
		return noOfPages;
	}
	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}
	public int getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookIsbn + ", bookName=" + bookName + ", author=" + author + ", noOfPages=" + noOfPages
				+ ", publishedYear=" + publishedYear + ", price=" + price + ", publisher=" + publisher + "]";
	}

}
