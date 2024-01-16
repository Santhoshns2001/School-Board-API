package com.school.sba.entity;

import com.school.sba.Enum.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(unique = true)
	private String  username; 
	private String userPassword;
	private String userFirstName;
	private String userLastName;
	private long usercontNo;
	@Column(unique = true)
	private String useremail;
	private UserRole userRole;
	
	
	
	
	
	
	
	

}
