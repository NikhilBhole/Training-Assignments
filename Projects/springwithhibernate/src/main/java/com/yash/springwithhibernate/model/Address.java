package com.yash.springwithhibernate.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressId;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	@ManyToOne
	@JoinColumn(name = "employeeId") 
	private Employee employee;
	
	public Address() {}

	public Address(int addressId, String addressLine1, String addressLine2, String city, String state, String country, Employee employee) {
		super();
		this.addressId = addressId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getId() {
		return addressId;
	}

	public void setId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city="
				+ city + ", state=" + state + ", country=" + country + "]";
	}


}
