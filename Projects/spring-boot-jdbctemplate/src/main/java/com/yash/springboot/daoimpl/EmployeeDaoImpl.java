package com.yash.springboot.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yash.springboot.dao.EmployeeDao;
import com.yash.springboot.model.Employee;

@Repository("dao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	/*@Autowired
	private JdbcTemplate jdbcTemplate;	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public EmployeeDaoImpl() {
		System.out.println("EmployeeDaoImpl called....");
	}
	
	public String getTest() {
		System.out.println("chala bhai......");
		
		return "done";
	}

	@Override
	public int addEmployee(Employee employee) {
		int result = 0;
		try {
			sessionFactory.openSession().save(employee);
			result = 1;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			result = 0 ;
		}
		return result;
	}

	@Override
	public int deleteEmployee(Integer id) {
		int result = 0;
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.delete(getEmployeeById(id));
			session.getTransaction().commit();
			result = 1;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			result = 0 ;
		}
		return result;
	}

	@Override
	public int updateEmployee(Employee employee) {
		int result = 0;
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.update(employee);
			session.getTransaction().commit();
			result = 1;			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			result = 0;
		}
		return result;
	}

	@Override
	public List<Employee> getEmployeeList() {
		return sessionFactory.openSession().createQuery("from Employee").list();
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return sessionFactory.openSession().get(Employee.class, id);
	}
}
