package com.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoleSecurity {
	private Long roleId;
	private String roleName;
	private String roleCode;
}
