package com.school.sba.dto;


import com.school.sba.Enum.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

	@NotNull(message = "username should not be null")
	@Pattern(regexp = "^[A-Z][a-zA-Z ]*$",message = "must be upper camel case and numbers are not allowed")
	
	private String  username; 
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must"
			+ " contain at least one letter, one number, one special character")
	private String password;
	
	@Pattern(regexp = "^[A-Z][a-zA-Z ]*$",message = "must be upper camel case and numbers are not allowed")
	private String userFirstName;
	
	@Pattern(regexp = "^[A-Z][a-zA-Z ]*$",message = "must be upper camel case and numbers are not allowed")
	private String userLastName;
	
	@Min(value = 10)
	@Max(value = 10)
	private long userContNo;
	
	@Email(regexp = "[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}", message = "invalid email ")
	private String userEmail;
	private UserRole userRole;
}
