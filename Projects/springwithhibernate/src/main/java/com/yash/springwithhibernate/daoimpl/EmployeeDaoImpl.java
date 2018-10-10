package com.yash.springwithhibernate.daoimpl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.yash.springwithhibernate.dao.EmployeeDao;
import com.yash.springwithhibernate.model.Address;
import com.yash.springwithhibernate.model.Employee;
import com.yash.springwithhibernate.model.Technology;

@Repository("dao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public int addEmployee(Employee employee) {
		System.out.println("in dao impl : "+employee);
		Session session =  sessionFactory.openSession();
		session.getTransaction().begin();
		int result = (Integer) session.save(employee);
		List<Address> addressList = employee.getAddress();
		for (Address address : addressList) {
			address.setEmployee(employee);
			session.save(address);
		}
		session.getTransaction().commit();
		return result;
	}

	public List<Employee> getEmployees() {
		sessionFactory.openSession().getTransaction().begin();
		List<Employee> empList = sessionFactory.openSession().createQuery("from Employee").list();
		System.out.println("in dao impl : "+empList);
		sessionFactory.openSession().getTransaction().commit();
		return empList;
	}

	public Employee getEmployee(int id) {
		return sessionFactory.openSession().get(Employee.class, id);
	}

}
