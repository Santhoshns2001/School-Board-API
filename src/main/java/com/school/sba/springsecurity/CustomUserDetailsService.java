package com.school.sba.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.school.sba.entity.User;
import com.school.sba.repositary.UserRepoistary;
@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepoistary userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 User user = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user name not found in the database"));
		 return new CustomUserDetails(user);
		 
		
	}

}
