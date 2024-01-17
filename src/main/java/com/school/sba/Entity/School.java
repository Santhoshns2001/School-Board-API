package com.school.sba.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int schoolId;
	private String schoolName;
	private long contactNo;
	private String emailId;
	private String schoolAddress;
	
//	@OneToOne
//	private Schedulde schedulde;
	
	
	
	
	
	

}
