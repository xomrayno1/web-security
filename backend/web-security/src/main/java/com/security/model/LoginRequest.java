package com.security.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author tamnc
 *
 */
@Data
public class LoginRequest {
	@NotBlank(message = "username is required")
	private String username;
	 
	@NotBlank(message = "password is required")
	private String password;

}
