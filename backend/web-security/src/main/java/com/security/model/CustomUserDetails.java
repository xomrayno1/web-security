package com.security.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author tamnc
 *
 */
@Data
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
	private static final long serialVersionUID = 1725582319574029188L;

	private Users users;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		final Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("SUPPER_ADMIN"));
		return authorities;
	}

	@Override
	public String getPassword() {
		return users.getHashPassword();
	}

	@Override
	public String getUsername() {
		return users.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
