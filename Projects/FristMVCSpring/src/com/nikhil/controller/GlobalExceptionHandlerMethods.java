package com.nikhil.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandlerMethods {

	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Exception e){
		
		System.out.println(e);
		
		return "NullPointerException";//this is NullPointerException.jsp name
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e){
		
		System.out.println(e);
		
		return "Exception";//this is NullPointerException.jsp name
	}
}
