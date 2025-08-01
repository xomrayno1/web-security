package com.security.utils;

public class ConstantManager {
	private ConstantManager() {
		throw new IllegalStateException("Utility class");
	}

	public static final String AUTHORIZATION = "Authorization";

	public static final String REFRESH_TOKEN_KEY = "refreshToken";

	public static final String BLACK_LIST_REFRESH_TOKEN = "blackRefreshTokens";

	public static final String REQUEST_ID_KEY = "requestId";
	
	public static final String IP_ADDRESS = "ipAddress";
	
	public static final String DEMO_LOG_TTL = "7d";
	
	public static final String FIXED_TOKEN_HEADER = "Verify-Token";
	
	public static final String REQUEST_TYPE = "requestType";
	
	public static final String REQUEST_TYPE_FEIGN = "feign";

}
