package com.yash.restwebservicesdemo.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yash.restwebservicesdemo.dao.EmployeeDetailsDao;
import com.yash.restwebservicesdemo.domain.Employee;
import com.yash.restwebservicesdemo.rowmapper.EmployeeRowMapper;



@Repository("dao")
public class EmployeeDetailsDaoImpl implements EmployeeDetailsDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<Employee>();
		String sql = "select * from employees";
		list = jdbcTemplate.query(sql, new EmployeeRowMapper());
		return list;
	}

	public int addEmployee(Employee employee) {
		String sql = "insert into employees(name, designation) values(?,?)";
		int returnvalue = jdbcTemplate.update(sql, new Object[]{employee.getName(), employee.getDesignation()});
		return returnvalue;
		
	}

	public int deleteEmployee(Integer id) {
		String sql = "delete from employees where id=?";
		int returnvalue = jdbcTemplate.update(sql, id);
		return returnvalue;
		
	}

	public int updateEmployee(Employee employee) {
		String sql = "update employees set name=?, designation=? where id=?";
		int returnvalue = jdbcTemplate.update(sql, new Object[]{employee.getName(), employee.getDesignation(), employee.getId()});
		return returnvalue;		
		
	}

	public Employee getById(Integer id) {
		Employee employee = new Employee();
		String sql = "select * from employees where id=?";
		employee = (Employee) jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
		return employee;
		
	}

}
