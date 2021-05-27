package com.hibernate.demo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adress {
	
	@Column(name="street")
	private String street ;
	
	
	@Column(name="state")
	private String state;
	
	
	@Column(name= "pincode")
	private String pincode ;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	
	
	
}
