package com.yash.springconfigurationdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.springconfigurationdemo.service.EmployeeService;

@RestController
@RequestMapping(value="/user")
public class EmployeeController {
	
	@Autowired
	private EmployeeService ser;

	public EmployeeController() {
		System.out.println("EmployeeController called.....");
	}
	
	@RequestMapping(value="/hi.ds")
	public String demo() {
		return "ayaa....done bhai";
		
	}
}
