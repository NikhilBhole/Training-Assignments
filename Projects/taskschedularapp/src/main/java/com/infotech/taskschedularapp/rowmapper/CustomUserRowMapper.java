package com.infotech.taskschedularapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.infotech.taskschedularapp.domain.User;

public class CustomUserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
	    user.setId(rs.getInt(1));
	    user.setFirstName(rs.getString(2));
	    user.setLastName(rs.getString(3));
	    user.setEmail(rs.getString(4));
	    user.setContact(rs.getString(5));
	    user.setAddress(rs.getString(6));
	    user.setLoginName(rs.getString(7));
	    user.setPassword(rs.getString(8));
	    user.setRole(rs.getInt(9));
	    user.setStatus(rs.getInt(10));
		
		return user;
	}
	

}
