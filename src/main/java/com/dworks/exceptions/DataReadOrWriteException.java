package com.dworks.exceptions;

public class DataReadOrWriteException extends RuntimeException {
	
	private static final long serialVersionUID = -2263299031046550752L;

	public DataReadOrWriteException(final String message){
		super(message);
	}
}
