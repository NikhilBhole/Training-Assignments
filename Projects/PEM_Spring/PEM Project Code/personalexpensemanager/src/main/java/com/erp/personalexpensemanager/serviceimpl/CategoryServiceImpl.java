package com.erp.personalexpensemanager.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.personalexpensemanager.dao.CategoryDao;
import com.erp.personalexpensemanager.exception.CustomNullPointerException;
import com.erp.personalexpensemanager.exception.ListIsEmptyException;
import com.erp.personalexpensemanager.model.Category;
import com.erp.personalexpensemanager.service.CategoryService;

@Service("categoryservice")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categorydao;
	
	public CategoryDao getCategorydao() {
		return categorydao;
	}

	public void setCategorydao(CategoryDao categorydao) {
		this.categorydao = categorydao;
	}

	public int addCategory(Category category) throws CustomNullPointerException {
		return categorydao.addCategory(category);
	}

	public List<Category> categoryList(Integer userid) throws ListIsEmptyException {
		return categorydao.categoryList(userid);
	}

}
