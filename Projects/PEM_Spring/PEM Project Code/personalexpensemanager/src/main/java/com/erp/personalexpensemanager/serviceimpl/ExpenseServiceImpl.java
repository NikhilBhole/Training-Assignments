package com.erp.personalexpensemanager.serviceimpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.personalexpensemanager.dao.ExpenseDao;
import com.erp.personalexpensemanager.exception.CustomNullPointerException;
import com.erp.personalexpensemanager.model.Expense;
import com.erp.personalexpensemanager.service.ExpenseService;

@Service("expenseservice")
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseDao expensedao;
	
	public ExpenseDao getExpensedao() {
		return expensedao;
	}

	public void setExpensedao(ExpenseDao expensedao) {
		this.expensedao = expensedao;
	}

	public int addExpense(Expense expense) throws CustomNullPointerException {

		return expensedao.addExpense(expense);
	}

	public Map<String, Expense> expenseList(Integer userid) {

		return expensedao.expenseList(userid);
	}

	public int deleteExpense(Integer expenseid) {

		return expensedao.deleteExpense(expenseid);
	}

	public Map<String, Integer> monthlyReport(Integer userid) {
		
		return expensedao.monthlyReport(userid);
	}

	public Map<String, Integer> yearlyReport(Integer userid) {

		return expensedao.yearlyReport(userid);
	}

	public Map<String, Integer> categorywiseReport(Integer userid) {

		return expensedao.categorywiseReport(userid);
	}

}
