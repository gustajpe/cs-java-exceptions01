package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		System.out.print("Programa de Reservas.");
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check IN date: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check OUT date: ");
		Date checkOut = sdf.parse(sc.next());

		Reservation reservation = new Reservation(number, checkIn, checkOut);

		System.out.print("Reservation ok!.");
		System.out.print("Confirm and update Reservations:");

		System.out.print("Check IN update: ");
		checkIn = sdf.parse(sc.next());
		System.out.print("Check OUT datupdatee: ");
		checkOut = sdf.parse(sc.next());

		String error = reservation.updateDates(checkIn, checkOut);

		if (error != null) {
			System.out.print("Reservation: " + reservation);
		} else {
			System.out.print("Error in Reservation: " + error);
		}

		sc.close();
	}
}
