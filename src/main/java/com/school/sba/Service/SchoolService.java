package com.school.sba.Service;


import java.util.List;
import org.springframework.http.ResponseEntity;
import com.school.sba.Entity.School;
import com.school.sba.utility.ResponseStructure;

public interface SchoolService {
	public ResponseEntity<ResponseStructure<School>> addSchool(School school);
	public ResponseEntity<ResponseStructure<School>> findSchool(int schoolId);
	public ResponseEntity<ResponseStructure<School>> updateSchool(int schoolId, School updatedSchool);
	public ResponseEntity<ResponseStructure<School>> deleteSchool(int schoolId);
	public ResponseEntity<ResponseStructure<List<School>>> findAll();
	
}