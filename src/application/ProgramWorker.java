package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class ProgramWorker {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.next();
		System.out.println();
		System.out.println("Enter Worker data:");
		System.out.print("Name: ");
		sc.nextLine();
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.next();
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();
		System.out.println();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(level), baseSalary, new Department(departmentName));
		
		System.out.print("How many contracts to this worker? ");
		int c = sc.nextInt();
		for (int i = 0; i < c; i++) {
			System.out.println("Enter contract #" + (i + 1) + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			String date = sc.next();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate data = LocalDate.parse(date, fmt);
			
			HourContract contract = new HourContract(data, valuePerHour, hours);
			
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String calculate = sc.next();
		
		String[] splitted = calculate.split("/");
		
		double income = worker.income(splitted[0], splitted[1]);
		
		System.out.printf("Name: %s%n", worker.getName());
		System.out.printf("Department: %s%n", worker.getDepartment());
		System.out.printf("Income for %s: %.2f%n", calculate, income);
		
		sc.close();
	}
}
