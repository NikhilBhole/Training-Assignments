package org.yash.springbootdemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hellooo";
	}
	
	
	/*public List<Employee> getAllEmployees(){
		
	}*/

}
