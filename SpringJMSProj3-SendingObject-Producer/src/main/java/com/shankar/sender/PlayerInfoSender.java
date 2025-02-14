package com.shankar.sender;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.shankar.model.PlayerInfo;
@Component
public class PlayerInfoSender{
@Autowired
private JmsTemplate template; 
@Scheduled(cron="0/20 * * * * *")
public void sendData() {
	PlayerInfo pinfo=new PlayerInfo("PYCS123","Shankar Reddy","Chennai Super Kings");
	template.convertAndSend("obj_mq1",pinfo);
	System.out.println("Object Send as Message");
}
}
