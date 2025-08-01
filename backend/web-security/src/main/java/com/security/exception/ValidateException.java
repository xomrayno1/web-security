package com.security.exception;

import com.security.model.APIStatus;

import lombok.Getter;

@Getter
public class ValidateException extends RuntimeException{
	
	private static final long serialVersionUID = 1688896810961317551L;
	
	private final int code;
	private final String message;
	
	public ValidateException(APIStatus apiStatus) {
		if(apiStatus == null) {
			throw new IllegalArgumentException("APIStatus must not be null");
		}
		this.code = apiStatus.getCode();
		this.message = apiStatus.getMessage();
	}

	public ValidateException(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	

}
