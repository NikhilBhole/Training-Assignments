package com.yash.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.springboot.model.Address;
import com.yash.springboot.model.Employee;
import com.yash.springboot.service.EmployeeService;

@RestController
@RequestMapping(value="/address")
public class AddressController {
	
	@Autowired
	private EmployeeService ser;

	public AddressController() {
		System.out.println("AddressController called....");
	}
	
	@GetMapping
	@RequestMapping(value="/add")
	public String getAddress(@RequestBody Address address, @PathVariable("empid") int id){

		return "in address controller";
	}
	
	
}
