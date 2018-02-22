package com.solimar.repositories;

import java.util.ArrayList;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.solimar.dataaccess.CouchbaseConnection;
import com.solimar.domain.Reservation;


public class ReservationRepository implements IReservationRepository{

	public ArrayList<Reservation> getReservations() {
		
		final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		CouchbaseConnection connection = new CouchbaseConnection();
		Bucket bucket = connection.getConnection();

		//JsonDocument reservationJson = bucket.get("RES-002");
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		
		N1qlQueryResult result = bucket.query(N1qlQuery.simple("SELECT * FROM solimar where recordtype = 'reservation'"));
		for(N1qlQueryRow row : result.allRows()) {
			String json = row.value().getObject("solimar").toString();
			Reservation reservation = gson.fromJson(json, Reservation.class);
			reservations.add(reservation);
			//Reservation r = new Reservation();
			//r.setId(json.getInt("id"));
			//r.setArriveDate(convertFromString(json.getString("arriveDate")));
			//r.setArriveDate(convertFromString(json.getString("departureDate")));
			//reservations.add(r);
		};
		
		//String json2 = reservationJson.content().toString();
		//Reservation reservation = gson.fromJson(json2, Reservation.class);
		//reservations.add(reservation);
		//TODO: handle it globally
		connection.close(bucket);
		
		return reservations;
	}

}