package assiment_test_product;

import java.util.List;



public interface Productdao {
	
	List<Product> getAllProducts();
	Product getProduct(String id) throws ProductNotFoundException;
	boolean addProduct(Product product);
	boolean deleteProduct(String id, String storeId);
	boolean updateProduct(Product product);

}
