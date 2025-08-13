package com.security.config.security;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.security.model.Authority;
import com.security.model.JWTBody;
import com.security.utils.JsonUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tamnc
 *
 */
@Component
@Slf4j
public class JwtTokenProvider {
	
	@Value("${jwt.access.secret}")
	private String JWT_SECRET;
	
	@Value("${jwt.access.expiration}")  
	private String JWT_EXPIRATION;
	
	@Value("${jwt.refresh.secret}")
	private String JWT_REFRESH_SECRET;
	
	@Value("${jwt.refresh.expiration}")  
	private String JWT_REFRESH_EXPIRATION;
   
	public String generateToken(String username) {
		final Date now = new Date();
		final Date expiryDate = new Date(now.getTime() + Long.parseLong(JWT_EXPIRATION));
		 
	    return Jwts.builder()
	    		.setSubject(username)
	    		.setIssuedAt(now)
	            .setExpiration(expiryDate)
	            .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
	            .compact();
	}
	
	/**
	 * Generate token with JWTBody
	 * 
	 * @param jwtBody
	 * @return
	 */
	public String generateTokenWithBody(JWTBody jwtBody ) {
		final Date now = new Date();
		final Date expiryDate = new Date(now.getTime() + Long.parseLong(JWT_EXPIRATION));
		 
	    return Jwts.builder()
	    		.setSubject(jwtBody.getPhone())
	    		.claim("email", jwtBody.getEmail())
	    		.claim("authorities", jwtBody.getAuthorities())
	    		.claim("staffId", jwtBody.getStaffId())
	    		.claim("phone", jwtBody.getPhone())
	    		.setIssuedAt(now)
	            .setExpiration(expiryDate)
	            .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
	            .compact();
	}
	
	/**
	 * Generate refresh token
	 **/
	public String generateRefreshToken(String username) {
		final Date now = new Date();
		final Date expiryDate = new Date(now.getTime() + Long.parseLong(JWT_REFRESH_EXPIRATION));
	    return Jwts.builder()
	    		.setSubject(username)
	    		.setIssuedAt(now)
	            .setExpiration(expiryDate)
	            .signWith(SignatureAlgorithm.HS512, JWT_REFRESH_SECRET)
	            .compact();
	}
	
    public String getUsernameFromJWT(String token) {
    	final Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
    
    public JWTBody extractJWTBodyFromJWT(String token) {
    	final Claims claims = Jwts.parser().setSigningKey(JWT_SECRET)
    			.parseClaimsJws(token).getBody();
    	 
    	Long staffId = Optional.ofNullable(claims.get("staffId"))
    	        .filter(Number.class::isInstance)
    	        .map(Number.class::cast)
    	        .map(Number::longValue)
    	        .orElse(null);
    	String phone = (String) claims.get("phone");
    	String email = (String) claims.get("email");

        Object rawAuthorities = claims.getOrDefault("authorities", Collections.emptyList());
        List<Authority> authorities;
		try {
			authorities = JsonUtils.map(JsonUtils.toJson(rawAuthorities), new TypeReference<List<Authority>>() { });
		} catch (JsonProcessingException e) {
			log.error("Error parsing authorities from JWT: {}", e.getMessage());
			authorities = Collections.emptyList();
		}
 
        
		return JWTBody.builder()
        		.phone(phone)
        		.staffId(staffId)
        		.authorities(authorities)
        		.email(email)
        		.build();
    }
    
    public String getUsernameFromRefreshJWT(String token) {
    	final Claims claims = Jwts.parser().setSigningKey(JWT_REFRESH_SECRET).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
   

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
    
    public boolean validateRefreshToken(String refreshToken) {
        try {
            Jwts.parser().setSigningKey(JWT_REFRESH_SECRET).parseClaimsJws(refreshToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }

    /**
     * second unit
     * **/
	public Long getAccessTokenExpire() {
		double value = Long.valueOf(this.JWT_EXPIRATION)  / (double) 1000;
		return (long) Math.ceil(value);
	}
 
    /**
     * second unit
     * **/
	public Long getRefreshTokenExpire() {
		double value = Long.valueOf(this.JWT_REFRESH_EXPIRATION)  / (double) 1000;
		return (long) Math.ceil(value);
	}
 
}
