package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Reservation;
import exceptions.DomainException;

public class ProgramReservation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			System.out.print("Room number: ");
			Integer roomNumber = sc.nextInt();
			System.out.print("Check-in date (DD/MM/YYYY): ");
			LocalDate checkIn = LocalDate.parse(sc.next(), fmt);
			System.out.print("Check-out date (DD/MM/YYYY): ");
			LocalDate checkOut = LocalDate.parse(sc.next(), fmt);

			Reservation rsv = new Reservation(roomNumber, checkIn, checkOut);

			System.out.println(rsv);

			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkIn = LocalDate.parse(sc.next(), fmt);
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkOut = LocalDate.parse(sc.next(), fmt);
			rsv.updateDates(checkIn, checkOut);
			System.out.println(rsv);
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}

		sc.close();
	}

}
