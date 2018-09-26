package com.yash.springboot.dao;

import java.util.List;

import com.yash.springboot.model.Employee;

public interface EmployeeDao {

	public String getTest();
	public int addEmployee(Employee employee);
	public int deleteEmployee(Integer id);
	public int updateEmployee(Employee employee);
	public List<Employee> getEmployeeList();
	public Employee getEmployeeById(Integer id);
}
