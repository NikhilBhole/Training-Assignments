package com.erp.personalexpensemanager.controller;

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
import com.erp.personalexpensemanager.model.User;
import com.erp.personalexpensemanager.service.PEMService;
/**
 * this is controller class of user.
 * this class performing user related operations.
 * @author Nikhil
 *
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	/**
	 * this is reference variable of PEMService.
	 */
	@Autowired
	private PEMService userservice;
	
	public PEMService getUserservice() {
		return userservice;
	}

	public void setUserservice(PEMService userservice) {
		this.userservice = userservice;
	}

	@RequestMapping(value="/home.ds", method=RequestMethod.GET)
	public String showHomePage() {
		return "home";
	}

	@RequestMapping(value="/userlogin.ds", method=RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/userRegistration.ds", method=RequestMethod.GET)
	public String showRegistrationPage() {
		return "userRegistration";
	}
	
	@RequestMapping(value="registration.ds", method=RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute("user") User user) {
		
		ModelAndView model = null;
		try {
			model = new ModelAndView("login");
			int result = userservice.addUser(user);
			return model;
		} catch (CustomNullPointerException e) {
			model = new ModelAndView("userRegistration");
			model.addObject("errormsg", "submit valid information..");
			return model;
		}		
	}
	
	@RequestMapping(value="login.ds", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, @RequestParam("loginName") String loginname, @RequestParam("password") String password) {
		
		System.out.println(password);
		User user = null;
		try {
			user = userservice.loginUser(loginname);
			System.out.println(password+" "+user.getPassword());
		} catch (CustomNullPointerException e) {
			ModelAndView model = new ModelAndView("login");
			return model;
		}
		
		if(password.equals(user.getPassword())) {
			System.out.println(password+" "+user.getPassword());
			ModelAndView model = new ModelAndView("profile");
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getName());
			session.setMaxInactiveInterval(30*60);
			model.addObject("user", user);
			return model;
		}
		else {
			ModelAndView model = new ModelAndView("login");
			System.out.println(password+" "+user.getPassword());
			model.addObject("errormsg", "submit valid username and password");
			return model;
		}		
	}
	
	@RequestMapping(value="profile.ds", method=RequestMethod.GET)
	public ModelAndView showProfilePage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("profile");
		
		return model;
	}
	
	@RequestMapping(value="logout.ds", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("home");
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		return model;		
	}
}
