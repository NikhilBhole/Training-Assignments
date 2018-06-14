package com.erp.personalexpensemanager.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.erp.personalexpensemanager.model.Category;

/**
 * this is row mapper class of category which implements RowMapper interface.
 * this class is used to get category object from database of category.
 * also implement maprow method.
 * @author Nikhil
 *
 */
public class CategoryRowMapper implements RowMapper<Category> {

	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {

		Category category = new Category();
		category.setCategoryId(rs.getInt(1));
		category.setUserId(rs.getInt(2));
		category.setName(rs.getString(3));
		return category;
	}

}
