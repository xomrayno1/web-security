package com.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.APIResponse;
import com.security.utils.PathUtils;
import com.security.utils.ResponseUtils;

@RestController
@RequestMapping(PathUtils.STAFF_API_V1)
public class StaffManagementController extends BaseController{
 
	/**
	 * lấy chi tiết nhân viên <br>
	 * 
	 * @author tamnc
	 */
	@PreAuthorize("@AuthorizeService.hasAnyControl('STAFF_MANAGEMENT')")
	@GetMapping(PathUtils.STAFF_GET_BY_ID)
	public ResponseEntity<APIResponse> staffById() {
		return ResponseUtils.responseSuccess(PathUtils.STAFF_GET_BY_ID);
	}
	
	@PreAuthorize("@AuthorizeService.hasAnyForm('STAFF_MANAGEMENT')")
	@PostMapping(PathUtils.STAFF_LIST)
	public ResponseEntity<APIResponse> stafList() {
		return ResponseUtils.responseSuccess(PathUtils.STAFF_LIST);
	}

}
