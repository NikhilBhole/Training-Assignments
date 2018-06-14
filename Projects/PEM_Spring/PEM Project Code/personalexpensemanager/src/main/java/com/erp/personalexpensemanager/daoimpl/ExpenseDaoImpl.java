package com.erp.personalexpensemanager.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.erp.personalexpensemanager.dao.ExpenseDao;
import com.erp.personalexpensemanager.exception.CustomNullPointerException;
import com.erp.personalexpensemanager.model.Category;
import com.erp.personalexpensemanager.model.Expense;
import com.erp.personalexpensemanager.rowmapper.CategoryRowMapper;
import com.erp.personalexpensemanager.rowmapper.ExpenseRowMapper;

@Repository("expensedao")
public class ExpenseDaoImpl implements ExpenseDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addExpense(Expense expense) throws CustomNullPointerException {
		String sql = "insert into expense(categoryid, userid, amount, date, remark) values (?,?,?,?,?)";
		int result = 0;
		if(expense == null) {
			throw new CustomNullPointerException("expense having null values");
		}
		else {
			try{
				System.out.println("in dao"+expense);
				result = jdbcTemplate.update(sql, new Object[] {expense.getCategoryId(), expense.getUserId(), expense.getAmount(), expense.getDate(), expense.getRemark()});
				
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	public Map<String, Expense> expenseList(Integer userid) {
		Map<String, Expense> map = new TreeMap<String, Expense>();
		List<Expense> list = new ArrayList<Expense>();
		String sql = "select * from expense where userid = ?";
		list = jdbcTemplate.query(sql, new ExpenseRowMapper(), userid);
		int i=1;
		for (Expense expense : list) {
			String categoryName = getCategoryNameById(expense.getCategoryId());
			if(map.containsKey(categoryName)) {
				categoryName = categoryName+" "+i;
				map.put(categoryName, expense);
				i++;
			}
			else {
				
				categoryName = categoryName+" "+i;
				map.put(categoryName, expense);
				i++;
			}
		}
		return map;
	}

	public int deleteExpense(Integer expenseid) {
		String sql = "delete from expense where id = ?";
		int result = jdbcTemplate.update(sql,expenseid);
		return result;
	}

	public String getCategoryNameById(Integer id) {
		
		String sql = "select * from category where categoryid = ?";
		
		Category category = new Category();
		category = jdbcTemplate.queryForObject(sql, new CategoryRowMapper(), id);
		
		return category.getName();
	}
	
	public String getMonthName(Integer monthNo) {
		
		final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July","September", "Octomber", "November", "December"};
		return MONTHS[monthNo-1];
		
	}
	
	public Map<String, Integer> monthlyReport(Integer userid) {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		List<Expense> list = new ArrayList<Expense>();
		String sql = "select * from expense where userid = ?";
		list = jdbcTemplate.query(sql, new ExpenseRowMapper(), userid);
		for (Expense expense : list) {
			String date = expense.getDate();
			String year = date.substring(0, 4);
			String month = getMonthName(Integer.parseInt(date.substring(5, 7)));
			String yearAndMonth = year+", "+month;
			Integer amount = expense.getAmount();
			if(map.containsKey(yearAndMonth)){
				int total=map.get(yearAndMonth);
				total=total+amount;
				map.put(yearAndMonth, total);
			}
			else{
				map.put(yearAndMonth, amount);
			}
		}
		return map;
		
	}

	public Map<String, Integer> yearlyReport(Integer userid) {

		Map<String, Integer> map = new TreeMap<String, Integer>();
		List<Expense> list = new ArrayList<Expense>();
		String sql = "select * from expense where userid = ?";
		list = jdbcTemplate.query(sql, new ExpenseRowMapper(), userid);
		
		for (Expense expense : list) {
			String date = expense.getDate();
			String year = date.substring(0, 4);
			Integer amount = expense.getAmount();
			
			if(map.containsKey(year)){
				int total=map.get(year);
				total=total+amount;
				map.put(year, total);
			}
			else{
				map.put(year, amount);
			}
		}
		return map;
	}

	public Map<String, Integer> categorywiseReport(Integer userid) {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		List<Expense> list = new ArrayList<Expense>();
		String sql = "SELECT * FROM expense where userid=?";
		list = jdbcTemplate.query(sql, new ExpenseRowMapper(), userid);
		for (Expense expense : list) {
			String categoryName = getCategoryNameById(expense.getCategoryId());
			Integer amount = expense.getAmount();
			
			if(map.containsKey(categoryName)) {
				int total=map.get(categoryName);
				total = total+amount;
				map.put(categoryName, total);
			}
			else {
				map.put(categoryName, amount);
			}
			
		}
		return map;
	}
}
