package com.shankar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguartion extends WebSecurityConfigurerAdapter {
	
	@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").roles("CUSTOMER");
			auth.inMemoryAuthentication().withUser("shankar").password("{noop}aditya").roles("CUSTOMER","MANAGER");
			auth.inMemoryAuthentication().withUser("bhavani").password("{noop}shankar").roles("MANAGER");
		}
@Override
public void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers("/").permitAll() //no authentication+authorization
	.antMatchers("/offers").authenticated() //only authentication
	.antMatchers("/balance").hasAnyRole("CUSTOMER","MANAGER")//authentiaction+authorization for customer,manager role
	.antMatchers("/loans").hasRole("MANAGER")//authentication+authorization for manager role
	.anyRequest().authenticated()
	.and().formLogin()
	.and().rememberMe()
	//.and().httpBasic()
	
	.and().exceptionHandling().accessDeniedPage("/denied")
	.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
	.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
}
}
