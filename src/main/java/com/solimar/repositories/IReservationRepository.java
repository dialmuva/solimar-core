package com.solimar.repositories;

import java.util.ArrayList;

import com.solimar.domain.Reservation;

public interface IReservationRepository {
	
	public ArrayList<Reservation> getReservations();
	
}
