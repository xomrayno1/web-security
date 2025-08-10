package com.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.APIResponse;
import com.security.model.JwtLoginResponse;
import com.security.service.AuthenticateService;
import com.security.utils.PathUtils;
import com.security.utils.ResponseUtils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(PathUtils.ROLE_API_V1)
@RequiredArgsConstructor
public class RoleController {
	
	private final AuthenticateService authenticateService;
	
	/**
	 * chuyển đổi giữa các role <br>
	 * Khi switch giữa các role sẽ tiến hành trả lại token cho role mới <br>
	 * @param roleId id của role muốn chuyển đổi <br>
	 * @author tamnc
	 */
	@GetMapping(PathUtils.ROLE_SWITCH)
	public ResponseEntity<APIResponse> roleSwitch(HttpServletRequest request, @PathVariable("roleId") Long roleId) {
		Long staffId = null; //get from token
		JwtLoginResponse response = authenticateService.roleSwitch(roleId, staffId);
		return ResponseUtils.responseSuccess(response);
	}

}
