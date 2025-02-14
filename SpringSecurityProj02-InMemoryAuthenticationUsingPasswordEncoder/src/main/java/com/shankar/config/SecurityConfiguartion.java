package com.shankar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguartion extends WebSecurityConfigurerAdapter {
	
	@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("raja").password("$2a$10$hBxoNiadXw82n0fc8vejcuQSq959NgDxO2RX96QNzplo/uZnqn6Oy").roles("CUSTOMER");
			auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("shankar").password("$2a$10$AazlQOca2fhu9NUorrxIuOE/CUaAGxCmh.NiX2D99mujuGONkJdxi").roles("CUSTOMER","MANAGER");
			auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("bhavani").password("$2a$10$aPJtzCUw32jXtoBxIa7O2e2cCLrd.vwDJNN81RDB8FeA.Yw.bLSDW").roles("MANAGER");
		}
@Override
public void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers("/").permitAll() //no authentication+authorization
	.antMatchers("/offers").authenticated() //only authentication
	.antMatchers("/balance").hasAnyAuthority("CUSTOMER","MANAGER")//authentiaction+authorization for customer,manager role
	.antMatchers("/loans").hasAnyRole("MANAGER")//authentication+authorization for manager role
	.anyRequest().authenticated()
	.and().formLogin()
	.and().rememberMe()
	//.and().httpBasic()
	
	.and().exceptionHandling().accessDeniedPage("/denied")
	.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
	.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
}
}
