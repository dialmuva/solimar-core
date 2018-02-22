package com.solimar.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.solimar.views.ResponseView;

import hello.ReservationController;

public class ReservationTest {

    @Test
    public void checkReservationTest() {
        ReservationController controller = new ReservationController();
        ResponseView rv = controller.reservation("2018-01-01", "2018-01-10");

        // assert statements
        assertEquals(rv.getResponseStatus(), 0);
    }
}