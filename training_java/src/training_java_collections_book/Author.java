package training_java_collections_book;

public class Author {
	
	private int authorId;
	private String authorName;
	private long contactNumber;
	private String emailId;
	
	public Author(int authorId, String authorName, long contactNumber, String emailId) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
	}

	public Author() {
		
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", contactNumber=" + contactNumber
				+ ", emailId=" + emailId + "]";
	}
	
}
