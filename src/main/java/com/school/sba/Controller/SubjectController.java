package com.school.sba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.sba.dto.AcademicProgramResponse;
import com.school.sba.dto.SubjectRequest;
import com.school.sba.service.SubjectService;
import com.school.sba.utility.ResponseStructure;

@RestController
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@PostMapping("/academic-programs/{programId}/subjects")
	public ResponseEntity<ResponseStructure<AcademicProgramResponse>> addSubjectToAcademicProgram(@RequestBody SubjectRequest subjectRequest,@PathVariable int programId){
		return subjectService.addSubjectToAcademicProgram(subjectRequest,programId);
	}
	
	
}
