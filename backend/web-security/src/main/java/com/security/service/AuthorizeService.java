package com.security.service;

public interface AuthorizeService {
	boolean hasAnyForm(String ...formCode);
	
	boolean hasAnyControlInForm(String formCode, String ...controlCodes);
}
