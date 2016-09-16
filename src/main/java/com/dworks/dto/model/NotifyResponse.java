package com.dworks.dto.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotifyResponse {
	
	private boolean success;
    private String errorCode;
    private String message;
    private String accountIdentifier;
    
    public NotifyResponse(boolean success) {
        this.success = success;
    }

    public NotifyResponse(boolean success,String accountIdentifier) {
    	this.success = success;
        this.accountIdentifier = accountIdentifier;
	}
    
    public NotifyResponse(boolean success, String errorCode, String message) {
    	this.success = success;
        this.errorCode = errorCode;
        this.message = message;
	}
    
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAccountIdentifier() {
		return accountIdentifier;
	}
	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}
}
