package com.shankar.service;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shankar.model.UserInfo;
import com.shankar.repo.IUserDetailsRepo;
@Service("userService")
public class IUserServiceImpl implements IUserService{
@Autowired
	private IUserDetailsRepo repo;
@Autowired(required=true)
private BCryptPasswordEncoder encoder;
	@Override
	public String registerUser(UserInfo user) {
	user.setPwd(encoder.encode(user.getPwd()));
		return repo.save(user).getUnid()+"User is Registered";
	}
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Optional<UserInfo> opt=repo.findByUname(username);
		if(opt.isEmpty())
			throw new IllegalArgumentException("username not found");
		else {
			UserInfo details=opt.get();
			Set<GrantedAuthority> roles=new HashSet();
			for(String role: details.getRoles()) {
				SimpleGrantedAuthority authority=new SimpleGrantedAuthority(role);
				roles.add(authority);
			}
			 User user=new User(details.getUname(),details.getPwd(),roles);
			
			/*
			 User user=new User(details.getUname(),details.getPwd(),details.getRoles().
			  stream().map(role-> new
			  SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
			 */
		return user;
		}
		}
	

	
}
