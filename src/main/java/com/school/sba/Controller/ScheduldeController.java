package com.school.sba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/schools/{schoolId}/scheduldes")
	public ResponseEntity<ResponseStructure<ScheduldeResponse>> adminAddSchedulde(@PathVariable int schoolId,@RequestBody ScheduldeRequest scheduldeRequest){
		return scheduldeService.adminAddSchedulde(schoolId,scheduldeRequest);
	}

}
