package file.entities;

public class Product {
	private String name;
	private double value;
	private int quantity;

	public Product(String name, double value, int quantity) {
		this.name = name;
		this.value = value;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public double totalValue() {
		return value * quantity;
	}

	@Override
	public String toString() {
		return name + "," + totalValue();
	}
}
