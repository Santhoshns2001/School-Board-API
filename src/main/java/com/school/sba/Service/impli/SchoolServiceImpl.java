package com.school.sba.service.impli;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.school.sba.Enum.UserRole;
import com.school.sba.dto.SchoolRequest;
import com.school.sba.dto.SchoolResponse;
import com.school.sba.entity.School;
import com.school.sba.exception.AdminDuplicateException;
import com.school.sba.exception.AdminNotFoundException;
import com.school.sba.exception.SchoolNotFoundByIdException;
import com.school.sba.exception.UserNotFoundByIdException;
import com.school.sba.repositary.SchoolRepository;
import com.school.sba.repositary.UserRepoistary;
import com.school.sba.service.SchoolService;
import com.school.sba.utility.ResponseStructure;


@Service
public class SchoolServiceImpl implements SchoolService{

	@Autowired
	private SchoolRepository schoolRepository;

	@Autowired
	private UserRepoistary userRepo;

	@Override
	public ResponseEntity<ResponseStructure<School>> addSchool(School school) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		userRepo.findByUsername(name);
		School sch = schoolRepository.save(school);
		ResponseStructure<School> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Student Object Created Successfully");
		responseStructure.setData(sch);
		return new ResponseEntity<ResponseStructure<School>>(responseStructure,HttpStatus.CREATED);	
	}

	@Override
	public ResponseEntity<ResponseStructure<School>> findSchool(int schoolId) {
		Optional<School> optional = schoolRepository.findById(schoolId);
		if(optional.isPresent()) {
			School schl=optional.get();
			ResponseStructure<School> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Student Object Found Successfully");
			responseStructure.setData(schl);
			return new ResponseEntity<ResponseStructure<School>>(responseStructure,HttpStatus.FOUND);

		}else {
			throw new SchoolNotFoundByIdException("School Not Found!!!");
		}
	}
	@Override
	public ResponseEntity<ResponseStructure<School>> updateSchool(int schoolId, School updatedSchool) {
		Optional<School> optional = schoolRepository.findById(schoolId);
		if(optional.isPresent()) {
			School existinStudent = optional.get();
			updatedSchool.setSchoolId(existinStudent.getSchoolId());
			School schl = schoolRepository.save(updatedSchool);
			ResponseStructure<School> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("School Object Updated Successfully");
			responseStructure.setData(schl);

			return new ResponseEntity<ResponseStructure<School>>(responseStructure,HttpStatus.OK);	
		}else {
			throw new SchoolNotFoundByIdException("School Not Found!!!");
		}
	}
	@Override
	public ResponseEntity<ResponseStructure<School>> deleteSchool(int schoolId) {
		Optional<School> optional = schoolRepository.findById(schoolId);
		if(optional.isPresent()) {
			School schl = optional.get();
			schoolRepository.delete(schl);
			ResponseStructure<School> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("School Object deleted Successfully");
			responseStructure.setData(schl);
			return new ResponseEntity<ResponseStructure<School>>(responseStructure,HttpStatus.OK);
		}else {
			throw new SchoolNotFoundByIdException("School Not Found!!!");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<School>>> findAll(){
		List<School> sl = schoolRepository.findAll();
		if(sl.isEmpty()) {
			return null;
		}else {
			ResponseStructure<List<School>> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("School Objects Found Successfully");
			responseStructure.setData(sl);
			return new ResponseEntity<ResponseStructure<List<School>>>(responseStructure,HttpStatus.FOUND);
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<SchoolResponse>> adminCreateSchool( SchoolRequest schoolRequest) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		return userRepo.findByUsername(name).map( u  -> {
			if(u.getUserRole().equals(UserRole.ADMIN)) {
				if(u.getSchool()==null) {
					School school=mapToSchool(schoolRequest);
					school = schoolRepository.save(school);
					userRepo.save(u);
					ResponseStructure<SchoolResponse> responseStructure=new ResponseStructure<SchoolResponse>();
					responseStructure.setStatus(HttpStatus.CREATED.value());
					responseStructure.setMessage("school saved succussfully");
					responseStructure.setData(mapToSchoolResponse(school));
					return new ResponseEntity<ResponseStructure<SchoolResponse>>(responseStructure,HttpStatus.CREATED);
				}else
					throw new AdminDuplicateException("only one school can be created per admin");
			}else throw new AdminNotFoundException("only admin can create school");
		}).orElseThrow(() ->new UserNotFoundByIdException("failed to save school"));
	}

	private SchoolResponse mapToSchoolResponse(School school) {
		return SchoolResponse.builder()
				.schoolId(school.getSchoolId())
				.schoolName(school.getSchoolName())
				.schoolAddress(school.getSchoolAddress())
				.emailId(school.getEmailId())
				.contactNo(school.getContactNo())
				.build();
	}

	private School mapToSchool(SchoolRequest schoolRequest) {
		return School.builder()
				.schoolName(schoolRequest.getSchoolName())
				.schoolAddress(schoolRequest.getAddress())
				.contactNo(schoolRequest.getContactNo())
				.emailId(schoolRequest.getEmailId()).build();
	}


}
