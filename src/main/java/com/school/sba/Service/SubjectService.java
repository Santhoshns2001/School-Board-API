package com.school.sba.service;

import org.springframework.http.ResponseEntity;

import com.school.sba.dto.AcademicProgramResponse;
import com.school.sba.dto.SubjectRequest;
import com.school.sba.utility.ResponseStructure;

public interface SubjectService {

	ResponseEntity<ResponseStructure<AcademicProgramResponse>> addSubjectToAcademicProgram(
			SubjectRequest subjectRequest, int programId);

}
