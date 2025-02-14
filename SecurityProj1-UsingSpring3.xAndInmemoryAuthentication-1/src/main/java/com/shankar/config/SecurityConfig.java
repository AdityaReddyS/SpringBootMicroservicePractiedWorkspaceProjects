package com.shankar.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//declares which Page(URL) will have What access type
		http.authorizeHttpRequests()
		.requestMatchers("/").permitAll()
		.requestMatchers("/offers").authenticated()
		.requestMatchers("/balance").hasAuthority("VISTOR")
		.requestMatchers("/loanapprove").hasAuthority("MANAGER")
		.requestMatchers("/balance").hasAnyAuthority("Customer","MANAGER")
		
		// Any other URLs which are not configured in above antMatchers
		// generally declared aunthenticated() in real time
		.anyRequest().authenticated()
		
		//Login Form Details
		.and()
		.formLogin()
		.defaultSuccessUrl("/welcome", true)
		
		//Logout Form Details
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
				
		//Exception Details		
		.and()	
		.exceptionHandling()
		.accessDeniedPage("/accessDenied")
		;
		
		return http.build();
	}
	
	
	@Bean
	public InMemoryUserDetailsManager configAuthentication() {
		
		List<UserDetails> users = new ArrayList<>();
		List<GrantedAuthority> adminAuthority = new ArrayList<>();
		adminAuthority.add(new SimpleGrantedAuthority("CUSTOMER"));
		UserDetails cust= new User("raja", "{noop}rani", adminAuthority);
		users.add(cust);
		
		List<GrantedAuthority> VistorAuthority = new ArrayList<>();
		adminAuthority.add(new SimpleGrantedAuthority("VISTOR"));
		UserDetails vistor= new User("aditya", "{noop}daddy", VistorAuthority);
		users.add(vistor);
		
		List<GrantedAuthority> managerAuthority = new ArrayList<>();
		adminAuthority.add(new SimpleGrantedAuthority("MANAGER"));
		UserDetails manager= new User("bhavani", "{noop}Shankar", managerAuthority);
		users.add(manager);
		
		return new InMemoryUserDetailsManager(users);
	}
	/*@Override
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
		
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("raja").password("$2a$10$mzg1Z2uyk5dPV7HXGv4T.OEWjMY3qDBTYvh9l6JZ0K9aRdeiorTLK").roles("CUSTOMER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("shankar").password("$2a$10$AOfCJEfAWJWgbuAyojUu7eHliNV4oWJNnsLw6OB3yIaRpuZN2vsNq").roles("CUSTOMER","MANAGER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("aditya").password("$2a$10$AbeAQDrt00Ob09TanEIxEu7dvM4qvmEKvbdX3EAOiTQmDZ04mT4Wy").roles("VISTOR");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("bhavani").password("$2a$10$24F3pPu7DsLxN3a/qi12pur0TwGt2rxFQ/Wg3XD3wuf0b3DnfMkmu").roles("CUSTOMER","MANAGER");
	}
*/
}
