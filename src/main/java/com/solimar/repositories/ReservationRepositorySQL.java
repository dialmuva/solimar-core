package com.solimar.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.solimar.dataaccess.PostgreSQLConnection;
import com.solimar.domain.Reservation;

public class ReservationRepositorySQL implements IReservationRepository {

	public ArrayList<Reservation> getReservations() {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		try {
			PostgreSQLConnection postgresprovider = new PostgreSQLConnection();
			Connection connection = postgresprovider.getConnection();
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id, arriveDate, departureDate FROM Reservation");
			
			while (rs.next()) {
				Reservation reservation = new Reservation();
				reservation.setId(rs.getInt("id"));
				reservation.setArriveDate(convertFromString(rs.getDate("arriveDate").toString()));
				reservation.setDepartureDate(convertFromString(rs.getDate("departureDate").toString()));
				reservations.add(reservation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservations;
	}
	
    private Date convertFromString(String dateString){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(dateString);
            System.out.println(date);
            System.out.println(formatter.format(date));
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
