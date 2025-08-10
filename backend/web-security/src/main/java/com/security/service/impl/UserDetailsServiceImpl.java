package com.security.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.entity.Staff;
import com.security.model.CustomUserDetails;
import com.security.repository.StaffRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final StaffRepository staffRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final Staff staff = staffRepository.findByPhone(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));
		return new CustomUserDetails(staff);
	}

}
