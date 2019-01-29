package com.yash.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.dao.MessageSenderDao;
import com.yash.model.Message;

@Repository("messageSenderDao")
public class MessageSenderDaoImpl implements MessageSenderDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public MessageSenderDaoImpl() {
		System.out.println("MessageSenderDaoImpl called...");
	}
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addMessage(Message message) {		
		sessionFactory.openSession().save(message);
	}

}
