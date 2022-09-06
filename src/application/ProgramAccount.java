package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class ProgramAccount {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Account acc;
		
		System.out.print("Enter account number: ");
		int number = sc.nextInt();
		System.out.print("Enter account holder: ");
		sc.nextLine();	
		String holder = sc.nextLine();
		System.out.print("Is there an initial deposit (y/n)? ");
		char response = sc.next().charAt(0);
		
		if (Character.toLowerCase(response) == 'y') {
			System.out.print("Enter initial deposit value: ");
			double initialDeposit = sc.nextDouble();
			
			acc = new Account(number, initialDeposit, holder);
		} else {
			acc = new Account(number, holder);
		}
		
		System.out.println("\nAccount data: ");
		System.out.println(acc);
		System.out.println();
		
		System.out.print("Enter a deposit value: ");
		double deposit = sc.nextDouble();
		acc.deposit(deposit);
		System.out.println("Updated account data:");
		System.out.println(acc);
		System.out.println();
		
		System.out.print("Enter a withdraw value: ");
		double withdraw = sc.nextDouble();
		acc.withdraw(withdraw);
		System.out.println("Updated account data:");
		System.out.println(acc);
		
		sc.close();
	}

}
