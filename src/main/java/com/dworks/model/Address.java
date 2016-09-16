package com.dworks.model;

import javax.persistence.Embeddable;

import com.dworks.dto.model.AddressDTO;

@Embeddable
public class Address {
	private String city;
	private String country;
	private String phone;
	private String state;
	private String street1;
	private String street2;
	private String zip;
	
	public Address() {	}
	
	public Address(AddressDTO addressDTO) {
		this.city = addressDTO.getCity();
		this.country = addressDTO.getCountry();
		this.phone = addressDTO.getPhone();
		this.state = addressDTO.getState();
		this.street1 = addressDTO.getStreet1();
		this.street2 = addressDTO.getStreet2();
		this.zip = addressDTO.getZip();
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	
	
}
