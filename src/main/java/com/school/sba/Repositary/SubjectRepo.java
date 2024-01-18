package com.school.sba.repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.sba.entity.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Integer>{
	
	public Optional<Subject> findBySubjectName(String name);

}
