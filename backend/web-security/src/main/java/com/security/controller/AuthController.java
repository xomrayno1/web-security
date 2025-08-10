package com.security.controller;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.APIResponse;
import com.security.model.JwtLoginResponse;
import com.security.model.LoginRequest;
import com.security.model.RefreshTokenRequest;
import com.security.model.RefreshTokenResponse;
import com.security.model.RegisterRequest;
import com.security.service.AuthenticateService;
import com.security.utils.PathUtils;
import com.security.utils.ResponseUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * Login, Register, RefreshToken
 **/
@RestController
@RequestMapping(PathUtils.AUTH_API_V1)
@RequiredArgsConstructor
public class AuthController extends BaseController {
 
	private final AuthenticateService authenticateService;

	/**
	 * handle api login
	 * 
	 * @author tamnc
	 */
	@PostMapping(PathUtils.AUTH_LOGIN)
	public ResponseEntity<APIResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
		final JwtLoginResponse response = authenticateService.authenticate(loginRequest);
		return ResponseUtils.responseSuccess(response);
	}
	
	/**
	 * handle api login
	 * 
	 * @author tamnc
	 */
	@PostMapping(PathUtils.AUTH_REGISTER)
	public ResponseEntity<APIResponse> register(@RequestBody RegisterRequest registerRequest) {
		Long staffId = authenticateService.register(registerRequest);
		return ResponseUtils.responseSuccess(staffId);
	}
	
	/**
	 * handle api login
	 * 
	 * @author tamnc
	 */
	@PostMapping(PathUtils.AUTH_REFRESH_TOKEN)
	public ResponseEntity<APIResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
		final RefreshTokenResponse refreshTokenResponse = authenticateService.refreshToken(refreshTokenRequest.getRefreshToken());
		return ResponseUtils.responseSuccess(refreshTokenResponse);
	}
	
	/**
	 * chuyển từ password sang hash password
	 * 
	 * @author tamnc
	 */
	@GetMapping(PathUtils.AUTH_GENERATE_HASH_PASSWORD)
	public ResponseEntity<Object> generateHashPassword(@PathVariable("rawPassword") String rawPassword) {
		final Map<String, String> response = new HashedMap<>();
		response.put("hash_password", authenticateService.getPasswordEncoder(rawPassword));
		return ResponseEntity.ok(response);
	}
	
	/**
	 * check healthy api
	 * 
	 * @author tamnc
	 */
	@GetMapping(PathUtils.HEALTHY_API)
	public ResponseEntity<String> healthy() {
		return ResponseEntity.ok("UP");
	}
 
}
