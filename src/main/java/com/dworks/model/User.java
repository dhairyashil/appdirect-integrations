package com.dworks.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dworks.dto.model.UserDTO;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String uuid;
	private String email;
	private String firstName;
	private String lastName;
	private String openId;
	private String language;
	
	@Embedded
	private Address address;
	
	public User() {}
	
	public User(UserDTO userDTO) {
		this.uuid = userDTO.getUuid();
		this.email = userDTO.getEmail();
		this.firstName = userDTO.getFirstName();
		this.lastName = userDTO.getLastName();
		this.openId = userDTO.getOpenId();
		this.language = userDTO.getLanguage();
		this.address = (userDTO.getAddress() != null) ? new Address(userDTO.getAddress()) : null;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
