package com.school.sba.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.sba.entity.User;

@Repository
public interface UserRepoistary extends JpaRepository<User, Integer>{

}
