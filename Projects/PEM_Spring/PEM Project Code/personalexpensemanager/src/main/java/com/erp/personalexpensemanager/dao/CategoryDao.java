package com.erp.personalexpensemanager.dao;

import java.util.List;

import com.erp.personalexpensemanager.exception.CustomNullPointerException;
import com.erp.personalexpensemanager.exception.ListIsEmptyException;
import com.erp.personalexpensemanager.model.Category;
/**
 * this is a CategoryDao interface and having declaration of category operations. 
 * @author Nikhil
 *
 */
public interface CategoryDao {
	/**
	 * this method used to add new category
	 * @param category
	 * @return 1-success,0-failure
	 * @throws CustomNullPointerException
	 */
	public int addCategory(Category category) throws CustomNullPointerException;
	
	/**
	 * this method is used to get list of category of person
	 * @param userid
	 * @return list of category.
	 * @throws ListIsEmptyException
	 */
	public List<Category> categoryList(Integer userid) throws ListIsEmptyException;

}
