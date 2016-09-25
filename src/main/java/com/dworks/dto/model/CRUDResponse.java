package com.dworks.dto.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CRUDResponse implements BaseResponse {
	private String errorCode;
	private String message;

	private String id;
	private boolean success;
	
	public CRUDResponse(boolean success,String id) {
    	this.success = success;
        this.id = id;
	}
    
    public CRUDResponse(boolean success, String errorCode, String message) {
    	this.success = success;
        this.errorCode = errorCode;
        this.message = message;
	}
    
    public CRUDResponse(String message ,boolean success) {
    	this.success = success;
        this.message = message;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
}
