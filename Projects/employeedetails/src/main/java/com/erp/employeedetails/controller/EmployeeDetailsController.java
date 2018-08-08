package com.erp.employeedetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.erp.employeedetails.model.Employee;
import com.erp.employeedetails.service.EmployeeDetailsService;

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
	
	@RequestMapping(value="/employees.ds", method=RequestMethod.GET)
	public List<Employee> getEmployees(){
		
 	//	return new ResponseEntity(service.getEmployees(), HttpStatus.OK);
 		return service.getEmployees();
	}
	
	
	@RequestMapping(value="/{id}.ds", method=RequestMethod.GET)
	public Employee getEmployee(@PathVariable("id") Integer id) {
		System.out.println("id= "+id);
		return service.getEmployee(id);
	}
	
	@RequestMapping(value="/delete/{id}.ds", method=RequestMethod.GET)
	public int deleteEmployee(@PathVariable("id") Integer id) {
		Integer returnvalue = service.deleteEmployee(id);
		if(returnvalue == 0) {
			return 0;
		}else {
			return returnvalue;
		}
	}
	
	@RequestMapping(value="/add/{id}/{name}/{designation}.ds", method=RequestMethod.GET)
	public int addEmployee(@PathVariable("id") Integer id, @PathVariable("name") String name, @PathVariable("designation") String designation) {
		System.out.println("employee= "+id+" "+name+" "+designation);
		int returnvalue = service.addEmployee(new Employee(id, name, designation));
		if(returnvalue == 0) {
			return 0;
		}else {
			return returnvalue;
		}
		
	}
	
	@RequestMapping(value="/update/{id}/{name}/{designation}.ds", method=RequestMethod.GET)
	public int updateEmployee(@PathVariable("id") Integer id, @PathVariable("name") String name, @PathVariable("designation") String designation) {
		System.out.println("employee= "+id+" "+name+" "+designation);
		int returnvalue = service.updateEmployee(new Employee(id, name, designation));
		if(returnvalue == 0) {
			return 0;
		}else {
			return returnvalue;
		}
		
	}

}
