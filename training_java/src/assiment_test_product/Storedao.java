package assiment_test_product;

import java.sql.SQLException;
import java.util.List;

public interface Storedao {
	List<Store> getAllStores();
	Store getStore(String id) throws StoreNotFoundException;
	boolean addStore(Store store);
	boolean deleteStore(String id);
	boolean updateStore(Store store);
	boolean assingProductsToStore(String storeId, String productId) throws SQLException;

}
