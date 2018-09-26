package com.yash.springboot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="yashemployees")
public class Employee {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String task;
	private String assignedBy;
	private String status;
	@OneToMany(mappedBy="employee")
	private List<Address> addressList;
	
	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public Employee() {
		System.out.println("Employee called.....");
	}

	public Employee(int id, String name, String task, String assignedBy, String status) {
		super();
		this.id = id;
		this.name = name;
		this.task = task;
		this.assignedBy = assignedBy;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", task=" + task + ", assignedBy=" + assignedBy + ", status="
				+ status + "]";
	}

	
}
