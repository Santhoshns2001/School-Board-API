package com.school.sba.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
	
	@OneToOne
	private Schedulde scheduldeId;
	
	@OneToMany
	private List<AcademicProgram> academicProgram;
	
	
	
	
	
	

}
