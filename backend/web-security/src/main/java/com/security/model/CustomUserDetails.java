package com.security.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.entity.Staff;
import com.security.model.enums.Status;

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

	private final Staff staff;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.emptySet();
	}

	@Override
	public String getPassword() {
		return staff.getPassword();
	}

	@Override
	public String getUsername() {
		return staff.getPhone();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !(staff.getStatus() == Status.LOCKED);
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
