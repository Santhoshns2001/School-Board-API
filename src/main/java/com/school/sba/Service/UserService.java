package com.school.sba.service;

import org.springframework.http.ResponseEntity;


import com.school.sba.dto.UserRequest;
import com.school.sba.dto.UserResponce;
import com.school.sba.utility.ResponseStructure;


public interface UserService {

	ResponseEntity<ResponseStructure<UserResponce>> registerStudentAndTeacher(UserRequest user);

	ResponseEntity<ResponseStructure<UserResponce>> fethcById(int userId);

	ResponseEntity<ResponseStructure<UserResponce>> softdeleteById(int userId);

	ResponseEntity<ResponseStructure<UserResponce>> registerOnlyAdmin(UserRequest userRequest);



	

	

	

}
