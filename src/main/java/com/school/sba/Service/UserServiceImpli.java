package com.school.sba.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.sba.dto.SchoolRequest;
import com.school.sba.dto.UserRequest;
import com.school.sba.dto.UserResponce;
import com.school.sba.entity.User;
import com.school.sba.exception.AdminNotFoundException;
import com.school.sba.exception.UserNotFoundByIdException;
import com.school.sba.exception.UserNotFoundByIdException;
import com.school.sba.repositary.UserRepoistary;
import com.school.sba.utility.ResponseStructure;

@Service
public class UserServiceImpli implements UserService {

	@Autowired
	private UserRepoistary userRepo;

	@Override
	public ResponseEntity<ResponseStructure<UserResponce>> saveUser(UserRequest requestUser) {

		List<User> findAll=new ArrayList<User>();

		/**findAll.forEach(us ->{
			us.getUserRole()
			.compareTo(UserRole.ADMIN);}); **/


		for(User u:findAll) {
			if(u.getUserRole().toString()=="ADMIN")
				throw new AdminNotFoundException("Admin already exist");
		}
		User user=userRepo.save(mapToUser(requestUser));
		ResponseStructure<UserResponce> responceStructure=new ResponseStructure<UserResponce>();
		responceStructure.setStatus(HttpStatus.CREATED.value());
		responceStructure.setMessage("user data saved succussfully");
		responceStructure.setData(mapToResponce(user));
		return new  ResponseEntity<ResponseStructure<UserResponce>>(responceStructure,HttpStatus.CREATED);

	}

	private UserResponce mapToResponce(User responceUser) {
		return UserResponce.builder().userId(responceUser.getUserId())
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
				.userPassword(requestUser.getUserPassword())
				.usercontNo(requestUser.getUserContNo())
				.userRole(requestUser.getUserRole())
				.build();

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

	







}
