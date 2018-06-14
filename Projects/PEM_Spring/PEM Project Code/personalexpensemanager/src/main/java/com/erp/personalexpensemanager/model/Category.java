package com.erp.personalexpensemanager.model;

import java.io.Serializable;

/**
 * This class is used as POJO for Category
 * @author Nikhil Bhole
 *
 */
public class Category implements Serializable {
	
	/**
	 * categoryId is id for Category
	 */
	private int categoryId;
	
	/**
	 * Category Name
	 */
	private String name;
	
	/**
	 * User Id
	 */
	private int userId;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public Category(int categoryId, String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}

	public Category(String name, int userId) {
		super();
		this.name = name;
		this.userId = userId;
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category() {
		
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + ", userId=" + userId + "]";
	}

	

}
