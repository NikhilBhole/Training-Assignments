package com.erp.personalexpensemanager.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.erp.personalexpensemanager.dao.PEMDao;
import com.erp.personalexpensemanager.exception.CustomNullPointerException;
import com.erp.personalexpensemanager.model.User;
import com.erp.personalexpensemanager.rowmapper.UserRowMapper;

@Repository("userdao")
public class UserDaoImpl implements PEMDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public int addUser(User user) throws CustomNullPointerException {
		if(user == null) {
			throw new CustomNullPointerException("user having null values");
		}
		else {
			String sql = "insert into pemuser(name,username, password) values (?,?,?)";
			int result = jdbcTemplate.update(sql, new Object[] {user.getName(), user.getLoginName(), user.getPassword()});
			return result;
		}
	}
	
	public User loginUser(String username) throws CustomNullPointerException {
		User user = null;
		if(username.isEmpty()) {
			throw new CustomNullPointerException("username is empty");
		}
		else {
			String sql = "select * from pemuser where username=?";
			user = new User();
			user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), username);
			System.out.println("in dao"+user);
			return user;
		}
		
	}
}
