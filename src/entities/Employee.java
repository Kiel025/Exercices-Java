package entities;

public class Employee {
	private String name;
	private double grossSalary;
	private double tax;
	
	public double netSalary() {
		return grossSalary - tax;
	}
	
	public void increaseSalary(double percent) {
		grossSalary += grossSalary / 100 * percent;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
}
