package com.security.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.security.utils.PathUtils;

import lombok.RequiredArgsConstructor;

/**
 * web security config
 * @author tamnc
 */
@EnableMethodSecurity
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfiguration {
	 
	private final JwtAuthenticationFilter jwtWebRequestFilter;
	
	private final LogoutHandler logoutHandler;

	
	private static final String[] WHITE_LIST_URL = { 
			PathUtils.AUTH_API_V1 +"/**", 
			"/unsecured/v1/unsecure-example", 
			"/api/v1/health/**",
	};
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().and()
		.authorizeHttpRequests(authorize -> 
			authorize
			.requestMatchers(WHITE_LIST_URL).permitAll()
			.anyRequest().authenticated()
			)
		.addFilterBefore(jwtWebRequestFilter, UsernamePasswordAuthenticationFilter.class)
		.logout(logout -> logout.logoutUrl("/api/v1/auth/logout")
	        	.addLogoutHandler(logoutHandler)
	        	.logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
		)
		.exceptionHandling(customizer -> customizer.accessDeniedHandler(accessDeniedHandler()));
		return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return webSecurity -> webSecurity.ignoring().requestMatchers("/actuator/**");
	}

	@Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }


}
