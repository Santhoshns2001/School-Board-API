package com.school.sba.repositary;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.sba.entity.School;



@Repository
public interface SchoolRepository extends JpaRepository<School , Integer> {
	

}
