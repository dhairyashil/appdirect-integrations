package com.dworks.exceptions;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1641148161780224690L;

	public UserNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserNotFoundException(final String message){
		super(message);
	}
}
