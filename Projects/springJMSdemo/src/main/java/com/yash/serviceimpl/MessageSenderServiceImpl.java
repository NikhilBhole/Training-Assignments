package com.yash.serviceimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.dao.MessageSenderDao;
import com.yash.model.MessageSender;
import com.yash.service.MessageSenderService;

@Service("messageSenderService")
@Transactional
public class MessageSenderServiceImpl implements MessageSenderService {
	
	@Autowired
	private MessageSender messageSender;
	
	@Autowired
	private MessageSenderDao messageSenderDao;
	
	public MessageSenderServiceImpl() {
		System.out.println("MessageSenderServiceImpl called...");
	}

	public MessageSender getMessageSender() {
		return messageSender;
	}

	public void setMessageSender(MessageSender messageSender) {
		this.messageSender = messageSender;
	}
	
	public void sendMessage(final String messageText) {
		
		System.out.println("in MessageSenderServiceImpl message : "+messageText);
		
		messageSender.getJmsTemplate().send(messageSender.getDestination(), new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				
				com.yash.model.Message message = messageSender.getMessage();
				message.setMessage(messageText);
				message.setMessageType("send");
				message.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
				messageSenderDao.addMessage(message);
				System.out.println("sent and tranfered to dao layer");
				return session.createTextMessage(messageText);
			}
		});
	}
	

}
