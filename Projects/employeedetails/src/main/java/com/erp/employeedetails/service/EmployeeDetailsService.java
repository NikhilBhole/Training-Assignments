package com.erp.employeedetails.service;

import java.util.List;

import com.erp.employeedetails.model.Employee;

public interface EmployeeDetailsService {
	
	public List<Employee> getEmployees();
	public int addEmployee(Employee employee);
	public int deleteEmployee(Integer id);
	public int updateEmployee(Employee employee);
	public Employee getEmployee(Integer id);

}
