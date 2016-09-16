package com.dworks.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.dworks.dto.model.EventDTO;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
	private MarketPlace marketplace;
	
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
	private User creator;
	
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
	private Payload payload;
	
	public Event() {}
	
	public Event(EventDTO eventDTO) {
		this.marketplace = new MarketPlace(eventDTO.getMarketplace());
		this.creator = new User(eventDTO.getCreator());
		this.payload = new Payload(eventDTO.getPayload());
		this.type = eventDTO.getType();
	}

	@Transient
	private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MarketPlace getMarketplace() {
		return marketplace;
	}

	public void setMarketplace(MarketPlace marketplace) {
		this.marketplace = marketplace;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
