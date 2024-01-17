package com.school.sba.utility;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.school.sba.exception.AdminNotFoundException;
import com.school.sba.exception.UserNotFoundByIdException;



@RestControllerAdvice
public class ApplicationHandler extends ResponseEntityExceptionHandler{
	
	private ResponseEntity<Object> structure(HttpStatus status, String message, Object rootCause) {
		return new ResponseEntity<Object> (Map.of(
				"status",status.value(),
				"message",message,
				"rootCause",rootCause),status);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<ObjectError> allErrors = ex.getAllErrors();
		
		Map<String, String> errors=new HashMap<String,String>();
		allErrors.forEach(error ->{
			FieldError fieldError=(FieldError)error;
			errors.put(fieldError.getField(),fieldError.getDefaultMessage());
		});
		return structure (HttpStatus.BAD_REQUEST,"failed to save the data",errors);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handlerAdminNotFoundById(AdminNotFoundException ex) {
		return structure (HttpStatus.FOUND,ex.getMessage(),"only one admin is allowed");
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handlerUserNotFoundById(UserNotFoundByIdException ex) {
		return structure (HttpStatus.NOT_FOUND,ex.getMessage(),"user not found by the id provided");
	}

	
	
	
	 

} 