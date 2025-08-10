package com.security.service;

import com.security.entity.Staff;

public interface StaffService{
	
	Staff findById(Long id);
	
	Staff findByPhone(String phone);
	 
}
