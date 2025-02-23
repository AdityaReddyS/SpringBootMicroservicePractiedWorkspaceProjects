package com.shankar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class SpringMsProj16AdminServerMiniProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsProj16AdminServerMiniProjectApplication.class, args);
	}

}
