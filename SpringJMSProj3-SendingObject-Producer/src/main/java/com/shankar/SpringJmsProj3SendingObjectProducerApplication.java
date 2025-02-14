package com.shankar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringJmsProj3SendingObjectProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJmsProj3SendingObjectProducerApplication.class, args);
	}

}
