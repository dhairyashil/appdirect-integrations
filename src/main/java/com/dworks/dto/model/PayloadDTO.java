package com.dworks.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PayloadDTO {

	private UserDTO user;
	private AccountDTO account;
	private CompanyDTO company;
	private OrderDTO order;
	private NoticeDTO notice;
	
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public AccountDTO getAccount() {
		return account;
	}
	public void setAccount(AccountDTO account) {
		this.account = account;
	}
	public CompanyDTO getCompany() {
		return company;
	}
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	public OrderDTO getOrder() {
		return order;
	}
	public void setOrder(OrderDTO order) {
		this.order = order;
	}
	public NoticeDTO getNotice() {
		return notice;
	}
	public void setNotice(NoticeDTO notice) {
		this.notice = notice;
	}
	
}
