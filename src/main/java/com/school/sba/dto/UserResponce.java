package com.school.sba.dto;

import org.springframework.stereotype.Component;

import com.school.sba.Enum.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class UserResponce {
	
	private int userId;
	private String  username; 
	private String userFirstName;
	private String userLastName;
	private long userContNo;
	private String userEmail;
	private UserRole userRole;
}


