package com.school.sba.exception;

public class SchoolNotFoundByIdException extends RuntimeException{
	private String message;

	public SchoolNotFoundByIdException(String message) {
		super();
		this.message = message;
	}
	
	
	@Override
	public String getMessage() {
		return message;
	}
	

}
