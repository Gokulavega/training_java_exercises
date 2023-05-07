package training_java_map;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
	
	private int productId;
	private String description;
	private double price;
	private String categore;
	private LocalDate manufacturingDate;
	private LocalDate expireDate;
	private int quantityOnHands;
	public Product() {
	}
	public Product(int productId, String description, double price, String categore, LocalDate manufacturingDate,
			LocalDate expireDate, int quantityOnHands) {
		super();
		this.productId = productId;
		this.description = description;
		this.price = price;
		this.categore = categore;
		this.manufacturingDate = manufacturingDate;
		this.expireDate = expireDate;
		this.quantityOnHands = quantityOnHands;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public String getCategore() {
		return categore;
	}
	public void setCategore(String categore) {
		this.categore = categore;
	}
	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public LocalDate getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}
	public int getQuantityOnHands() {
		return quantityOnHands;
	}
	public void setQuantityOnHands(int quantityOnHands) {
		this.quantityOnHands = quantityOnHands;
	}
	@Override
	public int hashCode() {
		return Objects.hash(categore, description, expireDate, manufacturingDate, price, productId, quantityOnHands);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(categore, other.categore) && Objects.equals(description, other.description)
				&& Objects.equals(expireDate, other.expireDate)
				&& Objects.equals(manufacturingDate, other.manufacturingDate)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& productId == other.productId && quantityOnHands == other.quantityOnHands;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", description=" + description + ", price=" + price + ", categore="
				+ categore + ", manufacturingDate=" + manufacturingDate + ", expireDate=" + expireDate
				+ ", quantityOnHands=" + quantityOnHands + "]";
	}

}
