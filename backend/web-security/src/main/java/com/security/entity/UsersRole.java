package com.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users_role")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor	
public class UsersRole extends BaseEntity {
	
	private static final long serialVersionUID = 6264498498574298923L;

	@ManyToOne
	@JoinColumn(name = "users_id")
	private Users users;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

}
