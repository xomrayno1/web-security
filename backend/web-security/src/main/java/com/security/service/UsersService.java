package com.security.service;

import com.security.entity.Users;
import com.security.model.RefreshTokenResponse;
import com.security.model.RegisterRequest;

public interface UsersService{
	
	Users findById(Long id);
	
	Users findByUsername(String name);
	
	RefreshTokenResponse refreshToken(String refreshToken);

	public void createUserCustomer(RegisterRequest registerRequest);
	 
}
