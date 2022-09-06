package entities;

public class Account {
	private int number;
	private double balance;
	private String holder;
	
	public Account(int number, String holder) {
		this.number = number;
		this.holder = holder;
	}

	public Account(int number, double initialdeposit, String holder) {
		this.number = number;
		this.holder = holder;
		deposit(initialdeposit);
	}

	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount + 5;
	}
	
	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public int getNumber() {
		return number;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Account " + number + ", Holder: " + holder + ", Balance: $ " + String.format("%.2f", balance);
	}
}
