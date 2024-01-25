package com.school.sba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.sba.Enum.UserRole;
import com.school.sba.dto.UserRequest;
import com.school.sba.dto.UserResponce;
import com.school.sba.service.UserService;
import com.school.sba.utility.ResponseStructure;

import jakarta.validation.Valid;
 
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users/register")
	public ResponseEntity<ResponseStructure<UserResponce>> registerOnlyAdmin(@RequestBody UserRequest userRequest){
		return  userService.registerOnlyAdmin(userRequest);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<UserResponce>> registerStudentAndTeacher(@RequestBody @Valid UserRequest user){
		return  userService.registerStudentAndTeacher(user);
	} 
	
	
	@GetMapping ("/users/{userId}")
	public  ResponseEntity<ResponseStructure<UserResponce>> fetchById(@PathVariable int userId){
		return userService.fethcById(userId);
	}
	
	@PreAuthorize("hasAuthority(ADMIN)")
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<ResponseStructure<UserResponce>> softdeleteById (@PathVariable int userId){
		return userService.softdeleteById(userId);
	}
	
	
	
	

}
