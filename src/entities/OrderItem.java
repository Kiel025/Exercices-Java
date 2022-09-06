package entities;

public class OrderItem {
	private Integer quantity;
	private ProductOrder product;
	
	public OrderItem() {
	}

	public OrderItem(Integer quantity, ProductOrder product) {
		this.quantity = quantity;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double subTotal() {
		return product.getPrice() * quantity;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(product.getName());
		sb.append(", $");
		sb.append(String.format("%.2f",product.getPrice()));
		sb.append(", Quantity: ");
		sb.append(quantity);
		sb.append(", Subtotal: $");
		sb.append(String.format("%.2f",subTotal()));
		return sb.toString();
	}
}
