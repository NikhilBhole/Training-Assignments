package com.yash.springwithhibernate.dao;

import java.util.List;

import com.yash.springwithhibernate.model.Employee;

public interface EmployeeDao {

	public int addEmployee(Employee employee);
	public List<Employee> getEmployees();
	public Employee getEmployee(int id);
}
