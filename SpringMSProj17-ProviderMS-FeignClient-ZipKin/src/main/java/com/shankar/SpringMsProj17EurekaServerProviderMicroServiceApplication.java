package com.shankar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringMsProj17EurekaServerProviderMicroServiceApplication {
private Logger logger=LoggerFactory.getLogger(SpringMsProj17EurekaServerProviderMicroServiceApplication.class);
	
	@Bean
	public Sampler createSampler() {
	logger.info("Sampler Object is Created");
		return Sampler.ALWAYS_SAMPLE;
	}

	
	public static void main(String[] args) {
		SpringApplication.run(SpringMsProj17EurekaServerProviderMicroServiceApplication.class, args);
	}

}
