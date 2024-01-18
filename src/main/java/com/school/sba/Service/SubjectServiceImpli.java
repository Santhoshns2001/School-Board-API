package com.school.sba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.school.sba.dto.AcademicProgramResponse;
import com.school.sba.dto.SubjectRequest;
import com.school.sba.entity.Subject;
import com.school.sba.repositary.AcademicProgramRepo;
import com.school.sba.repositary.SubjectRepo;
import com.school.sba.utility.ResponseStructure;

public class SubjectServiceImpli implements SubjectService{
	
	@Autowired
	private AcademicProgramRepo academicRepo;
	
	@Autowired
	private SubjectRepo subjectRepo;

	@Override
	public ResponseEntity<ResponseStructure<AcademicProgramResponse>> addSubjectToAcademicProgram(
			SubjectRequest subjectRequest, int programId) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public ResponseEntity<ResponseStructure<AcademicProgramResponse>> addSubjectToAcademicProgram(
//			SubjectRequest subjectRequest, int programId) {
		
//		return academicRepo.findById(programId).map(program ->{
//			List<Subject> subjects=new ArrayList<Subject>();
//			
//			subjectRequest.getSubjects().forEach(name ->{
//				subjectRepo.findBySubjectName(name)
//				})
//			});
//		});
//		
		
		
	//}

	
		
	

}
