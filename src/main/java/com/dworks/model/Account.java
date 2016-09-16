package com.dworks.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.dworks.dto.model.AccountDTO;
import com.dworks.enums.AccountStatus;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(generator = "accountId")
	@GenericGenerator(name = "accountId", strategy = "uuid")
	private String accountIdentifier;
	
	@Enumerated(EnumType.STRING)
	private AccountStatus status;
	
	public Account(){}
	
	public Account(AccountStatus accountStatus) {
		this.setStatus(accountStatus);
	}
	
	public Account(AccountDTO accountDTO) {
		this.accountIdentifier = accountDTO.getAccountIdentifier();
		this.status = AccountStatus.valueOf(accountDTO.getStatus());
	}
	
	public String getAccountIdentifier() {
		return accountIdentifier;
	}
	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}
	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
}
