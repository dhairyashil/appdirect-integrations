package com.dworks.enums;

public class ResponseCodes {
	
	public static final String ACCOUNT_NOT_FOUND_ERROR_CODE = "ACCOUNT_NOT_FOUND";
	public static final String INVALID_RESPONSE_ERROR_CODE = "INVALID_RESPONSE";
	public static final String UNAUTHORIZED_ERROR_CODE = "UNAUTHORIZED";
	public static final String USER_NOT_FOUND_ERROR_CODE = "USER_NOT_FOUND";
	
	public static final String ACCOUNT_NOT_FOUND_ERROR_MESSAGE = "Account Not present with accountId: ";
	public static final String INVALID_RESPONSE_ERROR_MESSAGE = "Error during event processing";
	public static final String UNAUTHORIZED_ERROR_MESSAGE = "You are not authorized to access this resource";
	public static final String USER_NOT_FOUND_ERROR_MESSAGE = "User Not present with id: ";
	public static final String USER_DELETED_SUCCESS = "User deleted successfully with id: ";
}
