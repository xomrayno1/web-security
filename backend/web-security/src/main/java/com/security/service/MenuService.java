package com.security.service;

import java.util.List;

import com.security.model.Authority;

public interface MenuService {
	
	List<Authority> getAuthoritiesByStaffId(Long staffId);

}
