package com.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "permission")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Permission extends BaseEntity{
 
	private static final long serialVersionUID = -8208311203618870693L;

	@Column(name = "permission_code")
	private String permissionCode;
	
	@Column(name = "permission_name")
	private String permissionName;
}
