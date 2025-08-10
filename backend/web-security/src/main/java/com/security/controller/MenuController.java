package com.security.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.APIResponse;
import com.security.model.Authority;
import com.security.service.MenuService;
import com.security.utils.PathUtils;
import com.security.utils.ResponseUtils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(PathUtils.MENU_API_V1)
@RequiredArgsConstructor
public class MenuController {
	
	private final MenuService menuService;
	
	/**
	 * Trả về các menu của role hiện tại <br>
	 * 
	 * @author tamnc
	 */
	@GetMapping(PathUtils.MENU_GET_ALL)
	public ResponseEntity<APIResponse> formGetMenuByRoleId(HttpServletRequest request) {
		Long staffId = null;
		List<Authority> authorities = menuService.getAuthoritiesByStaffId(staffId);
		return ResponseUtils.responseSuccess(authorities);
	}

}
