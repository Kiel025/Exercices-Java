package entities;

public class Individual extends TaxPayer {
	private Double healthExpenditures;

	public Individual() {
	}

	public Individual(String name, Double anualIncome) {
		super(name, anualIncome);
	}

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public double tax() {
		double basicTax = super.getAnualIncome() < 20000.00 ? super.getAnualIncome() * 1.15 - super.getAnualIncome()
				: super.getAnualIncome() * 1.25 - super.getAnualIncome();
		return healthExpenditures > 0 ? basicTax - (healthExpenditures * 0.5) : basicTax;
	}
}
