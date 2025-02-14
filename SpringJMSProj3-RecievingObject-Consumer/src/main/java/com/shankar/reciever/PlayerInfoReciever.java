package com.shankar.reciever;



import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.shankar.model.PlayerInfo;
@Component
public class PlayerInfoReciever{

	@JmsListener(destination = "obj_mq1")
	public void consumeDataAsMessage(PlayerInfo info) {
		System.out.println("Recieved Object Data::"+info);
	}
}
