package com.yash.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.jms.JMSException;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yash.service.MessageRecieverService;
import com.yash.service.MessageSenderService;

@Controller
@RequestMapping(value="/message")
public class MessageController {

	@Autowired
	private MessageSenderService messageSenderService;
	
	@Autowired
	private MessageRecieverService messageRecieverService;
	
	public MessageController() {
		System.out.println("MessageController called...");
	}
	
	public MessageSenderService getMessageSenderService() {
		return messageSenderService;
	}


	public void setMessageSenderService(MessageSenderService messageSenderService) {
		this.messageSenderService = messageSenderService;
	}


	public MessageRecieverService getMessageRecieverService() {
		return messageRecieverService;
	}


	public void setMessageRecieverService(MessageRecieverService messageRecieverService) {
		this.messageRecieverService = messageRecieverService;
	}


	@GetMapping(value="/send")
	public String sendMessage() throws URISyntaxException, Exception {
		String messageText = "I am fine. what about you?";
		BrokerService broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61161)")); 
		broker.start(); 
		messageSenderService.sendMessage(messageText);
		String result = recieveMessage(messageText);
		broker.stop();
		if(result == "failed") {
			return "error";
		}
		else {
			return "sent";						
		}
	}
	
	private String recieveMessage(String messageText) {
		String result = null;
		try {
			result = messageRecieverService.recieveMessage();
			System.out.println(result);
			return result;
		} catch (JMSException e) {
			
			return "failed";
		}
		
		
	}
	
	
}
