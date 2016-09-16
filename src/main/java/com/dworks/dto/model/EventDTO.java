package com.dworks.dto.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class EventDTO {
	private String type;
	private MarketPlaceDTO marketplace;
	private String applicationUuid;
	private String flag;
	private UserDTO creator;
	private PayloadDTO payload;
	private String returnUrl;
	private List<String> links;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public MarketPlaceDTO getMarketplace() {
		return marketplace;
	}
	public void setMarketplace(MarketPlaceDTO marketplace) {
		this.marketplace = marketplace;
	}
	public String getApplicationUuid() {
		return applicationUuid;
	}
	public void setApplicationUuid(String applicationUuid) {
		this.applicationUuid = applicationUuid;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public UserDTO getCreator() {
		return creator;
	}
	public void setCreator(UserDTO creator) {
		this.creator = creator;
	}
	public PayloadDTO getPayload() {
		return payload;
	}
	public void setPayload(PayloadDTO payload) {
		this.payload = payload;
	}
	public String getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public List<String> getLinks() {
		return links;
	}
	public void setLinks(List<String> links) {
		this.links = links;
	}
}
