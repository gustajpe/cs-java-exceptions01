package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	// STATIC = é necessario apenas 1, havendo varias instancias. Entao para varias instancias é colocado o Static.
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
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

	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		
		// Calculo de diferença do Tempo:
		long diff = checkOut.getTime() - checkIn.getTime();
		
		// Calculo de retorno em Dias:
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	

	public void updateDates(Date checkIn, Date checkOut) {
		this.checkOut = checkOut;
		this.checkIn = checkIn;
	}
	
	
	// Por natureza o toString é um Override.
	@Override
	public String toString() {
		return "Room: "
				+ roomNumber
				+ ", CheckIn: "
				+ sdf.format(checkIn)
				+ ", CheckOut: "
				+ sdf.format(checkOut)
				+ ", Duration: "
				+ duration() + " nights.";		}	

	
	
	
}
