package com.yash.springwithhibernate.service;

import java.util.List;

import com.yash.springwithhibernate.model.Employee;

public interface EmployeeService {
	
	public int addEmployee(Employee employee);
	public List<Employee> getEmployees();
	public Employee getEmployee(int id);

}
