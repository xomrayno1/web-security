package com.security.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.security.model.Authority;
import com.security.model.AuthorityLoginSpec;
import com.security.service.mapper.RawConvert;

public class BaseServiceImpl {
	
	/**
	 * Danh sách control <br>
	 * 
	 * **/
	protected Map<Long, Set<Authority.RoleControl>> extractControlMap(List<AuthorityLoginSpec> forms) {
		return forms.stream().filter(item -> item.getControlId() != null).collect(Collectors.groupingBy(AuthorityLoginSpec::getFormId,
				Collectors.mapping(RawConvert::toAuthorityRoleControl, Collectors.toSet())));
	} 

}
