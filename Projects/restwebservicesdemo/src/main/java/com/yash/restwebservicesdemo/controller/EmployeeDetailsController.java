package com.yash.restwebservicesdemo.controller;

import java.util.List;

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

import com.yash.restwebservicesdemo.domain.Employee;
import com.yash.restwebservicesdemo.service.EmployeeDetailsService;



@RestController
@RequestMapping(value="/employee")
public class EmployeeDetailsController {
	
	@Autowired
	private EmployeeDetailsService service;

	public EmployeeDetailsService getService() {
		return service;
	}

	public void setService(EmployeeDetailsService service) {
		this.service = service;
	}
	
	@GetMapping
	@RequestMapping(value="/employees.ds", method=RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployees(){
 		return new ResponseEntity<List<Employee>>(service.getEmployees(), HttpStatus.OK);
	}
		
	@GetMapping
	@RequestMapping(value="/{id}.ds", produces="application/json")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id){
		Employee employee = service.getEmployee(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);	
	}
	
	@DeleteMapping
	@RequestMapping(value="/{id}.ds")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Integer id) {
		Integer returnvalue = service.deleteEmployee(id);
		if(returnvalue == 0) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_IMPLEMENTED);
		}else {
			return new ResponseEntity<Employee>(HttpStatus.OK);
		}
	}
	
	@PostMapping
	@RequestMapping(value="/add.ds", consumes="application/json")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		System.out.println("in controller"+ employee);
		int returnvalue = service.addEmployee(employee);
		if(returnvalue == 0) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_IMPLEMENTED);
		}else {
			return new ResponseEntity<Employee>(HttpStatus.CREATED);
		}
		
	}
	
	@PutMapping
	@RequestMapping(value="/update.ds", consumes="application/json")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		System.out.println("employee= "+ employee);
		int returnvalue = service.updateEmployee(employee);
		if(returnvalue == 0) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_MODIFIED);
		}else {
			return new ResponseEntity<Employee>(HttpStatus.OK);
		}
		
	}

}
