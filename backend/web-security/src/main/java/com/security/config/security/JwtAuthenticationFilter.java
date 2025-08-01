package com.security.config.security;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.security.model.JWTBody;
import com.security.utils.ConstantManager;
import com.security.utils.StringUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtTokenProvider tokenProvider;


	private static final Logger log = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String bearerToken = request.getHeader(ConstantManager.AUTHORIZATION);
		
		if(StringUtils.isNullOrEmpty(bearerToken) || !isTokenValid(bearerToken)) {
			filterChain.doFilter(request, response);
			return;
		}
		try {
			String token = bearerToken.substring(7);
			if (tokenProvider.validateToken(token)) {
				final JWTBody jwtBody = tokenProvider.extractJWTBodyFromJWT(token);
				if (jwtBody != null) {
					List<SimpleGrantedAuthority> authorities = jwtBody.getAuthorities()
							.stream().map(SimpleGrantedAuthority::new).toList();
					final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							jwtBody.getUsername(), null, authorities);
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
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
