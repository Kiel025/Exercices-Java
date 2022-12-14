package set.application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import set.model.entities.Student;

public class Program {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Set<Student> students = new HashSet<>();
		
		System.out.print("How many students for course A? ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int id = sc.nextInt();
			students.add(new Student(id));
		}
		
		System.out.print("How many students for course B? ");
		n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int id = sc.nextInt();
			students.add(new Student(id));
		}
		
		System.out.print("How many students for course C? ");
		n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int id = sc.nextInt();
			students.add(new Student(id));
		}
		
		System.out.println("Total students: " + students.size());
		
		sc.close();
		
	}
}
