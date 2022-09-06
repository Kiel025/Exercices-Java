package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account2;
import exceptions.BusinessException;

public class ProgramAccount2 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the account data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Initial balance: ");
		double initialBalance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();

		Account2 acc = new Account2(number, name, initialBalance, withdrawLimit);

		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		
		try {
			acc.withdraw(amount);
			System.out.printf("New balance: %.2f", acc.getBalance());
		} catch (BusinessException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} finally {
			sc.close();
		}
	}
}
