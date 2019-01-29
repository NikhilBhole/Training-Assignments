package com.yash.service;

import javax.jms.JMSException;

public interface MessageRecieverService {
	
	public String recieveMessage() throws JMSException;

}
