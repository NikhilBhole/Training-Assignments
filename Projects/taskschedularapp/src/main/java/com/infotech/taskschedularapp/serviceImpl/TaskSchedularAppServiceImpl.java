package com.infotech.taskschedularapp.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.taskschedularapp.dao.TaskSchedularAppDao;
import com.infotech.taskschedularapp.domain.Task;
import com.infotech.taskschedularapp.domain.User;
import com.infotech.taskschedularapp.exception.CustomNullPointerException;
import com.infotech.taskschedularapp.service.TaskSchedularAppService;

@Service("service")
public class TaskSchedularAppServiceImpl implements TaskSchedularAppService {
	
	@Autowired
	public TaskSchedularAppDao dao;

	public TaskSchedularAppDao getDao() {
		return dao;
	}

	public void setDao(TaskSchedularAppDao dao) {
		this.dao = dao;
	}

	public int userRegistration(User user) throws CustomNullPointerException {
		int value=0;
		
			value = dao.registerUser(user);
		
		return value;
	}

	public User userLogin(String loginType, String loginname) {
		User user = null;
		try {
			user = dao.loginUser(loginType, loginname);
		} catch (CustomNullPointerException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	public int insertTask(Task task) {
		Integer returnvalue = 0;
		try {
			returnvalue = dao.addTask(task);
		} catch (CustomNullPointerException e) {
			System.out.println(e.getMessage());
		}
		return returnvalue;
	}

	public List<Task> listAllTask(Integer userid) {
		List<Task> tasks = new ArrayList<Task>();
		tasks = dao.listTask(userid);
		return tasks;
	}

	public Task searchTaskByTitle(String title) {
		
		return dao.searchTask(title);
	}

	public List<Task> filterTaskByStatus(Integer status) {
		return null;
	}

	public int updateTaskByStatus(Integer status) {
		return 0;
	}

}
