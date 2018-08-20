package com.yash.restwithhibernatedemo.dao;

import java.util.List;

import com.yash.restwithhibernatedemo.domain.Employee;



public interface EmployeeDetailsDao {
	
	public List<Employee> getAllEmployee();
	public int addEmployee(Employee employee);
	public int deleteEmployee(Integer id);
	public int updateEmployee(Employee employee);
	public Employee getById(Integer id);

}
