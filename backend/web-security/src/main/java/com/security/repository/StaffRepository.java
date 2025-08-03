package com.security.repository;

import java.util.Optional;

import com.security.entity.Staff;

public interface StaffRepository extends BaseRepository<Staff>{
	
	Optional<Staff> findByPhone(String phone);
	
	boolean existsByPhone(String phone);

}
