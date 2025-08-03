package com.security.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tamnc
 *
 */

@Setter
@Getter
@Builder
public class JwtLoginResponse {
	private String accessToken;
	private String refreshToken;
	private Long staffId;
	private List<String> authorities;

}
