package com.school.sba.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.sba.entity.AcademicProgram;

@Repository
public interface AcademicProgramRepo extends JpaRepository<AcademicProgram, Integer>{
	
	

}
