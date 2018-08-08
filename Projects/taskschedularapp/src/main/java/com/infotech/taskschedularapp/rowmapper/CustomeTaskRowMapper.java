package com.infotech.taskschedularapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.infotech.taskschedularapp.domain.Task;

public class CustomeTaskRowMapper implements RowMapper<Task>{

	public Task mapRow(ResultSet rs, int rownum) throws SQLException {
		Task task = new Task();
		task.setId(rs.getInt(1));
		task.setUserId(rs.getInt(2));
		task.setTitle(rs.getString(3));
		task.setDescription(rs.getString(4));
		task.setStartDate(rs.getString(5));
		task.setEndDate(rs.getString(6));
		task.setStatus(rs.getInt(7));
	 	   
	   return task;
	}

}
