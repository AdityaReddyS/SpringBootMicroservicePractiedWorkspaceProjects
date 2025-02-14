package com.shankar.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;






@Component
public class ActiveMqMessagesender  {
	@Autowired
	private JmsTemplate template;

	
	@Scheduled(cron = "*/10 * * * * *")
	public void run() {
		template.send("testmq1", ses->ses.createTextMessage("From Sender App:::"+new Date()));
		System.out.println("Message Sent");
	}
	
	
	

}
