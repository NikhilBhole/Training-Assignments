package com.erp;

/**
 * this class represent the category
 * @author Nikhil
 *
 */
public class Category {

	/**
	 * this variable refer unique category id. here is generated using current time
	 */
	private long categoryId = System.currentTimeMillis();
	
	/**
	 * this variable refer category name. and it is assign by user when user add category
	 */
	private String name;
	
	public Category(long categoryId, String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}
	
	public Category(String name) {
		super();
		this.name = name;
	}
	
	public Category() {	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + "]";
	}
	
	
	
	
}
