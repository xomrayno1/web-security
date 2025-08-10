package com.security.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class JWTBody {
	private String phone;
	private Long staffId;
	private String email;
	private List<Authority> authorities;
}
 