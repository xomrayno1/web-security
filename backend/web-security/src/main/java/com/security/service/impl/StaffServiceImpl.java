package com.security.service.impl;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.entity.Staff;
import com.security.repository.StaffRepository;
import com.security.service.StaffService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class StaffServiceImpl implements StaffService {

	private final StaffRepository staffRepository;
	
	
	@Override
	public Staff findById(Long id) {
		return staffRepository.findById(id).orElse(null);
	}

	@Override
	public Staff findByPhone(String username) {
		return staffRepository.findByPhone(username)
				.orElseThrow(() -> new UsernameNotFoundException("Phone is invalid"));
	}
	

}
