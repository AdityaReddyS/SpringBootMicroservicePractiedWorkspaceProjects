package com.shankar.config;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.shankar.service.IUserDetailsMgmtService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends  WebSecurityConfigurerAdapter{
	@Autowired
	private IUserDetailsMgmtService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(service).passwordEncoder(encoder);
	}


	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/bank/").permitAll() //no authentication
		.antMatchers("/user/register","/user/showLogin").permitAll()
		.antMatchers("/bank/offers").authenticated() //only authentication
		.antMatchers("/bank/balance").hasAnyRole("CUSTOMER","MANAGER","VISTOR") //authentication and authorization
		.antMatchers("/bank/loanapprove").hasRole("MANAGER")
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/user/showLogin").
		loginProcessingUrl("/login").failureUrl("/user/showLogin?error")
		.defaultSuccessUrl("/bank/",true)
		
		//.and().rememberMe()
		.and().exceptionHandling().accessDeniedPage("/bank/access-denied")
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout")).logoutSuccessUrl("/user/showLogin?logout")
		.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true)
		
		;
	}
}
	
