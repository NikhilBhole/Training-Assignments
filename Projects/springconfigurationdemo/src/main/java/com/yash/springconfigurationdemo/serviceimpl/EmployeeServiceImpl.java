package com.yash.springconfigurationdemo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.springconfigurationdemo.dao.EmployeeDao;
import com.yash.springconfigurationdemo.service.EmployeeService;

@Service("ser")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao dao;

	public EmployeeServiceImpl() {
		System.out.println("EmployeeServiceImpl called.....");
	}
}
