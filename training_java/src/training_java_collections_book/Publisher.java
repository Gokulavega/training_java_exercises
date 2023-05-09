package training_java_collections_book;

public class Publisher {
	
	private int publisherId;
	private String publisherName;
	private String address;
	public Publisher() {
		
	}
	public Publisher(int publisherId, String publisherName, String address) {
		super();
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.address = address;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", publisherName=" + publisherName + ", address=" + address
				+ "]";
	}
}
