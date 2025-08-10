package com.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StaffInfoLogin {
	private Long staffId;
	private String phone;
	private String email;

}
