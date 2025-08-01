package com.security.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
	
	@NotBlank(message = "email is required")
	private String email;
	
	@NotBlank(message = "username is required")
	private String username;
	 
	@NotBlank(message = "password is required")
	private String password;

}
