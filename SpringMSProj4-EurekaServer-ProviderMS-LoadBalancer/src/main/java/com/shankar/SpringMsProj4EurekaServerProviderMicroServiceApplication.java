package com.shankar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringMsProj4EurekaServerProviderMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsProj4EurekaServerProviderMicroServiceApplication.class, args);
	}

}
