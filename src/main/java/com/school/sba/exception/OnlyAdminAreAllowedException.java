package com.school.sba.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OnlyAdminAreAllowedException extends RuntimeException {
	
	private  String message;
	
	@Override
	public String getMessage() {
		return message;
	}
	
	

}
