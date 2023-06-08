package assiment_test_product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StoreDaoImpl implements Storedao{
	
	static Logger logger = Logger.getLogger(StoreDaoImpl.class.getName());
	Connection con = Jdbc.getConnected();
	PreparedStatement ps = null;
	
	@Override
	public List<Store> getAllStores() {
		ResultSet rs = null;
		String sql = "SELECT * FROM store";
		List<Store> stores = new ArrayList<Store>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				stores.add(new Store(rs.getString(1),rs.getString(2),rs.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stores;
	}
	
	@Override
	public Store getStore(String id) throws StoreNotFoundException  {
		Store store=null;
		ResultSet rs = null;
		String sql = "SELECT * FROM store";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getString(1).equalsIgnoreCase(id)) {
				store = new Store(rs.getString(1),rs.getString(2),rs.getString(3));
				break;
				}
			}
		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		if (store==null) {
			throw new StoreNotFoundException();
		}
		return store;
	}
	
	@Override
	public boolean addStore(Store store) {
		boolean isAdded = false;
		String sql = "INSERT INTO store VALUES(?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, store.getStoreId());
			ps.setString(2, store.getStoreName());
			ps.setString(3, store.getAddress());
			int count = ps.executeUpdate();
			if(count > 0) {
				logger.info("added");
				isAdded = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public boolean deleteStore(String id) {
		boolean isDeleted = false;
		String sql = "DELETE FROM store WHERE store_id = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			int count = ps.executeUpdate();
			if(count > 0) {
				logger.info("deleted");
				isDeleted = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public boolean updateStore(Store store) {
		String upSql = "UPDATE store SET store_name = ? , store_address = ? WHERE store_id = ?";
		boolean isUpdate = false;
		try {
					ps = con.prepareStatement(upSql);
					ps.setString(1, store.getStoreName());
					ps.setString(2, store.getAddress());
					ps.setString(3, store.getStoreId());
					int count = ps.executeUpdate();
						if(count > 0) {
							logger.info("update");
							isUpdate = true;
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return isUpdate;
	}

	@Override
	public boolean assingProductsToStore(String storeId, String productId) throws SQLException {
		String sql = "UPDATE product SET store_id = ? WHERE product_id = ? AND store_id IS NULL";
		boolean flag=false;
		Productdao products = new ProductDaoImpl();
		List<Product> product = products.getAllProducts();
		for(Product pro : product) {
			if(pro.getId().equalsIgnoreCase(productId)) {
				ps = con.prepareStatement(sql);
				ps.setString(1, storeId);
				ps.setString(2, productId);
				int count = ps.executeUpdate();
				if(count > 0) {
					logger.info("updated");
					flag = true;
				}
				break;
			}
		}
		return flag;
	}

}
