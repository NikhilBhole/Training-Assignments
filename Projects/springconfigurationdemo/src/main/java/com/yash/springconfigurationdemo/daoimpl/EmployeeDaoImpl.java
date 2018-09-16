package com.yash.springconfigurationdemo.daoimpl;

import org.springframework.stereotype.Repository;

import com.yash.springconfigurationdemo.dao.EmployeeDao;

@Repository("dao")
public class EmployeeDaoImpl implements EmployeeDao {

	public EmployeeDaoImpl() {
		System.out.println("EmployeeDaoImpl called....");
	}
}
