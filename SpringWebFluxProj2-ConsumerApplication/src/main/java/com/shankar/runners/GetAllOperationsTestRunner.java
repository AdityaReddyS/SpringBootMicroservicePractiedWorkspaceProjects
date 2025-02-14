package com.shankar.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.shankar.model.Employee;

import reactor.core.publisher.Flux;
//@Component
public class GetAllOperationsTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		WebClient client=WebClient.create("http://localhost:4041/SpringWebFluxProj1/");
		
		Flux<Employee> flux=client.get().uri("/employee/all").retrieve().bodyToFlux(Employee.class);
		flux.doOnNext(System.out::println).blockLast();

	}

}
