package com.shankar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class SpringMsProj13EurekaServerConsumerMicroServiceApplication {

	public static void main(String[] args) {
		log.info("Eureka Server -Consumer Ms Is Started for Execution");
		SpringApplication.run(SpringMsProj13EurekaServerConsumerMicroServiceApplication.class, args);
		log.info("Eureka Server -Consumer Ms Is Stopped after  Execution");
	}

}
