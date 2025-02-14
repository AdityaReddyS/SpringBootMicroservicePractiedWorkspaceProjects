package com.shankar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringMsProj8SpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsProj8SpringCloudConfigServerApplication.class, args);
	}

}
