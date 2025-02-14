package com.shankar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringMsProj6SpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsProj6SpringCloudConfigServerApplication.class, args);
	}

}
