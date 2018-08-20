package com.yash.restwithhibernatedemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEES")
public class Employee {
	
	@Id @GeneratedValue
	private Integer id;
	private String name;
	private String designation;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(Integer id, String name, String designation) {
		this.id = id;
		this.name = name;
		this.designation = designation;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + "]";
	}
	
	

}
