package com.solimar.repository.test;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;

import com.solimar.domain.Reservation;
import com.solimar.repositories.ReservationRepositorySQL;

public class ReservationRepositorySQLTest {

	@Test
    public void reservationRepositoryIsReturningReservationRecords() {
		
		ReservationRepositorySQL repo = new ReservationRepositorySQL();
		ArrayList<Reservation> reservations = repo.getReservations();
		assertTrue("Reservations were returned from db", reservations.size()>0);
    }
	
}

