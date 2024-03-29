package com.school.sba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.sba.dto.AcademicProgramRequest;
import com.school.sba.dto.AcademicProgramResponse;
import com.school.sba.service.impli.AcademicProgramService;
import com.school.sba.utility.ResponseStructure;

@RestController
public class AcademicProgramController {
	
	@Autowired
	private AcademicProgramService academicProgramService;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/schools/{schoolId}/academicPrograms")
	public ResponseEntity<ResponseStructure<AcademicProgramResponse>> addsAcademicProgram(@PathVariable int schoolId, @RequestBody AcademicProgramRequest academicProgramRequest){
		return academicProgramService.addsAcademicProgram(schoolId, academicProgramRequest);
	}
	@GetMapping("/schools/{schoolId}/academicPrograms")
	public ResponseEntity<ResponseStructure<List<AcademicProgramResponse>>> fetchAllAcademicProgram(@PathVariable int schoolId){
		return academicProgramService.fetchAllAcademicProgram(schoolId);
	}
	
	

}
