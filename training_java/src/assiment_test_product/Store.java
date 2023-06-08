package assiment_test_product;

import java.util.Map;

public class Store {
	private String storeId;
    private String storeName;
	private String address;
	Map<String,Product> products;
	public Store() {
		
	}
	public Store(String storeId, String storeName, String address) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.address = address;
		this.products = products;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Map<String, Product> getProducts() {
		return products;
	}
	public void setProducts(Map<String, Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", storeName=" + storeName + ", address=" + address + ", products="
				+ products + "]";
	}
	
	
}
