package assiment_test_product;

public class Product {
	private String id;
	private String description;
	private double price;
	private int qty_on_hand;
	private int reorder_level;
	private int reorder_qty;
	private String store_id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty_on_hand() {
		return qty_on_hand;
	}
	public void setQty_on_hand(int qty_on_hand) {
		this.qty_on_hand = qty_on_hand;
	}
	public int getReorder_level() {
		return reorder_level;
	}
	public void setReorder_level(int reorder_level) {
		this.reorder_level = reorder_level;
	}
	public int getReorder_qty() {
		return reorder_qty;
	}
	public void setReorder_qty(int reorder_qty) {
		this.reorder_qty = reorder_qty;
	}
	public String getStore_id() {
		return store_id;
	}
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", price=" + price + ", qty_on_hand="
				+ qty_on_hand + ", reorder_level=" + reorder_level + ", reorder_qty=" + reorder_qty + ", store_id="
				+ store_id + "]";
	}
	public Product(String id, String description, double price, int qty_on_hand, String store_id) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.qty_on_hand = qty_on_hand;
		this.reorder_level = reorder_level = 10;
		this.reorder_qty = reorder_qty = 50;
		this.store_id = store_id;
	}
	
	public Product() {
		
	}
	
	
}
