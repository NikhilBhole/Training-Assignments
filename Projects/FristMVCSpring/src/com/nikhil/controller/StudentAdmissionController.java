package com.nikhil.controller;

import java.beans.PropertyEditor;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StudentAdmissionController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
	//	binder.setDisallowedFields(new String[] {"studentMobile"});
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(format, false));
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}
	
	@RequestMapping(value="/admissionForm.html" , method= RequestMethod.GET)
	public ModelAndView getAdmissionForm()throws Exception{
		
		String exceptionOccured="NULL_POINTER";
		if(exceptionOccured.equalsIgnoreCase("NULL_POINTER")){
			throw new NullPointerException("null pointer exception");
		}
		
		ModelAndView modelandview = new ModelAndView("AdmissionForm");
		return modelandview;
	}
	
	@ModelAttribute
	public void addingCommenObjects(Model model1){
		model1.addAttribute("msg", "Student Record");
		
	}
	
	@RequestMapping(value="/submitAdmissionForm.html" , method= RequestMethod.POST)
//	public ModelAndView submitAdmissionForm(@RequestParam("studentName") String name, 
//											@RequestParam("studentHobby") String hobby){
public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student1") Student student1, BindingResult results){
//		Student student1 = new Student();
//		student1.setStudentName(name);
//		student1.setStudentHobby(hobby);
		if(results.hasErrors()){
			ModelAndView modelandview = new ModelAndView("AdmissionForm");
			return modelandview;

		}
		ModelAndView modelandview = new ModelAndView("AdmissionSuccess");
//		modelandview.addObject("msg", "Student Record");
//		modelandview.addObject("student1", student1);
//  	ModelAndView modelandview = new ModelAndView("AdmissionSuccess");
	//	modelandview.addObject("msg", "name "+name+"hobby "+hobby);
		return modelandview;
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Exception e){
		
		System.out.println(e);
		
		return "NullPointerException";//this is NullPointerException.jsp name
	}

}
