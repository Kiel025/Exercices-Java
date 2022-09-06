package entities;

public class ImportedProduct2 extends Product2 {
	private Double customsFee;
	
	public ImportedProduct2(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	@Override
	public String priceTag() {
		return super.getName() + " $ " + String.format("%.2f", (super.getPrice() + customsFee)) 
		+ " (Customs fee: $ " + String.format("%.2f", customsFee) + ")";
	}
}
