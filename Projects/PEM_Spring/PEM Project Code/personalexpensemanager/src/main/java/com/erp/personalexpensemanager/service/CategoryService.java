package com.erp.personalexpensemanager.service;

import java.util.List;

import com.erp.personalexpensemanager.exception.CustomNullPointerException;
import com.erp.personalexpensemanager.exception.ListIsEmptyException;
import com.erp.personalexpensemanager.model.Category;

public interface CategoryService {

	public int addCategory(Category category) throws CustomNullPointerException;
	public List<Category> categoryList(Integer userid) throws ListIsEmptyException;
}
