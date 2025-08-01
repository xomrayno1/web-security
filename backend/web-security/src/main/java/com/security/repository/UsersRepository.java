package com.security.repository;

import java.util.Optional;

import com.security.entity.Users;

public interface UsersRepository extends BaseRepository<Users>{
	
	Optional<Users> findByUsername(String username);
	
	boolean existsByUsername(String username);

}
