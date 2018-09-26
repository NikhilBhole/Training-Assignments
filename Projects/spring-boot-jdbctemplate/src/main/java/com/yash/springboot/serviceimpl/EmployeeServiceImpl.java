package com.yash.springboot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.springboot.dao.EmployeeDao;
import com.yash.springboot.model.Employee;
import com.yash.springboot.service.EmployeeService;


@Service("ser")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao dao;

	public EmployeeServiceImpl() {
		System.out.println("EmployeeServiceImpl called.....");
	}
	
	public String getTest() {
		return dao.getTest();
	}

	@Override
	public int addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return dao.addEmployee(employee);
	}

	@Override
	public int deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(id);
	}

	@Override
	public int updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(employee);
	}

	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		return dao.getEmployeeList();
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getEmployeeById(id);
	}
}
