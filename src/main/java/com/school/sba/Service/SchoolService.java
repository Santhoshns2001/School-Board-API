package com.school.sba.service;


import java.util.List;
import org.springframework.http.ResponseEntity;

import com.school.sba.dto.SchoolRequest;
import com.school.sba.dto.SchoolResponse;
import com.school.sba.dto.UserResponce;
import com.school.sba.entity.School;
import com.school.sba.utility.ResponseStructure;

public interface SchoolService {
	public ResponseEntity<ResponseStructure<School>> addSchool(School school);
	public ResponseEntity<ResponseStructure<School>> findSchool(int schoolId);
	public ResponseEntity<ResponseStructure<School>> updateSchool(int schoolId, School updatedSchool);
	public ResponseEntity<ResponseStructure<School>> deleteSchool(int schoolId);
	public ResponseEntity<ResponseStructure<List<School>>> findAll();
	
	
	
	public ResponseEntity<ResponseStructure<SchoolResponse>> adminCreateSchool(int userId, SchoolRequest school);
	
}