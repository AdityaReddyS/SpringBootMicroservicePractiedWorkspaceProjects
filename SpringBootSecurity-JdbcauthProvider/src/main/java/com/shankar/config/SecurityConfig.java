package com.shankar.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private DataSource datasource;
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(datasource).passwordEncoder(new BCryptPasswordEncoder()).
		usersByUsernameQuery("SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?").
		authoritiesByUsernameQuery("SELECT UNAME,ROLE FROM USERS_ROLES WHERE UNAME=?");
	}


	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll() //no authentication
		.antMatchers("/offers").authenticated() //only authentication
		.antMatchers("/balance").hasAnyRole("CUSTOMER","MANAGER","VISTOR") //authentication and authorization
		.antMatchers("/loanapprove").hasRole("MANAGER")
		.anyRequest().authenticated()
		.and().formLogin()
		
		//.and().rememberMe()
		.and().exceptionHandling().accessDeniedPage("/access-denied")
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
		.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true)
		
		;
	}
}
	
