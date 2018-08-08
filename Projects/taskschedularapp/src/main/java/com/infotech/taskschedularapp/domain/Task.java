package com.infotech.taskschedularapp.domain;

import java.util.Date;

public class Task {
	
	private Integer id;
	private Integer userId;
	private String title;
	private String description;
	private String startDate;
	private String endDate;
	private Integer status;   // 1:completed 2:pending 3:not started
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", userId=" + userId + ", title=" + title + ", description=" + description
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + "]";
	}
 	
	
}
