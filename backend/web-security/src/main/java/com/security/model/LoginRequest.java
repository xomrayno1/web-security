package com.security.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author tamnc
 *
 */
@Data
public class LoginRequest {
	@NotBlank(message = "phone is required")
	private String phone;
	 
	@NotBlank(message = "password is required")
	private String password;

}
