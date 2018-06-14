package com.erp.personalexpensemanager.exception;

/**
 * this is user define exception of null pointer which extends parent Exception class.
 * @author Nikhil
 *
 */
public class CustomNullPointerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomNullPointerException(String message) {
		super(message);
	}

}
