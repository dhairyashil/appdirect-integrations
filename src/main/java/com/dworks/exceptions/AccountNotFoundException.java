package com.dworks.exceptions;

public class AccountNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -8120960554053838804L;

	public AccountNotFoundException(final String message){
		super(message);
	}
}
