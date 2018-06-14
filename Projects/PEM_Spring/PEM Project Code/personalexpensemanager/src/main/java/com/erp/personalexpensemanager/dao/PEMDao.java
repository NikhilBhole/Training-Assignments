package com.erp.personalexpensemanager.dao;

import java.util.List;
import java.util.Map;

import com.erp.personalexpensemanager.exception.CustomNullPointerException;
import com.erp.personalexpensemanager.model.Category;
import com.erp.personalexpensemanager.model.Expense;
import com.erp.personalexpensemanager.model.User;

/**
 * Inteface for PEM userDAO
 * @author Nikhil Bhole
 *
 */
public interface PEMDao {

	/**
	 * This method will register user
	 * @param user
	 * @return 1-success,0-failure
	 * @throws CustomNullPointerException 
	 */
	int addUser(User user) throws CustomNullPointerException;
	
	/**
	 * This method will Login user into appliation
	 * @param loginName
	 * @return User
	 * @throws CustomNullPointerException 
	 */
	User loginUser(String loginName) throws CustomNullPointerException;
		
}

