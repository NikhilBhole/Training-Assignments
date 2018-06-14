package com.erp.personalexpensemanager.service;

import java.util.Map;

import com.erp.personalexpensemanager.exception.CustomNullPointerException;
import com.erp.personalexpensemanager.model.Expense;

public interface ExpenseService {
	
	public int addExpense(Expense expense) throws CustomNullPointerException;
	public Map<String, Expense> expenseList(Integer userid);
	public int deleteExpense(Integer expenseid);
	public Map<String, Integer> monthlyReport(Integer userid);
	public Map<String, Integer> yearlyReport(Integer userid);
	public Map<String, Integer> categorywiseReport(Integer userid);

}
