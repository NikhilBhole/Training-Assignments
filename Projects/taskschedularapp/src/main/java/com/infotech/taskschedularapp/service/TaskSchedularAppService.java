package com.infotech.taskschedularapp.service;

import java.util.List;

import com.infotech.taskschedularapp.domain.Task;
import com.infotech.taskschedularapp.domain.User;
import com.infotech.taskschedularapp.exception.CustomNullPointerException;

/**
 * this is a TaskSchedularAppService interface which implements by TaskSchedularAppServiceImpl class
 * @author swaraj
 * @author akshay
 */
public interface TaskSchedularAppService {
	
	/**
	 * this method are use for register user 
	 * @param user
	 * @return Integer 1-inserted,0-fail inserted
	 * @throws CustomNullPointerException if user has null value
	 * @author Swaraj
	 */
	public int userRegistration(User user) throws CustomNullPointerException;
	
	/**
	 * this method use for login user
	 * @param loginType (BY- username or email-id)
	 * @param loginName (login Name)
	 * @return user
	 * @throws CustomNullPointerException if loginType has null value
	 * @author Swaraj
	 */
	public User userLogin(String loginType, String loginname);
	
	/**
	 * this method use for add user task in database
	 * @param task
	 * @return Integer 1-inserted,0-fail inserted
	 * @throws CustomNullPointerException if task has null value
	 * @author Akshay
	 */
	public int insertTask(Task task);
	
	/**
	 * this method use to get list of all tasks of user from database
	 * @param userid
	 * @return list of task
	 * @throws CustomNullPointerException if task has null value
	 * @author akshay
	 */
	List<Task> listAllTask(Integer userid);
	
	/**
	 * this method use to get one tasks of user from database
	 * @param title
	 * @return list of task
	 * @throws CustomNullPointerException if title has null value
	 * @author Akshay
	 */
	Task searchTaskByTitle(String title);
	
	/**
	 * this method use to get list tasks of user on the basis of pending or completed status from database
	 * @param status
	 * @return list of task
	 * @throws CustomNullPointerException if status has null value
	 * @author Akshay
	 */
	List<Task> filterTaskByStatus(Integer status);
	
	/**
	 * this method use to update tasks of user
	 * @param status
	 * @return Integer 1-updated,0-failed
	 * @throws CustomNullPointerException if status has null value
	 * @author Akshay
	 */
	int updateTaskByStatus(Integer status);

}
