package com.security.service;

import com.security.model.JwtLoginResponse;
import com.security.model.LoginRequest;
import com.security.model.RefreshTokenResponse;
import com.security.model.RegisterRequest;

public interface AuthenticateService {
	JwtLoginResponse authenticate(LoginRequest loginRequest);
	
	String getPasswordEncoder(String rawPassword);
	
	RefreshTokenResponse refreshToken(String refreshToken);
	
	Long register(RegisterRequest registerRequest);
	
	JwtLoginResponse roleSwitch(Long staffId, Long roleId);
	
}
