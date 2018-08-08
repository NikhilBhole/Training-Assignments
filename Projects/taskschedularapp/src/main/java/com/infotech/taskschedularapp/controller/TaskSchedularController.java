package com.infotech.taskschedularapp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.infotech.taskschedularapp.domain.Task;
import com.infotech.taskschedularapp.domain.User;
import com.infotech.taskschedularapp.exception.CustomNullPointerException;
import com.infotech.taskschedularapp.service.TaskSchedularAppService;

@Controller
@RequestMapping(value="/user")
@Scope("session")
public class TaskSchedularController {
	
	@Autowired
	private TaskSchedularAppService service;
	HttpSession session;

	public TaskSchedularAppService getService() {
		return service;
	}

	public void setService(TaskSchedularAppService service) {
		this.service = service;
	}

	@RequestMapping(value="/home.ds", method=RequestMethod.GET)
	public String showHomePage() {
		return "home";
	}
		
	@RequestMapping(value="/login.ds", method=RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/userRegistration.ds", method=RequestMethod.GET)
	public String showRegistrationPage() {
		return "userRegistration";
	}
	
	@RequestMapping(value="/showLogin.ds", method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") User user) {
		Integer returnvalue = null;
		try {
			returnvalue = service.userRegistration(user);
		} catch (CustomNullPointerException e) {
			System.out.println(e.getMessage());
		}
		if(returnvalue>0) {
			ModelAndView model = new ModelAndView("login");
			return model;
		}
		else {
			ModelAndView model = new ModelAndView("userRegistration");
			return model;
		}
		
	}
	
	@RequestMapping(value="/profiles.ds", method=RequestMethod.GET)
	public ModelAndView showProfilePage(HttpServletRequest request, @RequestParam Map<String, String> value) {
		String loginType = value.get("login");
		String loginname = value.get("loginname");
		String password = value.get("password");
		User user;
		try {
		user = service.userLogin(loginType, loginname);
		}
		catch(Exception e) {
			ModelAndView model = new ModelAndView("login");
			return model;
		}
		System.out.println(password+" "+user.getPassword());
		if(password.equals(user.getPassword())) {
			session = request.getSession();
			session.setAttribute("userid", user.getId());
			session.setMaxInactiveInterval(30*60);
			ModelAndView model = new ModelAndView("profile");
			model.addObject("user", user);
			return model;
		}else {
			ModelAndView model = new ModelAndView("login");
			return model;
		}		
	}
	
	@RequestMapping(value="/addTask.ds", method=RequestMethod.GET)
	public String showAddTaskPage() {
		return "addTask";
	}
	
	@RequestMapping(value="/profile.ds", method=RequestMethod.GET)
	public String showprofilePage() {
		return "profile";
	}
	
	@RequestMapping(value="/saveTask.ds", method=RequestMethod.POST)
	public ModelAndView saveTask(@ModelAttribute("task") Task task) {
		Integer returnvalue = 0;
		Integer userid = (Integer) session.getAttribute("userid");
		System.out.println(userid);
		task.setUserId(userid);
		returnvalue = service.insertTask(task);
		if(returnvalue > 0) {
			ModelAndView model = new ModelAndView("addTask");
			return model;
		}else {
			ModelAndView model = new ModelAndView("addTask");
			model.addObject("errormessage", "Task is not inserted");
			return model;
		}
		
	}
	
	@RequestMapping(value="/listTask.ds", method=RequestMethod.GET)
	public ModelAndView showListTaskPage() {
		List<Task> tasks = new ArrayList<Task>();
		Integer userid = (Integer) session.getAttribute("userid");
		tasks = service.listAllTask(userid);
		for (Task task : tasks) {
			System.out.println(task);
		}
		ModelAndView model = new ModelAndView("listTask");
		model.addObject("tasklist", tasks);
		return model;
		
	}
	
	@RequestMapping(value="/export.ds", method=RequestMethod.POST)
	public ModelAndView exportListToExcel() {
		
		ModelAndView model = new ModelAndView("listTask");
		FileOutputStream fo = null;
		File file = new File("D:/ListOfTasksSheet.xls");
		try {
			file.createNewFile();
			file.setReadable(true);
			file.setWritable(true);
			fo = new FileOutputStream(file);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		String path = file.getAbsolutePath();
		System.out.println(path);
		List<Task> tasks = new ArrayList<Task>();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("tasks");
		Integer userid = (Integer) session.getAttribute("userid");
		tasks = service.listAllTask(userid);
		int rownumber = 0;
		for (Task task : tasks) {
			Row row = sheet.createRow(rownumber++);
			row.createCell(0).setCellValue(task.getId());
	         row.createCell(1).setCellValue(task.getTitle());
	         row.createCell(2).setCellValue(task.getDescription());
	         row.createCell(3).setCellValue(task.getStartDate());
	         row.createCell(4).setCellValue(task.getEndDate());
	         row.createCell(5).setCellValue(task.getStatus());
		}
		try {
			workbook.write(fo);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		model.addObject("tasklist", tasks);
		return model;		
	}	
	
	@RequestMapping(value="/imports.ds", method=RequestMethod.GET)
	public String showImportPage() {
		return "imports";
	}
	
	@RequestMapping(value="/import.ds", method=RequestMethod.POST)
	public ModelAndView importFile(@RequestParam("file") String filename) {
		File file = new File(filename);
		String filepath = file.getAbsolutePath();
		return null;
		
	}
	
	@RequestMapping(value="/updateTask.ds", method=RequestMethod.GET)
	public ModelAndView showUpdateTaskPage() {
		ModelAndView model = new ModelAndView("updateTaskList");
		List<Task> tasks = new ArrayList<Task>();
		Integer userid = (Integer) session.getAttribute("userid");
		tasks = service.listAllTask(userid);
		
		model.addObject("tasklist", tasks);
		return model;
	}
	
	@RequestMapping(value="/update.ds", method=RequestMethod.POST)
	public ModelAndView updateTask(@RequestParam("radio") String taskTitle) {
		ModelAndView model = new ModelAndView("updateTask");
		System.out.println(taskTitle);
		
		Task task = service.searchTaskByTitle(taskTitle);
		
		model.addObject("task", task);
		return model;
	}
	@RequestMapping(value="/updatenewTask.ds", method=RequestMethod.POST)
	public ModelAndView updateExistTask(@ModelAttribute("task") Task task) {
		ModelAndView model = new ModelAndView("updateTaskList");
		System.out.println(task);
		
		return null;
		
	}
	
	
}
