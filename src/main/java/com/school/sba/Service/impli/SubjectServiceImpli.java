package com.school.sba.service.impli;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.sba.dto.AcademicProgramResponse;
import com.school.sba.dto.SubjectRequest;
import com.school.sba.dto.SubjectResponse;
import com.school.sba.entity.Subject;
import com.school.sba.exception.AcademicProgamNotFoundException;
import com.school.sba.repositary.AcademicProgramRepo;
import com.school.sba.repositary.SubjectRepo;
import com.school.sba.service.SubjectService;
import com.school.sba.utility.ResponseStructure;
@Service
public class SubjectServiceImpli implements SubjectService{

	@Autowired
	private AcademicProgramRepo academicRepo;

	@Autowired
	private SubjectRepo subjectRepo;

	@Autowired
	private ResponseStructure<AcademicProgramResponse> responseStructure;

	@Autowired
	private ResponseStructure<List<SubjectResponse>> structure;

	@Autowired
	private AcademicProgramServiceImple academicProgramServiceImpl;


	


	@Override
	public ResponseEntity<ResponseStructure<AcademicProgramResponse>> addSubject(int programId,
			SubjectRequest subjectRequest)
	{
		return academicRepo.findById(programId).map(program->{ //found academic program
			List<Subject>subjects= (program.getSubjects()!= null)?program.getSubjects(): new ArrayList<Subject>();

			//to add new subjects that are specified by the client
			subjectRequest.getSubjectNames().forEach(name->{
				boolean isPresent =false;
				for(Subject subject:subjects) {
					isPresent = (name.equalsIgnoreCase(subject.getSubjectNames()))?true:false;
					if(isPresent)break;
				}
				//				if(!isPresent)subjects.add(subjectRepo.findBySubjectNames(name)
				//						.orElseGet(()-> subjectRepo.save(Subject.builder().subjectNames(name).build())));

								 


			});
			//to remove the subjects that are not specified by the client
			List<Subject>toBeRemoved= new ArrayList<Subject>();
			subjects.forEach(subject->{
				boolean isPresent = false;
				for(String name:subjectRequest.getSubjectNames()) {
					isPresent=(subject.getSubjectNames().equalsIgnoreCase(name))?true :false;
					if(!isPresent)break;
				}
				if(!isPresent)toBeRemoved.add(subject);
			});
			subjects.removeAll(toBeRemoved);


			program.setSubjects(subjects);//set subjects list to the academic program
			academicRepo.save(program);//saving updated program to the database
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("updated the subject list to academic program");
			responseStructure.setData(AcademicProgramServiceImple.mapToResponse(program));
			return new ResponseEntity<ResponseStructure<AcademicProgramResponse>>(responseStructure,HttpStatus.CREATED);
		}).orElseThrow(()-> new AcademicProgamNotFoundException("AcademicProgram not found"));

	}

	@Override
	public ResponseEntity<ResponseStructure<List<SubjectResponse>>> findAllSubjects() 
	{
		List<Subject> findAll = subjectRepo.findAll();
		List<SubjectResponse> collect = findAll.stream()
				.map(u->mapToSubjectResponse(u))
				.collect(Collectors.toList());
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage(" sujects found successfully ");
		structure.setData(collect);
		return new ResponseEntity<ResponseStructure<List<SubjectResponse>>>(structure,HttpStatus.FOUND);
	}
	private SubjectResponse mapToSubjectResponse(Subject subject)
	{
		return SubjectResponse.builder()
				.subjectId(subject.getSubjectId())
				.subjectNames(subject.getSubjectNames())
				.build();

	}



}