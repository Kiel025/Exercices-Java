package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;

	public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static LocalDate now = LocalDate.now();

	public Reservation() {
	}

	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException{
		validateChecks(checkIn, checkOut);
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public long duration() {
		Duration duration = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay());
		return duration.toDays();
	}

	public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
		
		validateChecks(checkIn, checkOut);

		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public void validateChecks(LocalDate checkIn, LocalDate checkOut) throws DomainException {
		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			throw new DomainException("Reservation dates must be future dates");
		} else if (checkIn.isAfter(checkOut)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
	}

	@Override
	public String toString() {
		return "Reservation: Room " + roomNumber + ", check-in: " + checkIn.format(fmt) + ", check-out: "
				+ checkOut.format(fmt) + ", " + duration() + " nights";
	}
}
