package com.shankar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringMsProj16EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsProj16EurekaServerApplication.class, args);
	}

}
