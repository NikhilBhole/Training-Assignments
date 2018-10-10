package com.yash.springwithhibernate.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.springwithhibernate.dao.EmployeeDao;
import com.yash.springwithhibernate.model.Employee;
import com.yash.springwithhibernate.service.EmployeeService;

@Service("service")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	public EmployeeDao getDao() {
		return dao;
	}

	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}

	public int addEmployee(Employee employee) {
		return dao.addEmployee(employee);
	}

	public List<Employee> getEmployees() {
		return dao.getEmployees();
	}

	public Employee getEmployee(int id) {
		return dao.getEmployee(id);
	}

}
