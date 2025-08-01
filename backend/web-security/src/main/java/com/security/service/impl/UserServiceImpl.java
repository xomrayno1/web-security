package com.security.service.impl;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.config.security.JwtTokenProvider;
import com.security.entity.Users;
import com.security.exception.ValidateException;
import com.security.model.APIStatus;
import com.security.model.RefreshTokenResponse;
import com.security.model.RegisterRequest;
import com.security.model.enums.UserType;
import com.security.repository.UsersRepository;
import com.security.service.UsersService;
import com.security.utils.Commons;
import com.security.utils.ConstantManager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UsersService {

	private final UsersRepository usersRepository;
	private final PasswordEncoder encoder;
	private final JwtTokenProvider jwtTokenProvider;
 
 
	@Override
	public Users findById(Long id) {
		return usersRepository.findById(id).orElse(null);
	}

	@Override
	public Users findByUsername(String username) {
		return usersRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username is invalid"));
	}
 
 
	@Override
	public RefreshTokenResponse refreshToken(String refreshToken) {
		if (!jwtTokenProvider.validateRefreshToken(refreshToken)) {
			throw new ValidateException(APIStatus.ERR_REFRESH_TOKEN_INVALID);
		}

		final String username = jwtTokenProvider.getUsernameFromRefreshJWT(refreshToken);
		
		final Users users = findByUsername(username);

		final String key = Commons.createRedisKey(ConstantManager.REFRESH_TOKEN_KEY, username);
		
	 
		
		final String newRefreshToken = jwtTokenProvider.generateRefreshToken(username);
	 
		String accessToken = jwtTokenProvider.generateToken(username);
		
//		userToken = UserToken.builder()
//							.accessToken(accessToken)
//							.acessTokenTokenExpire(LocalDateTime.now().plusSeconds(jwtTokenProvider.getAccessTokenExpire()))
//							.oldRefreshToken(refreshToken)
//							.refreshToken(newRefreshToken)
//							.refreshTokenExpire(LocalDateTime.now().plusSeconds(jwtTokenProvider.getRefreshTokenExpire()))
//							.actionType(ActionType.REFRESH_TOKEN)
//							.userId(users.getId())
//							.actionDateTime(LocalDateTime.now())
//							.build();
//		userTokenRepository.save(userToken);
		
		return new RefreshTokenResponse(accessToken, newRefreshToken);
	}

  
	 

	@Override
	public void createUserCustomer(RegisterRequest registerRequest) {
		
		boolean isExists = usersRepository.existsByUsername(registerRequest.getUsername());
		if(isExists) {
			throw new ValidateException(APIStatus.ERR_USERNAME_EXISTS);
		}
		
		Users users = Users.builder().username(registerRequest.getUsername())
				.hashPassword(encoder.encode(registerRequest.getPassword()))
				.userType(UserType.STAFF)
				.build();
		users.setCreatedBy(registerRequest.getUsername());
		usersRepository.save(users);
	 
		
	}
 

}
