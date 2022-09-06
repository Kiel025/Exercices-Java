package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee3;
import entities.OutsourcedEmployee3;

public class ProgramEmployee3 {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee3> employees = new ArrayList<>();

		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Employee #" + (i + 1) + " data:");
			System.out.print("Outsourced (y/n)? ");
			char outsourced = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();

			if (Character.toLowerCase(outsourced) == 'y') {
				System.out.print("Additional charge: ");
				double additionalCharge = sc.nextDouble();

				employees.add(new OutsourcedEmployee3(name, hours, valuePerHour, additionalCharge));
			} else {
				employees.add(new Employee3(name, hours, valuePerHour));
			}
			System.out.println();
		}

		System.out.println("PAYMENTS:");

		for (Employee3 emp : employees) {
			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
		}
		
		sc.close();
	}
}
