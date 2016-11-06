package edu.mum.abcVolunteering.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String city;
	private String state;
	private int zip;
	
	public Address(String city, String state, int zip) {
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getZip() {
		return zip;
	}
	
	
	
	
}
