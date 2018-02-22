package com.solimar.controller.test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.solimar.views.ResponseView;

import hello.ReservationController;

public class ReservationTst {

    @Test
    public void checkReservationTest() {
        ReservationController controller = new ReservationController();
        ResponseView rv = controller.reservation("2018-03-15", "2018-03-17");

        // assert statements
        assertEquals(rv.getResponseStatus(), 0);
    }

}
