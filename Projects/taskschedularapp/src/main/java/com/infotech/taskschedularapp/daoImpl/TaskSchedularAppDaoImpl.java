package com.infotech.taskschedularapp.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.infotech.taskschedularapp.dao.TaskSchedularAppDao;
import com.infotech.taskschedularapp.domain.Task;
import com.infotech.taskschedularapp.domain.User;
import com.infotech.taskschedularapp.exception.CustomNullPointerException;
import com.infotech.taskschedularapp.rowmapper.CustomUserRowMapper;
import com.infotech.taskschedularapp.rowmapper.CustomeTaskRowMapper;


@Repository("dao")
public class TaskSchedularAppDaoImpl implements TaskSchedularAppDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int registerUser(User user) throws CustomNullPointerException {
		
		if(user==null) {
			throw new CustomNullPointerException("user having no values");
		}		
		
		else {
			String sql = "insert into user(firstname, lastname, email, contact, address, username, password) values(?,?,?,?,?,?,?)";
			int i = jdbcTemplate.update(sql, new Object[] {user.getFirstName(), user.getLastName(), user.getEmail(), user.getContact(), user.getAddress(), user.getLoginName(), user.getPassword()});
			if(i>0) {
				System.out.println("inserted....");
			}
			
			return i;
		}
	}

	public User loginUser(String loginType, String loginName) throws CustomNullPointerException {

		String sql=null;
		User user = null;
		
		if(loginType.isEmpty() || loginName.isEmpty()) {
			throw new CustomNullPointerException("field is empty");
		}
		else {
			
			if(loginType.equals("username")) {
				sql = "select * from user where username = ?";
				user = new User();
				user=jdbcTemplate.queryForObject(sql, new CustomUserRowMapper(), loginName);
			}
			else {
				sql = "select * from user where email = ?";
				user = new User();
				user=jdbcTemplate.queryForObject(sql, new CustomUserRowMapper(), loginName);
			}
			return user;
		}
		
	}

	public int addTask(Task task) throws CustomNullPointerException {
		if(task==null) {
			throw new CustomNullPointerException("user having no values");
		}		
		
		else {
			String sql = "insert into task(user_id, title, description, startDate, endDate) values(?,?,?,?,?)";
			int i = jdbcTemplate.update(sql, new Object[] {task.getUserId(), task.getTitle(), task.getDescription(), task.getStartDate(), task.getEndDate()});
			if(i>0) {
				System.out.println("inserted....");
			}
			
			return i;
		}
	}

	public List<Task> listTask(Integer userid) {
		List<Task> tasks = new ArrayList<Task>();
		String sql = "select * from task where user_id = ?";
		tasks = jdbcTemplate.query(sql, new CustomeTaskRowMapper(), userid);
		return tasks;
	}

	public Task searchTask(String title) {
		String sql = "select * from task where title = ?";
		Task task = new Task();
		task = jdbcTemplate.queryForObject(sql, new CustomeTaskRowMapper(), title);
		
		return task;
	}

	public List<Task> filterTask(Integer status) {
		return null;
	}

	public int updateTask(Integer status) {
		return 0;
	}

}
