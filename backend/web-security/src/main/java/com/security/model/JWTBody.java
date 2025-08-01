package com.security.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class JWTBody {
	private String username;
	private Long userId;
	private Long staffId;
	private List<String> authorities;

}
