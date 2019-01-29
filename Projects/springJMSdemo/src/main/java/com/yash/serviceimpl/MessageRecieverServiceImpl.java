package com.yash.serviceimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.dao.MessageRecieverDao;
import com.yash.model.Message;
import com.yash.model.MessageReciever;
import com.yash.service.MessageRecieverService;

@Service("messageRecieverService")
@Transactional
public class MessageRecieverServiceImpl implements MessageRecieverService {
	
	@Autowired
	private MessageReciever messageReciever;
	
	@Autowired
	private MessageRecieverDao messageRecieverDao;
	
	public MessageRecieverServiceImpl() {
		System.out.println("MessageRecieverServiceImpl called...");
	}

	public MessageReciever getMessageReciever() {
		return messageReciever;
	}

	public void setMessageReciever(MessageReciever messageReciever) {
		this.messageReciever = messageReciever;
	}
	
	public String recieveMessage() throws JMSException {
		
		TextMessage textMessage = (TextMessage) messageReciever.getJmsTemplate().receive(messageReciever.getDestination());
		String messageText = textMessage.getText();
		System.out.println("in recieve message method : "+messageText);
		Message message = messageReciever.getMessage();
		message.setMessage(messageText);
		message.setMessageType("recieved");
		message.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
		String result = messageRecieverDao.addMessage(message);
		return result+" meassage text: "+messageText;
	}

}
