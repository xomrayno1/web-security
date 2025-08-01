package com.security.utils;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

public class Commons {
	private static final SecureRandom secureRandom = new SecureRandom();

	private Commons() {
		throw new IllegalArgumentException("Commons is uitl class");
	}

	public static String generateCategoryCode() {
		return "C" + generateRandomNumber();
	}
	
	public static String generateOrderNumber() {
		return "EC" + generateRandomNumber();
	}

	public static String generateSupplierCode() {
		return "S" + generateRandomNumber();
	}

	public static String generateProductCode() {
		return "P" + generateRandomNumber();
	}
 
	public static String generateProductInfoCode() {
		return "PI" + generateRandomNumber();
	}

	public static Long generateRandomNumber() {
		return Math.abs(secureRandom.nextLong() % 100000000000L);
	}
	
	public static String randomOTP() {
		return generateRandomNumber().toString().substring(0, 8);
	}

	public static <T> Optional<T> formatValue(T t) {
		return Optional.empty();
	}
	
	public static <T> boolean isNullOrEmpty(List<T> values) {
		return values == null || values.isEmpty();
	}
	

	public static String generateCustomerCode() {
		return "CUS" + generateRandomNumber();
	}
	
	public static String createRedisKey(String prefix, String keyname) {
		return prefix.concat("_").concat(keyname);
	}
}
