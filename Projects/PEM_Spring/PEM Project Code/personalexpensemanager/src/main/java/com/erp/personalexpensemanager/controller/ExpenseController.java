package com.erp.personalexpensemanager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.erp.personalexpensemanager.exception.CustomNullPointerException;
import com.erp.personalexpensemanager.exception.ListIsEmptyException;
import com.erp.personalexpensemanager.model.Category;
import com.erp.personalexpensemanager.model.Expense;
import com.erp.personalexpensemanager.service.CategoryService;
import com.erp.personalexpensemanager.service.ExpenseService;
/**
 * this is controller class of Expenses.
 * this class performing expense releted operations.
 * @author Nikhil
 *
 */
@Controller
@RequestMapping(value="/user")
public class ExpenseController {

	/**
	 * this is a reference variable of ExpenseService.
	 */
	@Autowired
	private ExpenseService expenseservice;
	
	@Autowired
	private CategoryService categoryservice;

	public CategoryService getCategoryservice() {
		return categoryservice;
	}

	public void setCategoryservice(CategoryService categoryservice) {
		this.categoryservice = categoryservice;
	}

	public ExpenseService getExpenseservice() {
		return expenseservice;
	}

	public void setExpenseservice(ExpenseService expenseservice) {
		this.expenseservice = expenseservice;
	}
	
	@RequestMapping(value="/addExpense.ds", method=RequestMethod.GET)
	public ModelAndView showAddExpensePage(HttpServletRequest request) {
		List<Category> list = new ArrayList<Category>();
		HttpSession session = request.getSession();
		Integer userid = (Integer) session.getAttribute("userId");
		System.out.println(userid);
		
		try {
			list = categoryservice.categoryList(userid);
			ModelAndView model = new ModelAndView("addExpense");
			model.addObject("categoryList", list);
			return model;
		} catch (ListIsEmptyException e) {
			ModelAndView model = new ModelAndView("addExpense");
			model.addObject("message", "enter valid category name");
			return model;
		}		
	}
	
	@RequestMapping(value="/addNewExpense.ds", method=RequestMethod.POST)
	public ModelAndView addExpense(HttpServletRequest request, @RequestParam("categoryId") Integer categoryId, @ModelAttribute("expense") Expense expense) {
		List<Category> list = new ArrayList<Category>();
		HttpSession session = request.getSession();
		Integer userid = (Integer) session.getAttribute("userId");
		expense.setCategoryId(categoryId);
		expense.setUserId((Integer)session.getAttribute("userId"));
		int result = 0;
		System.out.println(expense);
		try {
			result = expenseservice.addExpense(expense);
			list = categoryservice.categoryList(userid);
		} catch (CustomNullPointerException e) {
			System.out.println(e.getMessage());
		} catch (ListIsEmptyException e) {
			System.out.println(e.getMessage());
		}
		if(result > 0) {
			ModelAndView model = new ModelAndView("addExpense");
			model.addObject("message", "Expense is added");
			model.addObject("categoryList", list);
			return model;
		}
		else {
			System.out.println("in else");
			ModelAndView model = new ModelAndView("addExpense");
			model.addObject("message", "Expense is not added");
			model.addObject("categoryList", list);
			return model;
		}
	}
	
	@RequestMapping(value="/listExpense.ds", method=RequestMethod.GET)
	public ModelAndView showListExpensePage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer userid = (Integer) session.getAttribute("userId");
		Map<String, Expense> map = new TreeMap<String, Expense>();
		map = expenseservice.expenseList(userid);
		ModelAndView model = new ModelAndView("expenseList");
		model.addObject("expenseList", map);
		return model;
	}
	
	@RequestMapping(value="/deleteExpense.ds", method=RequestMethod.GET)
	public ModelAndView showDeleteExpensePage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer userid = (Integer) session.getAttribute("userId");
		Map<String, Expense> map = new TreeMap<String, Expense>();
		map = expenseservice.expenseList(userid);
		ModelAndView model = new ModelAndView("deleteExpense");
		model.addObject("expenseList", map);
		return model;
	}
	
	@RequestMapping(value="/deleteOneExpense.ds", method=RequestMethod.POST)
	public ModelAndView deleteExpense(HttpServletRequest request, @RequestParam("categoryId") Integer categoryId) {
		ModelAndView model = null;
		HttpSession session = request.getSession();
		Integer userid = (Integer) session.getAttribute("userId");
		Map<String, Expense> map = new TreeMap<String, Expense>();
		int result = expenseservice.deleteExpense(categoryId);
		if(result > 0) {
			model = new ModelAndView("deleteExpense");
			map = expenseservice.expenseList(userid);
			model.addObject("message", "Expense deleted successfully");
			model.addObject("expenseList", map);
			return model;
		}
		else {
			model = new ModelAndView("deleteExpense");
			map = expenseservice.expenseList(userid);
			model.addObject("message", "Expense not deleted");
			model.addObject("expenseList", map);
			return model;
		}
	}
	
	@RequestMapping(value="/monthlyReport.ds", method=RequestMethod.GET)
	public ModelAndView showMonthlyReport(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer userid = (Integer) session.getAttribute("userId");
		Map<String, Integer> map = new TreeMap<String, Integer>();
		map = expenseservice.monthlyReport(userid);
		ModelAndView model = new ModelAndView("monthlyReport");
		model.addObject("expenseList", map);
		return model;
	}
	
	@RequestMapping(value="/yearlyReport.ds", method=RequestMethod.GET)
	public ModelAndView showYearlyReport(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer userid = (Integer) session.getAttribute("userId");
		Map<String, Integer> map = new TreeMap<String, Integer>();
		map = expenseservice.yearlyReport(userid);
		ModelAndView model = new ModelAndView("yearlyReport");
		model.addObject("expenseList", map);
		return model;
	}
	
	@RequestMapping(value="/categoryReport.ds", method=RequestMethod.GET)
	public ModelAndView showCategorywiseReport(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer userid = (Integer) session.getAttribute("userId");
		Map<String, Integer> map = new TreeMap<String, Integer>();
		map = expenseservice.categorywiseReport(userid);
		ModelAndView model = new ModelAndView("categorywiseReport");
		model.addObject("expenseList", map);
		return model;
	}
}
