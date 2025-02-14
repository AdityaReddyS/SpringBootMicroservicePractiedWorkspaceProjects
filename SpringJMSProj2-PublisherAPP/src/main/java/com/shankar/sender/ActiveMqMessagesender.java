package com.shankar.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;






@Component
public class ActiveMqMessagesender  implements CommandLineRunner{
	@Autowired
	private JmsTemplate template;

	
	
	
	
	@Override
	public void run(String ...args)throws Exception  {
		//using anonymous style
		/*template.send("testmq1",new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message message=session.createTextMessage("From Sender App:::"+new Date());
				System.out.println("Message Sent");
				return message;
			}
		});*/
		//using lambda style anonymous inner class
		/*template.send("testmq1", ses->{
			return ses.createTextMessage("From Sender App::"+new Date());
		});
	*/
		//USING LAMBDA anonymous 
		template.send("topic1", ses->ses.createTextMessage("From Sender App:::"+new Date()));
		System.out.println("Message Sent");
	}

}
