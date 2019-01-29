package com.yash.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="messages")
@Component
public class Message {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int messageId;
	private String message;
	private String messageType;
	private String date;
	
	public Message() {
		System.out.println("Message called...");
	}

	public Message(int messageId, String message, String messageType, String date) {
		super();
		this.messageId = messageId;
		this.message = message;
		this.messageType = messageType;
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", message=" + message + ", messageType=" + messageType + ", date="
				+ date + "]";
	}

}
