package com.erp.personalexpensemanager.exception;

/**
 * this is user define exception for empty list which extends parent Exception class
 * @author Nikhil
 *
 */
public class ListIsEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ListIsEmptyException(String message) {
		super(message);
	}

}
