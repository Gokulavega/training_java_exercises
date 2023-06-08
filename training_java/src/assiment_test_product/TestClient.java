package assiment_test_product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class TestClient {
	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
	
	StoreService storeService=new StoreServiceImpl();
	ProductService productservice=new ProductServiceImpl(); 
	storeService.createStore(new Store("ST001","Pandian Store-chromepet","chrompet Tambaram"));
	if(productservice.createProduct(new Product("PR001","pen",89.60,30,"null"))) {
		System.out.println("successfully product added");
	}
	
	System.out.println(storeService.LoadProductsToStore("ST001", "PR001"));
	
	storeService.sellItem("ST001", "PR001", 3);
	
	storeService.purchasegoods("ST001", "PR001", 23);
	
	TreeSet<Product> pro = new TreeSet<Product>(new PriceComparator());
	pro.addAll(productservice.findAllProducts());
	pro.forEach(s -> System.out.println(s));
	
	List<Product> proPrice = new ArrayList<Product>(productservice.findAllProducts());
	
	Collections.sort(proPrice, new PriceComparator());
	
	proPrice.forEach(sp -> System.out.println(sp));
	
	storeService.productToWord();
	
	}
}
