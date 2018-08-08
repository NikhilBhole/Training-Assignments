package com.infotech.taskschedularapp.exception;

/**
 * this is user defined CustomNullPointerException class which extends Exception super class
 * @author Nikhil
 *
 */
public class CustomNullPointerException extends Exception {

	/**
	 * this is parameterized constructor accept String as parameter.
	 * also call parameterized constructor of Exception super class.
	 * @param message
	 * @author Nikhil
	 */
	public CustomNullPointerException(String message) {
		super(message);
	}
}
