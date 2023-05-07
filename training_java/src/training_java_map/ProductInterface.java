package training_java_map;

import java.util.List;

public interface ProductInterface {
	
	List<Product> getProduct();
	
	List<Product> getProductByName(String name);
	
	Product getProductById(int id);
	
	boolean addProduct(Product product);
	
	boolean deleteProduct(Product product);
	
	Product updateProduct(Product Product);
	
	List<Product> getExpireDate();
	
	List<Product> getManufacturingDate();

}
