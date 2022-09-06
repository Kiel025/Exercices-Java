package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct2;
import entities.Product2;
import entities.UsedProduct2;

public class ProgramProduct2 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product2> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common, used or imported (c, u, i)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if (Character.toLowerCase(type) == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				
				products.add(new ImportedProduct2(name, price, customsFee));
			} else if (Character.toLowerCase(type) == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate manufactureDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
				System.out.println(manufactureDate);
				
				products.add(new UsedProduct2(name, price, manufactureDate));
			} else {
				products.add(new Product2(name, price));
			}
			
		}
		System.out.println();
		
		System.out.println("PRICE TAGS:");
		for (Product2 p : products) {
			System.out.println(p.priceTag());
		}
		
		sc.close();
	}
}
