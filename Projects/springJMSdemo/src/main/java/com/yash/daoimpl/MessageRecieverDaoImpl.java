package com.yash.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.dao.MessageRecieverDao;
import com.yash.model.Message;

@Repository("messageRecieverDao")
public class MessageRecieverDaoImpl implements MessageRecieverDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public MessageRecieverDaoImpl() {
		System.out.println("MessageRecieverDaoImpl called...");
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public String addMessage(Message message) {
		try {
			sessionFactory.openSession().save(message);		
			return "success";
		}
		catch(Exception e) {
			return "failed";
		}
	}

}
