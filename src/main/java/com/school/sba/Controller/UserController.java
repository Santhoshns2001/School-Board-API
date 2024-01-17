package com.school.sba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.sba.dto.SchoolRequest;
import com.school.sba.dto.UserRequest;
import com.school.sba.dto.UserResponce;
import com.school.sba.entity.School;
import com.school.sba.service.UserService;
import com.school.sba.utility.ResponseStructure;

import jakarta.validation.Valid;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<UserResponce>> saveUser(@RequestBody @Valid UserRequest user){
		return  userService.saveUser(user);
	} 
	
	@GetMapping ("/users/{userId}")
	public  ResponseEntity<ResponseStructure<UserResponce>> fetchById(@PathVariable int userId){
		return userService.fethcById(userId);
	}
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<ResponseStructure<UserResponce>> softdeleteById (@PathVariable int userId){
		return userService.softdeleteById(userId);
	}
	
	
	
	

}
