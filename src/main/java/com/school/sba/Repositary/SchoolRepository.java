package com.school.sba.Repositary;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.school.sba.Entity.School;



@Repository
public interface SchoolRepository extends JpaRepository<School , Integer> {
	

}
