package com.solimar.controller.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.solimar.views.ResponseView;

import hello.ReservationController;

public class ReservationControllerTest {
		
	@Test
    public void ReservationControllerReturnAvailability() {
		//arrange
		ReservationController controller = new ReservationController();
		String arriveDate = "2018-01-01";
		String departureDate = "2018-10-01";
		
		//act
		ResponseView rv = controller.reservation(arriveDate, departureDate);
		
		//assert
		assertTrue("Success! Dates are available", rv.isResponseStatusBool());
	}
	
	@Test
    public void ReservationControllerReturnUnavailable() {
		//arrange
		ReservationController controller = new ReservationController();
		String arriveDate = "2018-06-01";
		String departureDate = "2018-06-10";
		
		//act
		ResponseView rv = controller.reservation(arriveDate, departureDate);
		
		//assert
		assertFalse("Success! Dates are unavailable", rv.isResponseStatusBool());
	}
}
