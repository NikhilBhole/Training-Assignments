package com.erp.employeedetails.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.employeedetails.dao.EmployeeDetailsDao;
import com.erp.employeedetails.model.Employee;
import com.erp.employeedetails.service.EmployeeDetailsService;

@Service("service")
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {
	
	@Autowired
	private EmployeeDetailsDao dao;
	
	public EmployeeDetailsDao getDao() {
		return dao;
	}

	public void setDao(EmployeeDetailsDao dao) {
		this.dao = dao;
	}

	public List<Employee> getEmployees() {

		return dao.getAllEmployee();
	}

	public int addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("in service= "+employee);
		return dao.addEmployee(employee);
	}

	public int deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(id);
	}

	public int updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(employee);
	}

	public Employee getEmployee(Integer id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

}
