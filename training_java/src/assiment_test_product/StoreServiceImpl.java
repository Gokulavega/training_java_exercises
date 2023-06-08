package assiment_test_product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class StoreServiceImpl implements StoreService {
	Logger logger=Logger.getLogger(StoreServiceImpl.class.getName());
	Productdao products = new ProductDaoImpl();
	Connection con = Jdbc.getConnected();
	PreparedStatement ps = null;
	Storedao storedao=null;

public StoreServiceImpl()
{
	this.storedao=new StoreDaoImpl();
	//this.productService=new ProductServiceImpl();
}
	@Override
	public List<Store> findAllStores() {
		// TODO Auto-generated method stub
		return storedao.getAllStores();
	}
	
	@Override
	public Store findStore(String id) {
		Store store=null;
		try {
			 store=storedao.getStore(id);
		} catch (StoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return store;
	}
	
	@Override
	public boolean createStore(Store store) {
		// TODO Auto-generated method stub
		return storedao.addStore(store);
	}

	@Override
	public boolean removeStore(String id) {
		// TODO Auto-generated method stub
		return storedao.deleteStore(id);
	}

	@Override
	public boolean editStore(Store store) {
		// TODO Auto-generated method stub
		return storedao.updateStore(store);
	}

	@Override
	public boolean LoadProductsToStore(String storeId, String productId) throws SQLException {
		// TODO Auto-generated method stub
		return storedao.assingProductsToStore(storeId, productId);
	}

	@Override
	public int sellItem(String storeid,String productId,int qty) throws SQLException {
		int countQty = 0;
		String sql = "UPDATE product SET qty_on_hand = ? WHERE product_id = ? AND store_id = ?";
		List<Product> product = products.getAllProducts();
		for(Product pro : product) {
			if(pro.getId().equalsIgnoreCase(productId)) {
				if(pro.getStore_id().equalsIgnoreCase(storeid)) {
					if(pro.getQty_on_hand() >= qty) {
						ps = con.prepareStatement(sql);
						ps.setInt(1, pro.getQty_on_hand() - qty);
						ps.setString(2, productId);
						ps.setString(3, storeid);
						int count = ps.executeUpdate();
						if(count > 0) {
							logger.info("updated");
							countQty = pro.getQty_on_hand();
							checkQtyDetails(storeid, productId, product);
							break;
						}
					}else
						logger.info("quanty is less");
				}
			}
		}
		return countQty;
	}

	private void checkQtyDetails(String storeid, String productId, List<Product> product) {
		
		for(Product pro : product) {
			if(pro.getId().equalsIgnoreCase(productId)) {
				if(pro.getStore_id().equalsIgnoreCase(storeid)) {
					if(pro.getQty_on_hand() <= pro.getReorder_level()) {
						
						try (Workbook workBook = new XSSFWorkbook()) {
							Sheet sheet = workBook.createSheet("Data");
							
							Row headerRow = sheet.createRow(0);
							
							headerRow.createCell(0).setCellValue("Product_id");
							headerRow.createCell(1).setCellValue("Product_description");
							headerRow.createCell(2).setCellValue("Qty");
							headerRow.createCell(3).setCellValue("Store_id");
							
							Row dataRow = sheet.createRow(1);
							
							dataRow.createCell(0).setCellValue(pro.getId());
							dataRow.createCell(1).setCellValue(pro.getDescription());
							dataRow.createCell(2).setCellValue(pro.getReorder_qty());
							dataRow.createCell(3).setCellValue(pro.getStore_id());
							
							for(int i = 0; i < 3; i++) {
								sheet.autoSizeColumn(i);
							}
							
							String path = "C:\\Users\\Gokul\\Data.xlsx";
							
							try {
								FileOutputStream file = new FileOutputStream(path, true);
								try {
									workBook.write(file);
									System.out.println("execl is created");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	@Override
	public int purchasegoods(String storeid, String productId, int qty) throws SQLException {
		
		int countQty = 0;
		String sql = "UPDATE product SET qty_on_hand = ? WHERE product_id = ? AND store_id = ?";
		List<Product> product = products.getAllProducts();
		for (Product pro : product) {
			if (pro.getId().equalsIgnoreCase(productId)) {
				if (pro.getStore_id().equalsIgnoreCase(storeid)) {
					ps = con.prepareStatement(sql);
					ps.setInt(1, pro.getQty_on_hand() + qty);
					ps.setString(2, productId);
					ps.setString(3, storeid);
					int count = ps.executeUpdate();
					if (count > 0) {
						logger.info("updated");
						countQty = pro.getQty_on_hand();
						break;
					}
				}
			}
		}
		return countQty;
	}
	
	@Override
	public void productToWord() throws FileNotFoundException, IOException {
		
		XWPFDocument document = new XWPFDocument();
        
	      //Write the Document in file system
	      FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Gokul\\create_table.docx"));
	        
	      //create table
	      XWPFTable table = document.createTable();
			
	      //create first row
	      XWPFTableRow tableRowOne = table.getRow(0);
	      tableRowOne.getCell(0).setText("producy_id");
	      tableRowOne.addNewTableCell().setText("product_description");
	      tableRowOne.addNewTableCell().setText("product_qty");
	      tableRowOne.addNewTableCell().setText("store_id");
	      
	      List<Product> product = products.getAllProducts();
	      for (Product pro : product) {
			
	    	  XWPFTableRow tableRowTwo = table.createRow();
		      tableRowTwo.getCell(0).setText(pro.getId());
		      tableRowTwo.getCell(1).setText(pro.getDescription());
		      String s = String.valueOf(pro.getQty_on_hand());
		      tableRowTwo.getCell(2).setText(s);
		      tableRowTwo.getCell(3).setText(pro.getStore_id());
		      
	      }
	      
	      logger.info("word is created");
		
	      document.write(out);
	      out.close();
	}

}
