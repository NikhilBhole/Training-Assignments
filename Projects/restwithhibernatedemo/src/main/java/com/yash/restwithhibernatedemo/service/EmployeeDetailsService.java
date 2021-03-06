package com.yash.restwithhibernatedemo.service;

import java.util.List;

import com.yash.restwithhibernatedemo.domain.Employee;

public interface EmployeeDetailsService {
	
	public List<Employee> getEmployees();
	public int addEmployee(Employee employee);
	public int deleteEmployee(Integer id);
	public int updateEmployee(Employee employee);
	public Employee getEmployee(Integer id);

}
