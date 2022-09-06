package entities;

public class Student {
	private String name;
	private double grade1, grade2, grade3;

	public double finalGrade() {
		return grade1 + grade2 + grade3;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGrade1(double grade1) {
		this.grade1 = grade1;
	}

	public void setGrade2(double grade2) {
		this.grade2 = grade2;
	}

	public void setGrade3(double grade3) {
		this.grade3 = grade3;
	}
}
