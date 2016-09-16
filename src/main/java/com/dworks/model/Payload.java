package com.dworks.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.dworks.dto.model.PayloadDTO;

@Entity
public class Payload {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@OneToOne(cascade = {CascadeType.MERGE})
	private User user;
	
	@OneToOne(cascade = {CascadeType.ALL})
    private Order order;

	@OneToOne(cascade = {CascadeType.ALL})
    private Company company;

    @OneToOne(cascade = {CascadeType.ALL})
    private Account account;
    
    public Payload() {}
    
	public Payload(PayloadDTO payloadDTO) {
		this.user = (payloadDTO.getUser() != null) ? new User(payloadDTO.getUser()) : null;
		this.order = (payloadDTO.getOrder() != null) ? new Order(payloadDTO.getOrder()) : null;
		this.company = (payloadDTO.getCompany() != null) ? new Company(payloadDTO.getCompany()) : null;
		this.account = (payloadDTO.getAccount() != null) ? new Account(payloadDTO.getAccount()) : null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
