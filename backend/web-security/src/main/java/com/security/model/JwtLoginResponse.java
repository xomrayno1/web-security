package com.security.model;

import com.fasterxml.jackson.annotation.JsonInclude;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JwtLoginResponse {
	private String accessToken;
	private String refreshToken;
	private StaffInfoLogin info;
}

 