package com.erp.personalexpensemanager.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.erp.personalexpensemanager.model.Expense;

/**
 * this is row mapper class of Expense which implements RowMapper interface.
 * this class is used to get expense object from database of expense.
 * also implement maprow method.
 * @author Nikhil
 *
 */
public class ExpenseRowMapper implements RowMapper<Expense> {

	public Expense mapRow(ResultSet rs, int rowNum) throws SQLException {

		Expense expense = new Expense();
		expense.setExpenseId(rs.getInt(1));
		expense.setCategoryId(rs.getInt(2));
		expense.setUserId(rs.getInt(3));
		expense.setAmount(rs.getInt(4));
		expense.setDate(rs.getString(5));
		expense.setRemark(rs.getString(6));
		return expense;
	}

}
