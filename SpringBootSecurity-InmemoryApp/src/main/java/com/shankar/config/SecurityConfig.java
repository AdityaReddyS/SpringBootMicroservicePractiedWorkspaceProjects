package com.shankar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends  WebSecurityConfigurerAdapter{
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll() //no authentication
		.antMatchers("/offers").authenticated() //only authentication
		.antMatchers("/balance").hasAnyRole("CUSTOMER","MANAGER","VISTOR") //authentication and authorization
		.antMatchers("/loanapprove").hasRole("MANAGER")
		.anyRequest().authenticated()
		.and().formLogin()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
		//.and().rememberMe()
		.and().exceptionHandling().accessDeniedPage("/access-denied")
		.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true)
		
		;
	}
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/* auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("shankar").password("{noop}bhavani").roles("CUSTOMER","MANAGER");
		auth.inMemoryAuthentication().withUser("aditya").password("{noop}daddy").roles("VISTOR");
		auth.inMemoryAuthentication().withUser("bhavani").password("{noop}shankar").roles("CUSTOMER","MANAGER");
		*/
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("raja").password("$2a$10$mzg1Z2uyk5dPV7HXGv4T.OEWjMY3qDBTYvh9l6JZ0K9aRdeiorTLK").roles("CUSTOMER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("shankar").password("$2a$10$AOfCJEfAWJWgbuAyojUu7eHliNV4oWJNnsLw6OB3yIaRpuZN2vsNq").roles("CUSTOMER","MANAGER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("aditya").password("$2a$10$AbeAQDrt00Ob09TanEIxEu7dvM4qvmEKvbdX3EAOiTQmDZ04mT4Wy").roles("VISTOR");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("bhavani").password("$2a$10$24F3pPu7DsLxN3a/qi12pur0TwGt2rxFQ/Wg3XD3wuf0b3DnfMkmu").roles("CUSTOMER","MANAGER");
	}
}
