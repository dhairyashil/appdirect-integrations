package com.dworks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dworks.dto.model.MarketPlaceDTO;

@Entity
public class MarketPlace {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String partner;
	private String baseUrl;
	
	public MarketPlace() {	}
	
	public MarketPlace(MarketPlaceDTO placeDTO) {
		this.partner = placeDTO.getPartner();
		this.baseUrl = placeDTO.getBaseUrl();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
}
