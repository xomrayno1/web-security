package com.security.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.security.utils.DateUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIResponse<T extends Object> implements Serializable {
	
	private static final long serialVersionUID = -2949637537989916289L;
	
	private T data;

	private String message;
	 
	private int code;
	
	@JsonFormat(shape = Shape.STRING, pattern = DateUtils.PATTERN_DATE_TIME_FORMAT)
	private LocalDateTime time = LocalDateTime.now();
	
	public APIResponse(APIStatus apiStatus, T data) {
		if(apiStatus == null) {
			throw new IllegalArgumentException("APIStatus must not be null");
		}
		this.data = data;
		this.message = apiStatus.getMessage();
		this.code = apiStatus.getCode();
	}
	
}


//	{
//	  "status": "success",
//	  "message": "Request was successful",
//	  "data": {
//	    // Your actual response data here
//	  },
//	  "error": null
//	}

//{
//	  "status": "error",
//	  "message": "An error occurred",
//	  "data": null,
//	  "error": {
//	    "code": "USER_NOT_FOUND",
//	    "description": "User with the given ID does not exist"
//	  }
//	}