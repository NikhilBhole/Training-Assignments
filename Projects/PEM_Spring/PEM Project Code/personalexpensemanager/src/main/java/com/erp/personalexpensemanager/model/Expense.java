package com.erp.personalexpensemanager.model;

import java.io.Serializable;
import java.util.Date;

/**
 * This class is used as POJO for Expense
 * @author Nikhil Bhole
 *
 */
public class Expense implements Serializable {
	
	/**
	 * ID for Expense
	 */
	private int expenseId;
	
	/**
	 * ID of category
	 */
	private int categoryId;
	
	/**
	 * amount in integer
	 */
	private int amount;
	
	/**
	 * Expense date
	 */
	private String date;
	
	/**
	 * remark of Expense
	 */
	private String remark;
	
	/**
	 * User Id
	 */
	private int userId;

	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	public Expense(int categoryId, int amount, String date, String remark, int userId) {
		super();
		this.categoryId = categoryId;
		this.amount = amount;
		this.date = date;
		this.remark = remark;
		this.userId = userId;
	}

	public Expense() {

	}

	@Override
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", categoryId=" + categoryId + ", amount=" + amount + ", date="
				+ date + ", remark=" + remark + ", userId=" + userId + "]";
	}

}
