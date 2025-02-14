package com.shankar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.shankar.service.IUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguartion extends WebSecurityConfigurerAdapter {
	@Autowired
	private IUserService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(encoder);
		}
@Override
public void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers("/","/bank/").permitAll() //no authentication+authorization
	.antMatchers("/user/register").permitAll()
	.antMatchers("/bank/offers").authenticated() //only authentication
	.antMatchers("/bank/balance").hasAnyAuthority("CUSTOMER","MANAGER")//authentiaction+authorization for customer,manager role
	.antMatchers("/bank/loans").hasAnyRole("MANAGER")//authentication+authorization for manager role
	.anyRequest().authenticated()
	.and().formLogin().defaultSuccessUrl("/bank/", true).
	loginPage("/user/showLogin").
	loginProcessingUrl("/login").
	failureUrl("/user/showLogin?error")
	.and().rememberMe()
	//.and().httpBasic()
	
	.and().exceptionHandling().accessDeniedPage("/denied")
	.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout")).logoutSuccessUrl("/user/showLogin?logout")
	.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
}
}
