package com.security.service.impl;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.security.config.security.JwtTokenProvider;
import com.security.entity.Users;
import com.security.exception.ValidateException;
import com.security.model.APIStatus;
import com.security.model.JWTBody;
import com.security.model.JwtLoginResponse;
import com.security.model.LoginRequest;
import com.security.repository.UsersRepository;
import com.security.service.AuthenticateService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticateServiceImpl implements AuthenticateService{

	private final AuthenticationManager authenticationManager;
	
	private final UsersRepository usersRepository;
	
	private final JwtTokenProvider jwtTokenProvider;
	
	@Override
	public JwtLoginResponse authenticate(LoginRequest loginRequest) {
		Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		Users users = usersRepository.findByUsername(loginRequest.getUsername())
				.orElseThrow(() -> new ValidateException(APIStatus.ERR_USERNAME_IS_EXISTS));
		
		
		List<String> authorities = authentication.getAuthorities().stream().toList().stream()
				.map(item -> item.getAuthority())
				.toList();
		
		String accessToken =  jwtTokenProvider.generateTokenWithBody(JWTBody.builder()
				.userId(users.getId())
				.username(users.getUsername())
				.authorities(authorities)
				.build());
		String refreshToken = jwtTokenProvider.generateRefreshToken(users.getUsername());

		return JwtLoginResponse.builder()
				.accessToken(accessToken)
				.refreshToken(refreshToken)
				.authorities(authorities)
				.userId(users.getId())
				.build();
	}

}
