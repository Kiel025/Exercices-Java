package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.ProductOrder;
import entities.enums.OrderStatus;

public class ProgramOrder {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth Date: ");
		String birthDate = sc.next();
		System.out.println();
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		
		Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(status), new Client(name, email, LocalDate.parse(birthDate, fmt)));
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Enter #" + (i + 1) + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			ProductOrder product = new ProductOrder(productName, productPrice);
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			OrderItem item = new OrderItem(quantity, product);
			order.addItem(item);
		}
		
		System.out.println();
		System.out.println("ORDER SUMARY:");
		System.out.println("Order moment: " + order.getMoment().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client: " + order.getClient());
		System.out.println("Order items:");
		for (OrderItem item : order.getOrder()) {
			System.out.println(item);
		}
		System.out.printf("Total Price: $%.2f", order.total());
		sc.close();
	}
}
