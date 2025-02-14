package com.shankar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class SpringMsProj13EurekaServerProviderMicroServiceApplication {

	public static void main(String[] args) {
		log.info("Eureka Server-Provider MS is Started for execution");
		SpringApplication.run(SpringMsProj13EurekaServerProviderMicroServiceApplication.class, args);
		log.info("Eureka Server-Provider MS is Stopped after execution");
	}

}
