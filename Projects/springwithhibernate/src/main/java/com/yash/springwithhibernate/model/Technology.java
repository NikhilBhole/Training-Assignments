package com.yash.springwithhibernate.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="technology")
public class Technology {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int techId;
	private String techName;
	
	@ManyToMany(mappedBy="technologies")
	private Set<Employee> employees;
	
	public Technology() {}

	public Technology(int techId, String techName, Set<Employee> employees) {
		super();
		this.techId = techId;
		this.techName = techName;
		this.employees = employees;
	}

	public int getTechId() {
		return techId;
	}

	public void setTechId(int techId) {
		this.techId = techId;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Technology [techId=" + techId + ", techName=" + techName + ", employees=" + employees + "]";
	}
	
	
	
}
