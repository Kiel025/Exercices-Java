package entities;

public class Company extends TaxPayer {
	private Integer numberOfEmployees;

	public Company() {
	}

	public Company(String name, Double anualIncome) {
		super(name, anualIncome);
	}

	public Company(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public double tax() {
		return numberOfEmployees > 10 ? super.getAnualIncome() * 1.14 - super.getAnualIncome()
				: super.getAnualIncome() * 1.16 - super.getAnualIncome();
	}
}
