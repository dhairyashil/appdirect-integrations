package com.dworks.exceptions;

public class UnauthorizedClientException extends RuntimeException {
	
	private static final long serialVersionUID = -1074097620542642568L;

	public UnauthorizedClientException(final String message){
		super(message);
	}
	
	public UnauthorizedClientException(final Throwable cause){
		super(cause);
	}
	
	public UnauthorizedClientException(final String message, final Throwable cause){
		super(message, cause);
	}
}
