package com.shankar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringMsProj7CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsProj7CustomerServiceApplication.class, args);
	}

}
