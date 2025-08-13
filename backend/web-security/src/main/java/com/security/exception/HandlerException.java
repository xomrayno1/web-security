package com.security.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.security.model.APIStatus;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class HandlerException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ValidateException.class)
	private ResponseEntity<ErrorDetail> handleValidateException(ValidateException exception, WebRequest request){
		ErrorDetail error = new ErrorDetail(exception.getCode(), exception.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.OK);
	} 
	
	@ExceptionHandler({AuthorizationDeniedException.class})
	private ResponseEntity<ErrorDetail> handleAuthorization(Exception exception, WebRequest request){
		log.error("Access denied ", exception);
		ErrorDetail error = new ErrorDetail(APIStatus.ERR_ACCESS_DENIED.getCode(), APIStatus.ERR_ACCESS_DENIED.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(Exception.class)
	private ResponseEntity<ErrorDetail> handleCommonException(Exception exception, WebRequest request){
		exception.printStackTrace();
		ErrorDetail error = new ErrorDetail(APIStatus.ERR_SYSTEM_COMMON.getCode(), APIStatus.ERR_SYSTEM_COMMON.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
 
	
	
	 
	 
}
