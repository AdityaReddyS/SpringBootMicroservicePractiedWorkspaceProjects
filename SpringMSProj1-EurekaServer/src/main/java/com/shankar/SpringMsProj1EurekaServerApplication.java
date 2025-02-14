package com.shankar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringMsProj1EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsProj1EurekaServerApplication.class, args);
	}

}
