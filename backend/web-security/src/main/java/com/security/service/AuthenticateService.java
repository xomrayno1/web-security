package com.security.service;

import com.security.model.JwtLoginResponse;
import com.security.model.LoginRequest;

public interface AuthenticateService {
	JwtLoginResponse authenticate(LoginRequest loginRequest);
	
}
