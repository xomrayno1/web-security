package com.security.model;

public interface AuthorityLoginSpec {
	Long getRoleId();
	String getRoleName();
	String getRoleCode();
	Boolean getIsDefault();
	
	Long getFormId();
	String getFormCode();
	String getFormName();
	String getFormType();
	Long getParentId();
	String getPath();
	
	Long getControlId();
	String getControlCode();
	String getControlName();
	String getRoleControlType();

}
