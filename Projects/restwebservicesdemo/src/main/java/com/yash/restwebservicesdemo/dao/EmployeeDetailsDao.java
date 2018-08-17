package com.yash.restwebservicesdemo.dao;

import java.util.List;

import com.yash.restwebservicesdemo.domain.Employee;



public interface EmployeeDetailsDao {
	
	public List<Employee> getAllEmployee();
	public int addEmployee(Employee employee);
	public int deleteEmployee(Integer id);
	public int updateEmployee(Employee employee);
	public Employee getById(Integer id);

}
