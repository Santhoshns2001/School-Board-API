package com.school.sba.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.sba.dto.SchoolRequest;
import com.school.sba.dto.SchoolResponse;
import com.school.sba.dto.UserResponce;
import com.school.sba.entity.School;
import com.school.sba.service.SchoolService;
import com.school.sba.utility.ResponseStructure;


@RestController
public class SchoolController{
	@Autowired	
	private SchoolService schoolService;

	@PostMapping
	public ResponseEntity<ResponseStructure<School>> addSchool(@RequestBody School school) {
		return schoolService.addSchool(school);
	}
	@GetMapping("/schools/{schoolId}")
	public ResponseEntity<ResponseStructure<School>> findSchool(@PathVariable int schoolId) {
		return schoolService.findSchool(schoolId);
	}
	@PutMapping("/schools/{schoolId}")
	public ResponseEntity<ResponseStructure<School>> updateSchool(@PathVariable int schoolId, @RequestBody School school) {
		return schoolService.updateSchool(schoolId, school);
	}
	@DeleteMapping("/schools/{schoolId}")
	public ResponseEntity<ResponseStructure<School>> deleteSchool(@PathVariable int schoolId) {
		return schoolService.deleteSchool(schoolId);
	}
	@GetMapping("/schools/findAll")
	public ResponseEntity<ResponseStructure<List<School>>> findAll() {
		return schoolService.findAll();
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/users/schools")
	public ResponseEntity<ResponseStructure<SchoolResponse>> adminCreateSchool (@RequestBody SchoolRequest school){
		return schoolService.adminCreateSchool(school);
	}
	
	
	
	
}