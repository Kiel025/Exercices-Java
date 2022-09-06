package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee2;

public class ProgramEmployee2 {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee2> list = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();

		System.out.println();
		for (int i = 0; i < n; i++) {

			System.out.println("Employee #" + (i + 1) + ":");

			int id;
			Integer pos;
			do {
				System.out.print("Id: ");
				id = sc.nextInt();
				pos = position(list, id);
				if (pos != null)
					System.out.println("This id already taken!");
			} while (pos != null);

			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			System.out.println();

			list.add(new Employee2(id, name, salary));
		}

		System.out.print("Enter the employee id that will have salary increase: ");
		int idSalary = sc.nextInt();

		Integer pos = position(list, idSalary);
		if (pos == null)
			System.out.println("This id does not exist!");
		else {
			System.out.print("Enter the percentage: ");
			list.get(pos).increaseSalary(sc.nextInt());
		}
		System.out.println();

		System.out.println("List of employees:");
		for (Employee2 emp : list)
			System.out.println(emp);

		sc.close();
	}

	public static Integer position(List<Employee2> list, int id) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
}
