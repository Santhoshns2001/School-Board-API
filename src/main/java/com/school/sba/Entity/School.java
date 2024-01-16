package com.school.sba.Entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Component
public class School {
	@Id
	private  int schoolId;
	private String schoolName;
	private String schoolAddress;
	private String schoolEmail;
	private long schoolPhno;
	
	

}
