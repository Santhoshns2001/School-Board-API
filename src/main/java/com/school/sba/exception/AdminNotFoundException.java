package com.school.sba.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AdminNotFoundException extends RuntimeException {
	
	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}

}
