package com.school.sba.service;

import org.springframework.http.ResponseEntity;

import com.school.sba.dto.ScheduldeRequest;
import com.school.sba.dto.ScheduldeResponse;
import com.school.sba.utility.ResponseStructure;

public interface ScheduldeService {

	ResponseEntity<ResponseStructure<ScheduldeResponse>> adminCreatesSchedulde(int schoolId,
			ScheduldeRequest scheduldeRequest);

	ResponseEntity<ResponseStructure<ScheduldeResponse>> findScheduleBySchoolId(int schoolId);

	ResponseEntity<ResponseStructure<ScheduldeResponse>> updateScheduleById(int scheduleldId,
			ScheduldeRequest scheduleldRequest);

}
