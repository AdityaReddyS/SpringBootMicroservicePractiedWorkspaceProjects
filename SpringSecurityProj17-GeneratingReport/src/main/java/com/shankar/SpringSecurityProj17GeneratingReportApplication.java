package com.shankar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@SpringBootApplication
public class SpringSecurityProj17GeneratingReportApplication {
	@Bean
	public BeanNameViewResolver createBeanNameResolver() {
		System.out.println("Spring.createBeanNameResolver()");
		BeanNameViewResolver resolver=new BeanNameViewResolver();
		resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return resolver;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityProj17GeneratingReportApplication.class, args);
	}

}
