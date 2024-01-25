package com.school.sba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.sba.dto.ScheduldeRequest;
import com.school.sba.dto.ScheduldeResponse;
import com.school.sba.service.ScheduldeService;
import com.school.sba.utility.ResponseStructure;

@RestController
public class ScheduldeController {
	
	@Autowired
	private ScheduldeService scheduldeService;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/schools/{schoolId}/scheduldes")
	public ResponseEntity<ResponseStructure<ScheduldeResponse>> adminAddSchedulde(@PathVariable int schoolId,@RequestBody ScheduldeRequest scheduldeRequest){
		return scheduldeService.adminCreatesSchedulde(schoolId,scheduldeRequest);
	}
	
	@GetMapping("/schools/{schoolId}/schedules")
	public ResponseEntity<ResponseStructure<ScheduldeResponse>> findScheduleBySchoolId(@PathVariable int schoolId) {
		return scheduldeService.findScheduleBySchoolId(schoolId);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping("schedules/{scheduleldId}")
	public ResponseEntity<ResponseStructure<ScheduldeResponse>> updateScheduleById(@PathVariable int scheduleldId, @RequestBody ScheduldeRequest scheduleldRequest) {
		return scheduldeService.updateScheduleById(scheduleldId, scheduleldRequest);
	}

}
