package com.yash.restwithhibernatedemo.daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.yash.restwithhibernatedemo.dao.EmployeeDetailsDao;
import com.yash.restwithhibernatedemo.domain.Employee;



@Repository("dao")
public class EmployeeDetailsDaoImpl implements EmployeeDetailsDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<Employee>();
		list = hibernateTemplate.loadAll(Employee.class);		
		System.out.println("In Dao :  ");
		for (Employee employee : list) {
			System.out.println(employee);
		}
		return list;		
	}

	public int addEmployee(Employee employee) {
		
		
		employee.setId(15);
		System.out.println("in dao : "+ employee);
		try{
			hibernateTemplate.save(employee);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return 1;
	}

	public int deleteEmployee(Integer id) {
		return id;
		
		
	}

	public int updateEmployee(Employee employee) {
		return 0;
		
		
	}

	public Employee getById(Integer id) {
		return null;
		
		
	}

}
