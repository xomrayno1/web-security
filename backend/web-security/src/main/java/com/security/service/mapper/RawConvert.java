package com.security.service.mapper;

import com.security.model.Authority;
import com.security.model.AuthorityLoginSpec;
import com.security.model.enums.RoleControlType;

public class RawConvert {
	
	/**
	 * Convert a list of AuthorityLoginSpec to a list of Authority.FormInfo
	 * 
	 * @param forms List of AuthorityLoginSpec
	 * @return List of Authority.FormInfo
	 */
	public static Authority.FormInfo toAuthorityFormInfo(AuthorityLoginSpec form){
		Authority.FormInfo formInfo = new Authority.FormInfo();
		formInfo.setFormId(form.getFormId());
		formInfo.setFormCode(form.getFormCode());
		formInfo.setFormName(form.getFormName());
		formInfo.setFormType(form.getFormType());
		formInfo.setPath(form.getPath());
		formInfo.setParentId(form.getParentId());
		return formInfo;
	}
	
	public static Authority.RoleControl toAuthorityRoleControl(AuthorityLoginSpec authorityLoginSpec){
		Authority.RoleControl roleControl = new Authority.RoleControl();
		roleControl.setControleId(authorityLoginSpec.getControlId());
		roleControl.setControlName(authorityLoginSpec.getControlName());
		roleControl.setControlCode(authorityLoginSpec.getControlCode());
		if(authorityLoginSpec.getRoleControlType() != null) {
			roleControl.setRoleControlType(RoleControlType.valueOf(authorityLoginSpec.getRoleControlType()));
		}
		return roleControl;
	}

}
