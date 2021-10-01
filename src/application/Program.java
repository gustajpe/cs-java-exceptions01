package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		System.out.print("Programa de Reservas.");
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check IN date: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check OUT date: ");
		Date checkOut = sdf.parse(sc.next());

		Date now = new Date();

		if (checkIn.before(now) || checkOut.before(now)) {
			System.out.print("Error in reservation: Datas não futuras.");
		
		} else if (!checkOut.after(checkIn)) {
			System.out.print("Error in reservation: Check-out must be after Check-in.");
		
		} else {
		
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			
			System.out.print("Reservation ok!.");
			System.out.print("Confirm and update Reservations:");

			System.out.print("Check IN update: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check OUT datupdatee: ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.print("Reservation: " + reservation);
		
		}
		
	}
}
