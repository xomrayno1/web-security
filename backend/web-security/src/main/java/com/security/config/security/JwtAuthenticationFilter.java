package com.security.config.security;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.security.model.JWTBody;
import com.security.model.security.PlainAuthentication;
import com.security.utils.ConstantManager;
import com.security.utils.StringUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtTokenProvider tokenProvider;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info("[JwtAuthenticationFilter] - request URI: {}", request.getRequestURI());
		
		final String bearerToken = request.getHeader(ConstantManager.AUTHORIZATION);
		if(StringUtils.isNullOrEmpty(bearerToken) || !isTokenValid(bearerToken)) {
			filterChain.doFilter(request, response);
			log.error("[JwtAuthenticationFilter] - JWT Token is missing or invalid - request URI: {}", request.getRequestURI());
			return;
		}
		
		try {
			String token = bearerToken.substring(7);
			if (tokenProvider.validateToken(token)) {
				final JWTBody jwtBody = tokenProvider.extractJWTBodyFromJWT(token);
				if (jwtBody != null) {
					final PlainAuthentication authentication = new PlainAuthentication(jwtBody.getPhone(), jwtBody.getEmail(), jwtBody.getAuthorities());
					authentication.setAuthenticated(true);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}

		} catch (Exception e) {
			log.error("failed on set user authentication", e);
		}
		filterChain.doFilter(request, response);
	}

	private boolean isTokenValid(String bearerToken) {
		if (bearerToken.startsWith("Bearer ")) {
			return true;
		} 
		logger.warn("JWT Token does not begin with Bearer String");
		return false;
	}

}
