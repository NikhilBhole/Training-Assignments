package com.infotech.taskschedularapp.domain;

public class User {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String contact;
	private String address;
	private String loginName;
	private String password;
	private Integer status;    //1:active 2:inactive
	private Integer role;      //1:admin 2:general user
	
	public User() {}
	
	public User(String firstName, String lastName, String email, String contact, String address, String loginName,
			String password, Integer role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.loginName = loginName;
		this.password = password;
		this.role = role;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	
	

}
