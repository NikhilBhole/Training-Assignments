package com.yash.springwithhibernate.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employeeId")
	private int employeeId;
	private String name;
	private String designation;
	
	@OneToOne(cascade=CascadeType.ALL)
	private AdharCardNumber adharCardNumber;
	
	@OneToMany(mappedBy="employee")
	private List<Address> address;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Employee_Technology",joinColumns= {@JoinColumn(referencedColumnName="employeeId")},inverseJoinColumns= {@JoinColumn(referencedColumnName="techId")})
	private Set<Technology> technologies;
	
	public Employee() {	}

	public Employee(int employeeId, String name, String designation, AdharCardNumber adharCardNumber, List<Address> address, Set<Technology> technologies) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.designation = designation;
		this.adharCardNumber = adharCardNumber;
		this.address = address;
		this.technologies = technologies;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Set<Technology> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(Set<Technology> technologies) {
		this.technologies = technologies;
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

	public AdharCardNumber getAdharCardNumber() {
		return adharCardNumber;
	}

	public void setAdharCardNumber(AdharCardNumber adharCardNumber) {
		this.adharCardNumber = adharCardNumber;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", designation=" + designation
				+ ", adharCardNumber=" + adharCardNumber + ", address=" + address + ", technologies=" + technologies
				+ "]";
	}

	
}
