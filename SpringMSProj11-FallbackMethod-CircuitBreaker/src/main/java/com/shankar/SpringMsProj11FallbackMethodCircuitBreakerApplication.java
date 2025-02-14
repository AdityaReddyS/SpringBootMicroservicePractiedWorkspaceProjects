package com.shankar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class SpringMsProj11FallbackMethodCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsProj11FallbackMethodCircuitBreakerApplication.class, args);
	}

}
