package com.erp;

import java.util.Date;

/**
 * this class represent expense details
 * @author Nikhil
 *
 */
public class Expense {

	/**
	 * this variable refer unique id as current time
	 */
	private long expenseId;
	
	/**
	 * this variable refer unique category id from category class
	 */
	private long categoryId;
	private float ammount;
	private Date date;
	private String remark;
	
	public Expense() {
		super();
	}

	public Expense(long categoryId, float ammount, Date date, String remark) {
		super();
		this.categoryId = categoryId;
		this.ammount = ammount;
		this.date = date;
		this.remark = remark;
	}

	public long getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(long expenseId) {
		this.expenseId = expenseId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public float getAmmount() {
		return ammount;
	}

	public void setAmmount(float ammount) {
		this.ammount = ammount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return ammount + ", " + remark ;
	}
	
	
}
