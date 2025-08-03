package com.security.service;

import com.security.entity.Staff;
import com.security.model.RefreshTokenResponse;
import com.security.model.RegisterRequest;

public interface StaffService{
	
	Staff findById(Long id);
	
	Staff findByPhone(String phone);
	
	RefreshTokenResponse refreshToken(String refreshToken);

	public void createUserCustomer(RegisterRequest registerRequest);
	 
}
