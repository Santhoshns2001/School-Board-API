package com.school.sba.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.sba.entity.Schedulde;
@Repository
public interface ScheduldeRepo extends JpaRepository<Schedulde, Integer>{

}
