package com.shankar;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class SpringBootMvcProj11I18nInternationalizationApplication {
	
	@Bean(name="localeResolver")//fixed bean id
	public SessionLocaleResolver createSLResolver() {
		System.out.println("SpringBootMvcProj11I18nInternationalizationApplication.createSLResolver()");
		SessionLocaleResolver resolver=new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en", "US"));
		return resolver;
				
	}
	
	@Bean(name="lci")
	public LocaleChangeInterceptor createlciInterCeptor() {
		System.out.println("SpringBootMvcProj11I18nInternationalizationApplication.createlciInterCeptor()");
		LocaleChangeInterceptor interceptor=new LocaleChangeInterceptor();
		interceptor.setParamName("lang");//default locale
		return interceptor;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcProj11I18nInternationalizationApplication.class, args);
	}

}
