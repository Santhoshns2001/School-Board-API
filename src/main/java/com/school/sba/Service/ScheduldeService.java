package com.school.sba.service;

import org.springframework.http.ResponseEntity;

import com.school.sba.dto.ScheduldeRequest;
import com.school.sba.dto.ScheduldeResponse;
import com.school.sba.utility.ResponseStructure;

public interface ScheduldeService {

	ResponseEntity<ResponseStructure<ScheduldeResponse>> adminAddSchedulde(int schoolId,
			ScheduldeRequest scheduldeRequest);

}
