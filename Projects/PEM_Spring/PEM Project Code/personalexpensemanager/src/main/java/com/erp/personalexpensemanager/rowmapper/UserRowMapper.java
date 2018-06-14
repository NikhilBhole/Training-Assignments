package com.erp.personalexpensemanager.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.erp.personalexpensemanager.model.User;

/**
 * this is row mapper class of user which implements RowMapper interface.
 * this class is used to get user object from database of user.
 * also implement maprow method.
 * @author Nikhil
 *
 */
public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt(1));
		user.setName(rs.getString(2));
		user.setLoginName(rs.getString(3));
		user.setPassword(rs.getString(4));
		return user;
	}

}
