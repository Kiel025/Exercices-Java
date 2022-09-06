package entities;

public class Rent {
	private String name, email;

	public Rent(String name, String email) {
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return name + ", " + email;
	}
}
