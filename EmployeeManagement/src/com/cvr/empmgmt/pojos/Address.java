package com.cvr.empmgmt.pojos;

import java.io.Serializable;

public class Address implements Serializable{
	
	private String street;
	private String city;
	private String state;
	private String country;
	private long pincode;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String city, String state, String country, long pincode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
}
