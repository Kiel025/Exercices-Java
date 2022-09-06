package entities;

public class Rectangle {
	private double width;
	private double height;
	
	public double area() {
		return width * height;
	}
	
	public double perimeter() {
		return 2 * width + 2 * height;
	}

	public double diagonal() {
		return Math.sqrt(width * width + height * height);
	}
	
	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
