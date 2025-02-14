package com.shankar;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@SpringBootApplication
public class SpringBootSchedulingProj1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSchedulingProj1Application.class, args);
		System.out.println("App Started at::::::"+new Date());
	}

}
