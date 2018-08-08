package com.erp.employeedetails.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.erp.employeedetails.dao.EmployeeDetailsDao;
import com.erp.employeedetails.model.Employee;

@Repository("dao")
public class EmployeeDetailsDaoImpl implements EmployeeDetailsDao {

	List<Employee> list = new ArrayList<Employee>();
	
	public List<Employee> getAllEmployee() {
		
		list.add(new Employee(101,"nikhil","developer"));
		list.add(new Employee(102,"santosh","tester"));
		list.add(new Employee(103,"swaraj","trainer"));
		return list;
	}

	public int addEmployee(Employee employee) {
		System.out.println("int dao= "+employee);
		list.add(employee);
		if(list.contains(employee)) {
			return 1;
		}else {
			return 0;
		}
	}

	public int deleteEmployee(Integer id) {
		for (Employee employee : list) {
			if(id.equals(employee.getId())) {
				list.remove(employee);
				return 1;
			}
		}
		return 0;
	}

	public int updateEmployee(Employee employee) {
		
		for (Employee emp : list) {
			if(employee.getId().equals(emp.getId())) {
				emp.setName(employee.getName());
				emp.setDesignation(employee.getDesignation());
				return 1;
			}
		}
		
		return 0;
	}

	public Employee getById(Integer id) {
		Employee emp = null;
		for (Employee employee : list) {
			if(id.equals(employee.getId())) {
				emp = employee;
			}
		}
		return emp;
		
	}

}
