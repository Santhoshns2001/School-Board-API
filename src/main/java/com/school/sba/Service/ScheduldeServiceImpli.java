package com.school.sba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.sba.dto.ScheduldeRequest;
import com.school.sba.dto.ScheduldeResponse;
import com.school.sba.repositary.ScheduldeRepo;
import com.school.sba.repositary.SchoolRepository;
import com.school.sba.utility.ResponseStructure;
@Service
public class ScheduldeServiceImpli implements ScheduldeService{

//	@Autowired
//	private ScheduldeRepo scheduldeRepo;
//
//	@Autowired
//	private ResponseStructure<ScheduldeResponse> responseStructure;
//
//	@Autowired
//	private SchoolRepository schoolRepo;

	@Override
	public ResponseEntity<ResponseStructure<ScheduldeResponse>> adminAddSchedulde(int schoolId,
			ScheduldeRequest scheduldeRequest) {
		
		

		return null;
	}

}
