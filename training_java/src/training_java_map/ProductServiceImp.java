package training_java_map;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImp implements ProductInterface {

	Map<Integer, Product> map = new HashMap<>();
	
	@Override
	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		return new ArrayList(map.values());
	}

	@Override
	public List<Product> getProductByName(String name) {
		List<Product> productList = new ArrayList<>();
		for(Product product : map.values()) {
			if(product.getDescription().equalsIgnoreCase(name)) {
				productList.add(product);
			}
		}
		return productList;
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return map.get(id);
	}

	@Override
	public boolean addProduct(Product product) {
		boolean flag = false;
		map.put(product.getProductId(), product);
		if(map.get(product.getProductId()) != null)
			flag = true;
		return flag;
	}

	@Override
	public boolean deleteProduct(Product product) {
		boolean flag = false;
		map.remove(product.getProductId());
		if(map.get(product.getProductId()) == null)
			flag = true;
		return flag;
	}

	@Override
	public Product updateProduct(Product Product) {
		Product updateProduct = null;
		updateProduct = map.get(Product.getProductId());
		updateProduct.setDescription(Product.getDescription());
		updateProduct.setCategore(Product.getCategore());
		updateProduct.setExpireDate(Product.getExpireDate());
		updateProduct.setManufacturingDate(Product.getManufacturingDate());
		updateProduct.setPrice(Product.getPrice());
		updateProduct.setQuantityOnHands(Product.getQuantityOnHands());
		map.put(Product.getProductId(), updateProduct);
		return updateProduct;
	}

	@Override
	public List<Product> getExpireDate() {
		List<Product> productListExpire = new ArrayList<>();
		LocalDate date = LocalDate.now();
		int month = date.getMonthValue();
		for(Product product : map.values()) {
		if(product.getExpireDate().getMonthValue() == month)
			productListExpire.add(product);
		}
		return productListExpire;
	}

	@Override
	public List<Product> getManufacturingDate() {
		List<Product> productListManufacture = new ArrayList<>();
		LocalDate date = LocalDate.now();
		int month = date.getMonthValue();
		for(Product product : map.values()) {
		if(product.getManufacturingDate().getMonthValue() == month)
			productListManufacture.add(product);
		}
		return productListManufacture;
	}

}
