package assiment_test_product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;



public class ProductDaoImpl implements Productdao{
	
	static Logger logger = Logger.getLogger(ProductDaoImpl.class.getName());
	Connection con = Jdbc.getConnected();
	PreparedStatement ps = null;
	
	
	@Override
	public List<Product> getAllProducts() {
		ResultSet rs = null;
		String sql = "SELECT * FROM product";
		List<Product> products = new ArrayList<Product>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				products.add(new Product(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	
	@Override
	public Product getProduct(String id) throws ProductNotFoundException {
		Product product = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM product";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getString(1).equalsIgnoreCase(id)) {
				product = new Product(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5));
				break;
				}
			}
		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		if(product == null) {
			throw new ProductNotFoundException();
		}
		return product;
	}

	@Override
	public boolean addProduct(Product product) {
		boolean isAdded = false;
		String sql = "INSERT INTO product VALUES(?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, product.getId());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setInt(4, product.getQty_on_hand());
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
	public boolean deleteProduct(String id, String storeId) {
		boolean isDeleted = false;
		String sql = null;
		if(!storeId.isEmpty()) {
			sql = "DELETE FROM product WHERE product_id = ? AND store_id = ?";
		}else {
			sql = "DELETE FROM product WHERE product_id = ? AND store_id IS NULL";
		}
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			if(!storeId.isEmpty())
				ps.setString(2, storeId);
			
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
	public boolean updateProduct(Product product) {
		String upSql = "UPDATE product SET product_description = ? , price = ? , qty_on_hand = ? WHERE product_id = ?";
		boolean isUpdate = false;
		try {
					ps = con.prepareStatement(upSql);
					ps.setString(1, product.getDescription());
					ps.setDouble(2, product.getPrice());
					ps.setInt(3, product.getQty_on_hand());
					ps.setString(4, product.getId());
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

}
