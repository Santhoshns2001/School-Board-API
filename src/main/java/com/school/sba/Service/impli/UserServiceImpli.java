package com.school.sba.service.impli;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.school.sba.Enum.UserRole;
import com.school.sba.dto.UserRequest;
import com.school.sba.dto.UserResponce;
import com.school.sba.entity.User;
import com.school.sba.exception.AdminNotAllowedException;
import com.school.sba.exception.OnlyAdminAreAllowedException;
import com.school.sba.exception.OnlyOneAdminIsPossibleException;
import com.school.sba.exception.UserNotFoundByIdException;
import com.school.sba.repositary.UserRepoistary;
import com.school.sba.service.UserService;
import com.school.sba.utility.ResponseStructure;

@Service
public class UserServiceImpli implements UserService {

	@Autowired
	private UserRepoistary userRepo;

	@Autowired
	PasswordEncoder encoder;

	@Override
	public ResponseEntity<ResponseStructure<UserResponce>> registerOnlyAdmin(UserRequest userRequest) {
		List<User> findAll = userRepo.findAll();
		for(User user: findAll) {
			if(user.getUserRole().equals(UserRole.ADMIN))
				throw new OnlyOneAdminIsPossibleException("only one admin can be present");
		}
		if(userRequest.getUserRole().equals(UserRole.ADMIN)) {
			User save = userRepo.save(mapToUser(userRequest));
			ResponseStructure<UserResponce> responceStructure=new ResponseStructure<UserResponce>();
			responceStructure.setStatus(HttpStatus.CREATED.value());
			responceStructure.setMessage("user data saved succussfully");
			responceStructure.setData(mapToResponce(save));
			return new  ResponseEntity<ResponseStructure<UserResponce>>(responceStructure,HttpStatus.CREATED);
		}
		else
			throw new OnlyAdminAreAllowedException("only admins are allowed");
	}

	@Override
	public ResponseEntity<ResponseStructure<UserResponce>> registerStudentAndTeacher(UserRequest requestUser) {
		
		

		if(requestUser.getUserRole().equals(UserRole.ADMIN))
			throw new AdminNotAllowedException("only teachers and students are allowed");
		else {
			User user=userRepo.save(mapToUser(requestUser));
			ResponseStructure<UserResponce> responceStructure=new ResponseStructure<UserResponce>();
			responceStructure.setStatus(HttpStatus.CREATED.value());
			responceStructure.setMessage("user data saved succussfully");
			responceStructure.setData(mapToResponce(user));
			return new  ResponseEntity<ResponseStructure<UserResponce>>(responceStructure,HttpStatus.CREATED);
		}
	}



	@Override
	public ResponseEntity<ResponseStructure<UserResponce>> fethcById(int userId) {
		User user = userRepo.findById(userId).orElseThrow( ()-> new UserNotFoundByIdException("User not exist "));

		ResponseStructure<UserResponce> responceStructure=new ResponseStructure<UserResponce>();
		responceStructure.setStatus(HttpStatus.FOUND.value());
		responceStructure.setMessage("user found succussfully");
		responceStructure.setData(mapToResponce(user));

		return new ResponseEntity<ResponseStructure<UserResponce>>(responceStructure,HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<UserResponce>> softdeleteById(int userId) {

		User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundByIdException("user not fund by the id provided"));
		if(user.isDeleted()==true) {
			throw new UserNotFoundByIdException("user not found by the id it is alredy deleted");
		}
		else {
			user.setDeleted(true);
			userRepo.save(user);
			ResponseStructure<UserResponce> responceStructure=new ResponseStructure<UserResponce>();
			responceStructure.setStatus(HttpStatus.OK.value());
			responceStructure.setMessage("user id deleted succussfullt");
			responceStructure.setData(mapToResponce(user));
			return new ResponseEntity<ResponseStructure<UserResponce>>(responceStructure,HttpStatus.OK);

		}

	}

	private UserResponce mapToResponce(User responceUser) {
		return UserResponce.builder()
				.userId(responceUser.getUserId())
				.username(responceUser.getUsername())
				.userFirstName(responceUser.getUserFirstName())
				.userLastName(responceUser.getUserLastName())
				.userEmail(responceUser.getUseremail())
				.userContNo(responceUser.getUsercontNo())
				.userRole(responceUser.getUserRole())
				.build();
	}

	private User mapToUser(UserRequest requestUser) {
		return User.builder()
				.username(requestUser.getUsername())
				.userFirstName(requestUser.getUserFirstName())
				.userLastName(requestUser.getUserLastName())
				.useremail(requestUser.getUserEmail())
				.userPassword(encoder.encode(requestUser.getPassword()))
				.usercontNo(requestUser.getUserContNo())
				.userRole(requestUser.getUserRole())
				.build();

	}













}
