package com.security.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.security.model.APIResponse;
import com.security.model.APIStatus;

public class ResponseUtils {
	private ResponseUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static ResponseEntity<APIResponse> responseSuccess(Object data) {
		return buildResponse(APIStatus.OK, data, HttpStatus.OK);
	}
 
	public static ResponseEntity<APIResponse> buildResponse(APIStatus apiStatus, Object data, HttpStatus httpStatus) {
		return new ResponseEntity<>(new APIResponse<Object>(apiStatus, data), httpStatus);
	}

}
