package com.school.sba.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.sba.entity.ClassHour;
@Repository
public interface ClassHourRepo extends JpaRepository<ClassHour, Integer>{

}
