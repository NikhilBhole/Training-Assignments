package com.erp.personalexpensemanager.dao;

import java.util.Map;

import com.erp.personalexpensemanager.exception.CustomNullPointerException;
import com.erp.personalexpensemanager.model.Expense;
/**
 * this is ExpenseDao interface and having declaration of Expense related operations.
 * @author Nikhil
 *
 */
public interface ExpenseDao {
	
	/**
	 * this method is used to add new expense.
	 * @param expense
	 * @return 1-success,0-failure
	 * @throws CustomNullPointerException
	 */
	public int addExpense(Expense expense) throws CustomNullPointerException;
	
	/**
	 * this method is used to get list of expenses of person
	 * @param userid
	 * @return list of expenses
	 */
	public Map<String, Expense> expenseList(Integer userid);
	
	/**
	 * this method is used to delete expense.
	 * @param expenseid
	 * @return 1-success,0-failure
	 */
	public int deleteExpense(Integer expenseid);
	
	/**
	 * this method is used to get list of expenses on the basis of month.
	 * @param userid
	 * @return list of expenses
	 */
	public Map<String, Integer> monthlyReport(Integer userid);
	
	/**
	 * this method is used to get list of expenses on the basis of year.
	 * @param userid
	 * @return list of expenses
	 */
	public Map<String, Integer> yearlyReport(Integer userid);
	
	/**
	 * this method is used to get list of expenses on the basis of category.
	 * @param userid
	 * @return list of expenses
	 */
	public Map<String, Integer> categorywiseReport(Integer userid);
}
