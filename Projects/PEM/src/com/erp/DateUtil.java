package com.erp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * this class contains static methods to handle Date
 * @author Nikhil
 *
 */
public class DateUtil {
	
	private static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July","September", "Octomber", "November", "December"};

	/**
	 * this method is used to convert date string to object
	 * @param dateAsString string
	 * @return date in object format
	 */
	public static Date stringToDate(String dateAsString){
		try {
			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");		
			return sd.parse(dateAsString);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * this method used to convert date oject to string
	 * @param date object
	 * @return date as string format
	 */
	public static String dateToString(Date date) {
		
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");		
		return sd.format(date);		
	}
	
	/**
	 * this method used to get date from dd/mm/yyyy format to yyyy, mm format
	 * @param date object
	 * @return date in yyyy,mm format as string
	 */
	public static String getYearAndMonth(Date date) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy,MM");		
		return sd.format(date);
	}
	
	/**
	 * this method used to get year from dd/mm/yyyy format to yyyy format
	 * @param date object
	 * @return date in yyyy format as integer
	 */
	public static Integer getYear(Date date) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy");		
		return new Integer(sd.format(date));
	}
	
	/**
	 * this method used to get month in string format
	 * @param monthNo as integer
	 * @return month as string
	 */
	public static String getMonthName(Integer monthNo) {
		
		return MONTHS[monthNo-1];
	}
}
