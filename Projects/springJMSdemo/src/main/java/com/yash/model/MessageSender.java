package com.yash.model;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component("messageSender")
public class MessageSender {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Destination destination;
	
	@Autowired
	private Message message;
	
	public MessageSender() {
		System.out.println("MessageSender called...");
	}
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
}
