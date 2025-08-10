package com.security.service.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.config.security.JwtTokenProvider;
import com.security.entity.Staff;
import com.security.exception.ValidateException;
import com.security.model.APIStatus;
import com.security.model.Authority;
import com.security.model.AuthorityLoginSpec;
import com.security.model.JWTBody;
import com.security.model.JwtLoginResponse;
import com.security.model.LoginRequest;
import com.security.model.RefreshTokenResponse;
import com.security.model.RegisterRequest;
import com.security.model.StaffInfoLogin;
import com.security.model.enums.FormType;
import com.security.repository.StaffRepository;
import com.security.repository.StaffRoleRepository;
import com.security.service.AuthenticateService;
import com.security.service.mapper.RawConvert;
import com.security.utils.Commons;
import com.security.utils.ConstantManager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticateServiceImpl extends BaseServiceImpl implements AuthenticateService{

	private final AuthenticationManager authenticationManager;
	
	private final StaffRepository staffRepository;

	private final StaffRoleRepository staffRoleRepository;
	
	private final JwtTokenProvider jwtTokenProvider;
	
	private final PasswordEncoder passwordEncoder;
	
	/**
	 * API login 
	 * @author tamnc
	 * **/
	@Override
	@Transactional(readOnly = true)
	public JwtLoginResponse authenticate(LoginRequest loginRequest) {
		Authentication authentication =  authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getPhone(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		final Staff staff = staffRepository.findByPhone(loginRequest.getPhone())
				.orElseThrow(() -> new ValidateException(APIStatus.ERR_USERNAME_IS_EXISTS));
		
		//load role and form menu and screen
		final List<Authority> authorities = this.getAuthoritiesByStaffIdAndRoleSelected(staff.getStaffId(), null);
		
		if (authorities.isEmpty()) {
			log.warn("[authenticate] Staff with ID {} has no authorities assigned.", staff.getStaffId());
		}else {
			log.info("[authenticate] Staff with ID {} has {} authorities assigned.", staff.getStaffId(), 
					authorities.stream().map(Authority::getRoleCode).collect(Collectors.joining(", ")));
		}
	  
		final String accessToken =  jwtTokenProvider.generateTokenWithBody(JWTBody.builder()
				.staffId(staff.getStaffId())
				.phone(staff.getPhone())
				.email(staff.getEmail())
				.authorities(authorities)
				.build());
		
		final String refreshToken = jwtTokenProvider.generateRefreshToken(staff.getPhone());
		
		return JwtLoginResponse.builder()
				.accessToken(accessToken)
				.refreshToken(refreshToken)
				.info(new StaffInfoLogin(staff.getStaffId(), staff.getPhone(), staff.getEmail()))
				.build();
	}
	
	
	/**
	 * Load menu cho admin <br>
	 * 
	 * @author tamnc
	 * **/
	private List<Authority> getAuthoritiesByStaffIdAndRoleSelected(Long staffId, Long roleId){
		List<AuthorityLoginSpec> authoritiesRepo = null;
		if(roleId == null) {
			authoritiesRepo = staffRoleRepository.findAuthorityLoginSpecsByStaffIdAndRoleIsDefaultAndFormType(staffId, FormType.FORM.name());
		}else {
			authoritiesRepo = staffRoleRepository.findAuthorityLoginSpecsByStaffIdAndRoleIdAndFormType(staffId, roleId, FormType.FORM.name());
		}
		
		if(authoritiesRepo.isEmpty()) {
			log.warn("[getAuthoritiesByStaffId] Staff with ID {} has no authorities assigned.", staffId);
			return Collections.emptyList();
		}
		
		//load control map from authoritiesRepo
		Map<Long, Set<Authority.RoleControl>> controlMap = this.extractControlMap(authoritiesRepo);
		
		// Group authorities by roleId
		Map<Long, List<AuthorityLoginSpec>> authorityMap = authoritiesRepo.stream()
								.collect(Collectors.groupingBy(AuthorityLoginSpec::getRoleId));
		
		return authorityMap.entrySet().stream().map(element -> {
			//convert to Authority.FormInfo
			List<Authority.FormInfo> formByRoles = element.getValue().stream()
					.map(RawConvert::toAuthorityFormInfo)
					.toList();
	
			Set<Authority.FormInfo> formCharts = new HashSet<>();
			for(Authority.FormInfo rootForm: formByRoles) {
				//get child forms
				rootForm.setControls(controlMap.getOrDefault(rootForm.getFormId(), Collections.emptySet()));
				formCharts.add(rootForm);
			}
			
			//set mapping role
			AuthorityLoginSpec firstAuthority = element.getValue().stream().findFirst().orElse(null);
			Authority authority = new Authority();
			authority.setRoleId(firstAuthority.getRoleId());
			authority.setRoleCode(firstAuthority.getRoleCode());
			authority.setRoleName(firstAuthority.getRoleName());
			authority.setIsDefault(firstAuthority.getIsDefault());
			authority.setForms(formCharts);
			return authority;
		}).toList();
	}
 
	
	@Override
	public String getPasswordEncoder(String rawPassword) {
		return passwordEncoder.encode(rawPassword);
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
		
		return new RefreshTokenResponse(accessToken, newRefreshToken);
	}

	@Override
	public Long register(RegisterRequest registerRequest) {
		boolean isExists = staffRepository.existsByPhone(registerRequest.getPhone());
		if(isExists) {
			throw new ValidateException(APIStatus.ERR_USERNAME_EXISTS);
		}
		
		Staff staff = Staff.builder()
				.phone(registerRequest.getPhone())
				.email(registerRequest.getEmail())
				.password(passwordEncoder.encode(registerRequest.getPassword()))
				.build();
		staff.setCreatedBy(registerRequest.getPhone());
		staffRepository.save(staff);
		return staff.getStaffId();
	}


	@Override
	public JwtLoginResponse roleSwitch(Long staffId, Long roleId) {
		final List<Authority> authorities = this.getAuthoritiesByStaffIdAndRoleSelected(staffId, roleId);
		  
		final String accessToken =  jwtTokenProvider.generateTokenWithBody(JWTBody.builder()
				.authorities(authorities)
				.build());
		
		return JwtLoginResponse.builder()
				.accessToken(accessToken)
				.build();
	}

}
