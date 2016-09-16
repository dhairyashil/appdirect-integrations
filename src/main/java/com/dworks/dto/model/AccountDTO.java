package com.dworks.dto.model;

import com.dworks.model.Account;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AccountDTO {
	private String accountIdentifier;
	private String status;
	
	public AccountDTO(Account account) {
		this.accountIdentifier = account.getAccountIdentifier();
		this.status = account.getStatus().name();
	}
	
	public AccountDTO() {}
	
	public String getAccountIdentifier() {
		return accountIdentifier;
	}
	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
