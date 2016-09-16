package com.dworks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dworks.dto.model.CompanyDTO;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String uuid;
	
	private String externalId;
	private String name;
	private String email;
	private String phoneNumber;
	private String website;
	private String country;
	
	public Company() {	}
	
	public Company(CompanyDTO companyDTO) {
		this.uuid = companyDTO.getUuid();
		this.externalId = companyDTO.getExternalId();
		this.name = companyDTO.getName();
		this.email =companyDTO.getEmail();
		this.phoneNumber = companyDTO.getPhoneNumber();
		this.website = companyDTO.getWebsite();
		this.country = companyDTO.getCountry();
	}
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}	