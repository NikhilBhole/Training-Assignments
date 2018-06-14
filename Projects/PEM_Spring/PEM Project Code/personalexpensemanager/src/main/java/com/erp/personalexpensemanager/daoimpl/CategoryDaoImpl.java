package com.erp.personalexpensemanager.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.erp.personalexpensemanager.dao.CategoryDao;
import com.erp.personalexpensemanager.exception.CustomNullPointerException;
import com.erp.personalexpensemanager.exception.ListIsEmptyException;
import com.erp.personalexpensemanager.model.Category;
import com.erp.personalexpensemanager.rowmapper.CategoryRowMapper;

@Repository("categorydao")
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addCategory(Category category) throws CustomNullPointerException {
		if(category == null) {
			throw new CustomNullPointerException("category has null values");
		}
		else {
			String sql = "insert into category(userid, name) values(?,?)";
			int result = jdbcTemplate.update(sql, new Object[] {category.getUserId(), category.getName()});
			return result;
		}
	}

	public List<Category> categoryList(Integer userid) throws ListIsEmptyException {
		
		List<Category> list = new ArrayList<Category>();
		Category category = null;
		String sql = "select * from category where userid=?";
		try {
			list = jdbcTemplate.query(sql, new CategoryRowMapper(), userid);
			for (Category category2 : list) {
				System.out.println(category2);
			}
			System.out.println("list size "+list.size());
			return list;
		}catch(Exception e) {
			throw new ListIsEmptyException("list is empty");
		}
	}

}
