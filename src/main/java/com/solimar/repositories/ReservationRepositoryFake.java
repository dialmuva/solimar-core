package com.solimar.repositories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.solimar.domain.Reservation;

public class ReservationRepositoryFake implements IReservationRepository {
	
	public ArrayList<Reservation> getReservations() {
		return createFakeReservations();
	}
	
	private ArrayList<Reservation> createFakeReservations(){
		
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		for(int i=0; i<2; i++){
			cal.add(Calendar.DATE, +30);
			Date startDate1 = cal.getTime();
			
			cal.add(Calendar.DATE, +15);
			Date endDate1 = cal.getTime();
			
			Reservation r = new Reservation(i, startDate1, endDate1);
			reservations.add(r);
		}
		return reservations;
	}

}
