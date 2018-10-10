package com.yash.springwithhibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.springwithhibernate.model.Employee;
import com.yash.springwithhibernate.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	public EmployeeService getService() {
		return service;
	}

	public void setService(EmployeeService service) {
		this.service = service;
	}
	
	@GetMapping
	@RequestMapping(value="/test")
	public String test() {
		return "done";
	}
	
	@PostMapping
	@RequestMapping(value="/add")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		System.out.println("in employee controller : "+employee);
		int result = service.addEmployee(employee);
		if(result > 0) {
			return new ResponseEntity<String>("chala bhai", HttpStatus.OK) ;
		}
		else {
			return new ResponseEntity<String>("nahi chala", HttpStatus.NOT_IMPLEMENTED);
		}
	}
	
	@GetMapping
	@RequestMapping(value="/getEmployees", produces="application/json")
	public List<Employee> getEmployeeList(){
		List<Employee> empList = service.getEmployees();
		System.out.println("in controller : "+empList);
		return empList;
	}
	
	@GetMapping
	@RequestMapping(value="/getEmployee/{id}", produces="application/json")
	public Employee getEmployee(@PathVariable("id") int id) {
		return service.getEmployee(id);
		
	}
}
