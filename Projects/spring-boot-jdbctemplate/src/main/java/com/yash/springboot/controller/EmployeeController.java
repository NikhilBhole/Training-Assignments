package com.yash.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.springboot.model.Employee;
import com.yash.springboot.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService ser;

	public EmployeeController() {
		System.out.println("EmployeeController called.....");
	}
	
	@RequestMapping(value="/getdata", method= RequestMethod.GET)
	public String demo() {	
		return ser.getTest();	
	}
	
	@GetMapping
	@RequestMapping(value="/getEmployees", produces="application/json")
	public ResponseEntity<List<Employee>> getEmployees() {
		
		return new ResponseEntity<List<Employee>>(ser.getEmployeeList(), HttpStatus.OK);
		
	}
	
	@GetMapping
	@RequestMapping(value="/getEmployee/{id}", produces="application/json")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
		
		return new ResponseEntity<Employee>(ser.getEmployeeById(id), HttpStatus.OK);
	}
	
	@PostMapping
	@RequestMapping(value="/add", consumes="application/json")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		int result = ser.addEmployee(employee);
		if(result>0) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@PutMapping
	@RequestMapping(value="/update", consumes="application/json")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		int result = ser.updateEmployee(employee);
		if(result>0) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@DeleteMapping
	@RequestMapping(value="/delete/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id){
		int result = ser.deleteEmployee(id);
		if(result>0) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	
	@GetMapping
	@RequestMapping(value="/{empid}")
	public AddressController getAddressController(@PathVariable int empid){
		
		return new AddressController();
	}	
}
