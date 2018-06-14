package com.erp.personalexpensemanager.model;

/**
 * This is a POJO class for users
 * @author Nikhil Bhole
 *
 */
public class User {
	
	/**
	 * User ID
	 * auto-generated in Database
	 */
	private int id;
	
	/**
	 * User Name
	 */
	private String name;
	
	/**
	 * User Login Name
	 */
	private String loginName;
	
	/**
	 * User Password
	 */
	private String password;
	
	public User() {	}
	
	
	public User(int id, String name, String loginName, String password) {
		super();
		this.id = id;
		this.name = name;
		this.loginName = loginName;
		this.password = password;
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


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", loginName=" + loginName + ", password=" + password + "]";
	}
	
	
	
	

}
