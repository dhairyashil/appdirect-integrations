package com.dworks.error;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dworks.dto.model.NotifyResponse;
import com.dworks.enums.ResponseCodes;

@RestController
public class UnauthorizedAccessErrorController implements ErrorController {

	private static final String PATH = "/error";
	private static final String ERROR_CODE = ResponseCodes.UNAUTHORIZED_ERROR_CODE;
	private static final String ERROR_MESSAGE = ResponseCodes.UNAUTHORIZED_ERROR_MESSAGE;

	@RequestMapping(value = PATH)
	public NotifyResponse error() {
		return new NotifyResponse(false, ERROR_CODE, ERROR_MESSAGE);
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

}
