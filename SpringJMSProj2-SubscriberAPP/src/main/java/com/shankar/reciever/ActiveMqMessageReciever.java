package com.shankar.reciever;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqMessageReciever  {
	
@JmsListener(destination = "topic1")
	public void readTextMessage(String text)  {
		System.out.println("Recieved Message::"+text);

	}

}
