package assiment_test_product;

import java.util.List;

public interface ProductService {
	List<Product> findAllProducts();
	Product findProduct(String id) throws ProductNotFoundException;
	boolean createProduct(Product product);
	boolean removeProduct(String id, String storeId);
	boolean editProduct(Product product);
	
}
