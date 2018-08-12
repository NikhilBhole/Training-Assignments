package com.nikhil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloControllerAnno {
	@RequestMapping("/welcome/{countryname}/{username}")
	public ModelAndView helloWorld(@PathVariable("countryname") String country, @PathVariable("username") String name){
	
		ModelAndView modelandview = new ModelAndView("HelloPage");
		modelandview.addObject("massage", "this is first MVC using annotation "+country+" "+name);
		
		return modelandview;
	}

}
