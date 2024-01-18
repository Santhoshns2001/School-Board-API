package com.school.sba.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.sba.dto.ScheduldeRequest;
import com.school.sba.dto.ScheduldeResponse;
import com.school.sba.entity.Schedulde;
import com.school.sba.entity.School;
import com.school.sba.repositary.ScheduldeRepo;
import com.school.sba.repositary.SchoolRepository;
import com.school.sba.utility.ResponseStructure;
@Service
public class ScheduldeServiceImpli implements ScheduldeService{

	@Autowired
	private ScheduldeRepo scheduldeRepo;

	@Autowired
	private ResponseStructure<ScheduldeResponse> responseStructure;

	@Autowired
	private SchoolRepository schoolRepo;
	
	@Override
	public ResponseEntity<ResponseStructure<ScheduldeResponse>> updateScheduleById(int scheduleldId,
			ScheduldeRequest scheduleldRequest) {
		return scheduldeRepo.findById(scheduleldId).map(scheduleld->{
			scheduldeRepo.save(mapToUpdate(scheduleldId, scheduleld.getSchool(), scheduleldRequest));
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Scheduleld Updated successfully!!!!");
			responseStructure.setData(mapToResponse(scheduleld));
			return new ResponseEntity<ResponseStructure<ScheduldeResponse>>(responseStructure, HttpStatus.CREATED);
		}).orElseThrow(()->new IllegalArgumentException("Scheduleld Does Not Exist!!!"));
	}
	
	

	@Override
	public ResponseEntity<ResponseStructure<ScheduldeResponse>> findScheduleBySchoolId(int schoolId) {
		return schoolRepo.findById(schoolId).map(school->{
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Scheduleld Fetched successfully!!!!");
		responseStructure.setData(mapToResponse(school.getScheduldeId()));
		return new ResponseEntity<ResponseStructure<ScheduldeResponse>>(responseStructure, HttpStatus.FOUND);
		}).orElseThrow(()->new IllegalArgumentException("School Does Not Exist!!!"));
	}

	@Override
	public ResponseEntity<ResponseStructure<ScheduldeResponse>> adminCreatesSchedulde(int schoolId,
			ScheduldeRequest scheduldeRequest) {
		return schoolRepo.findById(schoolId).map(school ->{
			if(school.getScheduldeId()==null) {
				Schedulde schedulde=scheduldeRepo.save(mapToSchedulde(school,scheduldeRequest));
				school.setScheduldeId(schedulde);
				schoolRepo.save(school);
				responseStructure.setStatus(HttpStatus.CREATED.value());
				responseStructure.setMessage("schedulde succussfully created");
				responseStructure.setData(mapToResponse(schedulde));
				return new ResponseEntity<ResponseStructure<ScheduldeResponse>>(responseStructure,HttpStatus.CREATED);
				
			}else throw new com.school.sba.exception.IllegalArgumentException("school schdulde id already exists");
		}).orElseThrow(() ->new com.school.sba.exception.IllegalArgumentException("school does not exist"));
		
		

	}

	private ScheduldeResponse mapToResponse(Schedulde schedulde) {
	return ScheduldeResponse.builder()
			.scheduldeId(schedulde.getScheduldeId())
			.classHoursLengthInMin((int)schedulde.getClassHoursLengthInMin().toMinutesPart())
			.classHoursPerDay(schedulde.getClassHoursPerDay())
			.breakTime(schedulde.getBreakTime())
			.opensAt(schedulde.getOpensAt())
			.closesAt(schedulde.getClosesAt())
			.launchTime(schedulde.getLaunchTime())
			.breakLengthInMin((int)schedulde.getBreakLengthInMin().toMinutes())
			.lunchLengthInMin((int)schedulde.getLunchLengthInMin().toMinutes())
			.build();
		
	}

	private Schedulde mapToSchedulde(School school, ScheduldeRequest scheduldeRequest) {
		
		return Schedulde.builder()
				.breakLengthInMin(Duration.ofMinutes(scheduldeRequest.getBreakLengthInMin()))
				.breakTime(scheduldeRequest.getBreakTime())
				.classHoursLengthInMin(Duration.ofMinutes(scheduldeRequest.getClassHoursLengthInMin()))
				.classHoursPerDay(scheduldeRequest.getClassHoursPerDay())
				.closesAt(scheduldeRequest.getClosesAt())
				.opensAt(scheduldeRequest.getOpensAt())
				.launchTime(scheduldeRequest.getLaunchTime())
				.lunchLengthInMin(Duration.ofMinutes(scheduldeRequest.getLunchLengthInMin()))
				.school(school)
				.build();
				
	}
	
	private Schedulde mapToUpdate(int scheduleldId, School school, ScheduldeRequest scheduleldRequest) {
		return Schedulde.builder()
				.scheduldeId(scheduleldId)
				.breakLengthInMin(Duration.ofMinutes(scheduleldRequest.getBreakLengthInMin()))
				.breakTime(scheduleldRequest.getBreakTime())
				.classHoursLengthInMin(Duration.ofMinutes(scheduleldRequest.getClassHoursLengthInMin()))
				.classHoursPerDay(scheduleldRequest.getClassHoursPerDay())
				.closesAt(scheduleldRequest.getClosesAt())
				.opensAt(scheduleldRequest.getOpensAt())
				.lunchLengthInMin(Duration.ofMinutes(scheduleldRequest.getLunchLengthInMin()))
				.launchTime(scheduleldRequest.getLaunchTime())
				.school(school)
				.build();
	}

	

}
