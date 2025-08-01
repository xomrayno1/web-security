package com.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.security.model.enums.UserType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Users extends BaseEntity{
	
	private static final long serialVersionUID = 2689886831999505082L;

	@Column(name = "username")
	private String username;
	
	@Column(name = "hash_password")
	private String hashPassword;
 
	@Column(name = "user_type")
	@Enumerated(EnumType.STRING)
	private UserType userType;

	
}
