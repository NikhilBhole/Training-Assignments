package com.yash.restwebservicesdemo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.restwebservicesdemo.domain.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getInt(1));
		employee.setName(rs.getString(2));
		employee.setDesignation(rs.getString(3));
		return employee;
	}

}
