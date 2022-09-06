package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Person;

public class ProgramVect {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many people will be entered? ");
		int peoples = sc.nextInt();
		
		Person[] person = new Person[peoples];
		
		for (int i = 0; i < person.length; i++) {
			sc.nextLine();
			System.out.printf("Dados da %dª pessoa:%n", i + 1);
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Idade: ");
			int age = sc.nextInt();
			System.out.print("Altura: ");
			double height = sc.nextDouble();
			
			person[i] = new Person(name, age, height);
		}
		
		double sumHeight = 0.0;
		int minor = 0;
		for (Person p : person) {
			sumHeight += p.getHeight();
			if (p.getAge() < 16) {
				minor++;
			}
		}
		
		double avg = sumHeight / person.length;
		double minorPercent = minor * 100.0 / person.length;
		
		System.out.println();
		System.out.printf("Average Height: %.2f%n", avg);
		System.out.printf("Pessoas com menos de 16 anos: %.1f%%%n", minorPercent);
		if (minor != 0) {
			for (Person p : person) {	
				if (p.getAge() < 16) {
					System.out.println(p.getName());
				}
			}
		}
		sc.close();
	}
}
