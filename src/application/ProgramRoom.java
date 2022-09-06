package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Rent;

public class ProgramRoom {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Rent[] rooms = new Rent[10];
		
		System.out.print("How many roons will be rented? ");
		int n = sc.nextInt();
		System.out.println();
		
		for (int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.printf("Rent #%d:%n", i+1);
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.next();
			System.out.print("Room: ");
			int room = sc.nextInt();
			System.out.println();
			
			rooms[room] = new Rent(name, email);
		}
		
		System.out.println("Busy Rooms:");
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i] != null) {
				System.out.printf("%d: %s%n", i, rooms[i]);
			}
		}
		sc.close();
	}
}
