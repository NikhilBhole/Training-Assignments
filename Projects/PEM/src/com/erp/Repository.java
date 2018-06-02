package com.erp;

import java.util.ArrayList;
import java.util.List;

/**
 * this class are used as database/repository and it is singleton
 * this class represent singleton design pattern
 * @author Nikhil
 *
 */
public class Repository {
	
	/**
	 * this is list of expences and add only expense object in list
	 */
	public List<Expense> expList = new ArrayList<>();
	
	/**
	 * this is list of category and add only category object
	 */
	public List<Category> catList = new ArrayList<>();
	
	/**
	 * this is static repository referance variable.
	 */
	private static Repository repository;
	
	/**
	 * this is a private default constructor and it is accessible within class only
	 * this constructor restrict creation of object outside
	 */
	private Repository() {
		
	}
	
	/**
	 * this is static method and create single object
	 * this object are available to overall application because it is singleton object
	 * @return object of repository class
	 */
	public static Repository getRepository() {
		
		if(repository == null) {
			repository = new Repository();
		}
		
		return repository;
	}

}
