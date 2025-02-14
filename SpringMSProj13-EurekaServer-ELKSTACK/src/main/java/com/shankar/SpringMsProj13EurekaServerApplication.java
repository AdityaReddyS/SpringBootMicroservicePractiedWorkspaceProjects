package com.shankar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class SpringMsProj13EurekaServerApplication {

	public static void main(String[] args) {
		log.info("Eureka server is boot strapped");
		SpringApplication.run(SpringMsProj13EurekaServerApplication.class, args);
		log.info("Eureka Server is Stopped after execution");
	}

}
