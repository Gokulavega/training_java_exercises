package assiment_test_product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface StoreService {
	
	List<Store> findAllStores();
	Store findStore(String id);
	boolean createStore(Store store);
	boolean removeStore(String id);
	boolean editStore(Store store);
	boolean LoadProductsToStore(String storeId, String productId) throws SQLException;
	int sellItem(String storeid,String ProductId,int qty) throws SQLException;
	int purchasegoods(String storeid,String productId,int qty) throws SQLException;
	public void productToWord() throws FileNotFoundException, IOException;
}
