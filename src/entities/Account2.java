package entities;

import exceptions.BusinessException;

public class Account2 {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account2() {
	}

	public Account2(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) throws BusinessException{
		validateWithdraw(amount);
		balance -= amount;
	}
	
	private void validateWithdraw(double amount) throws BusinessException{
		if (amount > withdrawLimit) {
			throw new BusinessException("The amount exceeds withdraw limit");
		} else if (amount > balance){
			throw new BusinessException("Not enough balance");
		}
	}
}
