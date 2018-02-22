package com.solimar.domain;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Reservation {

	@SerializedName("id")
	private int id;
	
	private Guest guest;
	
	@SerializedName("arriveDate")
	private Date arriveDate;
	
	@SerializedName("departureDate")
	private Date departureDate;

	public Reservation(){};
	
	public Reservation(int id, Date arriveDate, Date departureDate) {
		super();
		this.id = id;
		this.arriveDate = arriveDate;
		this.departureDate = departureDate;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(Date arriveDate) {
		this.arriveDate = arriveDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	
}
