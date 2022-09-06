package entities;

public class Product {
	
	private String name;
	private double price;
	private int quantity;
	
	public double totalValueInStock() {
		return this.price * this.quantity;
	}
	
	@Override
	public String toString() {
		return "Product [name = " + name + ", price = $" + String.format("%.2f", price) + ", quantity = " + quantity + ", total = $" + String.format("%.2f", totalValueInStock()) + "]";
	}

	public void addProducts(int quantity) {
		this.quantity += quantity;
	}
	
	public void removeProducts(int quantity) {
		this.quantity -= quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}
}
