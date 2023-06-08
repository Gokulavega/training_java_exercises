package assiment_test_product;

import java.util.List;

public class ProductServiceImpl implements ProductService{

	Productdao dao=null;
	
	public ProductServiceImpl() {
		this.dao=new ProductDaoImpl();
	}
	
	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return dao.getAllProducts();
	}
	
	@Override
	public Product findProduct(String id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return dao.getProduct(id);
	}

	@Override
	public boolean createProduct(Product product) {
		// TODO Auto-generated method stub
		return dao.addProduct(product);
	}

	@Override
	public boolean removeProduct(String id, String storeId) {
		// TODO Auto-generated method stub
		return dao.deleteProduct(id, storeId);
	}

	@Override
	public boolean editProduct(Product product) {
		// TODO Auto-generated method stub
		return dao.updateProduct(product);
	}

}
