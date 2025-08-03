package com.security.service.impl;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.config.security.JwtTokenProvider;
import com.security.entity.Staff;
import com.security.exception.ValidateException;
import com.security.model.APIStatus;
import com.security.model.RefreshTokenResponse;
import com.security.model.RegisterRequest;
import com.security.repository.StaffRepository;
import com.security.service.StaffService;
import com.security.utils.Commons;
import com.security.utils.ConstantManager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class StaffServiceImpl implements StaffService {

	private final StaffRepository staffRepository;
	private final PasswordEncoder encoder;
	private final JwtTokenProvider jwtTokenProvider;
 
 
	@Override
	public Staff findById(Long id) {
		return staffRepository.findById(id).orElse(null);
	}

	@Override
	public Staff findByPhone(String username) {
		return staffRepository.findByPhone(username)
				.orElseThrow(() -> new UsernameNotFoundException("Phone is invalid"));
	}
 
 
	@Override
	public RefreshTokenResponse refreshToken(String refreshToken) {
		if (!jwtTokenProvider.validateRefreshToken(refreshToken)) {
			throw new ValidateException(APIStatus.ERR_REFRESH_TOKEN_INVALID);
		}

		final String username = jwtTokenProvider.getUsernameFromRefreshJWT(refreshToken);
		
	 
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
		
		boolean isExists = staffRepository.existsByPhone(registerRequest.getPhone());
		if(isExists) {
			throw new ValidateException(APIStatus.ERR_USERNAME_EXISTS);
		}
		
		Staff staff = Staff.builder().phone(registerRequest.getPhone())
				.password(encoder.encode(registerRequest.getPassword()))
				.build();
		staff.setCreatedBy(registerRequest.getPhone());
		staffRepository.save(staff);
	}
 

}
