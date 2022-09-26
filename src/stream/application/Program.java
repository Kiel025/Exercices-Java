package stream.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import stream.model.entities.Employee;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		System.out.print("Enter salary: ");
		Double salary = sc.nextDouble();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			List<Employee> employees = new ArrayList<>();
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}
			
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			
			List<String> emails = employees.stream()
					.filter(x -> x.getSalary() > salary)
					.map(x -> x.getEmail())
					.sorted(comp)
					.collect(Collectors.toList());
			
			double sum = employees.stream()
					.filter(x -> x.getName().charAt(0) == 'M')
					.map(x -> x.getSalary())
					.reduce(0.0, (x, y) -> x + y);
			
			System.out.println("Email of people whose salary is more than 2000.00:");
			emails.forEach(email -> System.out.println(email));
			
			System.out.printf("Sum of salary of people whose name starts with 'M': %.2f%n", sum);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
		
	}
	
}
