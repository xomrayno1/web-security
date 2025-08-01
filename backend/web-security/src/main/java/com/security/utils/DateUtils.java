package com.security.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static final String PATTERN_DATE_FORMAT = "dd/MM/yyyy";
	public static final String PATTERN_DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";

	public static Date convertStringToDate(String dateString, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		try {
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String convertDateToString(Date date, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		try {
			return dateFormat.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date addDays(Date date, Integer numberOfDays) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, numberOfDays);
		return calendar.getTime();
	}
	
	// viết function để lấy ngày hiện tại
	public static Date getCurrentDate() {
		return new Date();
	}
	
	// viết function để lấy ngày hiện tại với format
	public static String getCurrentDate(String pattern) {
		return convertDateToString(new Date(), pattern);
	}
	
	/**
	 * @return int : distance between two dates in days
	 * 
	 * @Param date1: LocalDateTime
	 * @Param date2: LocalDateTime
	 * @return int 
	 * **/
	public static int daysBetweenTwoDates(LocalDateTime date1, LocalDateTime date2) {
		return (int) ChronoUnit.DAYS.between(date1, date2);
    }
	 
	
}
