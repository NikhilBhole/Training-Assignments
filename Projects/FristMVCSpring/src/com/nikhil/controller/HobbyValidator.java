package com.nikhil.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String> {

	@Override
	public void initialize(IsValidHobby constraintAnnotation) {

		
	}

	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext ctx) {
		
		if(studentHobby == null){
			return false;
		}
		
		if(studentHobby.matches("music|football|cricket|hockey")){
			return true;
		}
		else{
			return false;

		}
		
	}
	
	

}
