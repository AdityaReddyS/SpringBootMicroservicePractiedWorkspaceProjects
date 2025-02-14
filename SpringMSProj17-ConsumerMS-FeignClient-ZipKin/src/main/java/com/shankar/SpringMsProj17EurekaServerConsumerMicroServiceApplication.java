package com.shankar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SpringMsProj17EurekaServerConsumerMicroServiceApplication {
	private Logger logger=LoggerFactory.getLogger(SpringMsProj17EurekaServerConsumerMicroServiceApplication.class);
	
	@Bean
	public Sampler createSampler() {
	logger.info("Sampler Object is Created");
		return Sampler.ALWAYS_SAMPLE;
	}
	public static void main(String[] args) {
	
		SpringApplication.run(SpringMsProj17EurekaServerConsumerMicroServiceApplication.class, args);
	}

}
