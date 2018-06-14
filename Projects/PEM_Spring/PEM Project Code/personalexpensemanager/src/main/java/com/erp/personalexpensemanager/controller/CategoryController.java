package com.erp.personalexpensemanager.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.erp.personalexpensemanager.exception.CustomNullPointerException;
import com.erp.personalexpensemanager.exception.ListIsEmptyException;
import com.erp.personalexpensemanager.model.Category;
import com.erp.personalexpensemanager.service.CategoryService;
/**
 * this is controller class of category.
 * this class performing category releted operations.
 * @author Nikhil
 *
 */
@Controller
@RequestMapping(value="/user")
public class CategoryController {
	
	/**
	 * this is reference variable of CategoryService.
	 */
	@Autowired
	private CategoryService categoryservice;

	public CategoryService getCategoryservice() {
		return categoryservice;
	}

	public void setCategoryservice(CategoryService categoryservice) {
		this.categoryservice = categoryservice;
	}
	
	@RequestMapping(value="/addCategory.ds", method=RequestMethod.GET)
	public String showAddCategoryPage() {
		return "addCategory";
	}

	@RequestMapping(value="/addNewCategory.ds", method=RequestMethod.POST)
	public ModelAndView addCategory(HttpServletRequest request, @ModelAttribute("category") Category category) {
		
		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userId");
		int result = 0;
		category.setUserId(userid);
		try {
			result = categoryservice.addCategory(category);
		} catch (CustomNullPointerException e) {
			ModelAndView model = new ModelAndView("addCategory");
			model.addObject("message", "enter valid category name");
			return model;
		}
		
		if(result > 0) {
			ModelAndView model = new ModelAndView("addCategory");
			model.addObject("message", "Category Added Successfully");
			return model;
		}
		else {
			ModelAndView model = new ModelAndView("addCategory");
			model.addObject("message", "Enter valid category name");
			return model;
		}
	}
	
	@RequestMapping(value="/listCategory.ds", method=RequestMethod.GET)
	public ModelAndView listCategory(HttpServletRequest request) {
		
		List<Category> list = new ArrayList<Category>();
		HttpSession session = request.getSession();
		Integer userid = (Integer) session.getAttribute("userId");
		System.out.println(userid);
		
		try {
			list = categoryservice.categoryList(userid);
			ModelAndView model = new ModelAndView("listCategory");
			model.addObject("catList", list);
			return model;
		} catch (ListIsEmptyException e) {
			ModelAndView model = new ModelAndView("addCategory");
			model.addObject("message", "enter valid category name");
			return model;
		}		
	}
}
