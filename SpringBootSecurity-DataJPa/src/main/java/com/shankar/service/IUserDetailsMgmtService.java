package com.shankar.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.shankar.entity.UserInfo;

public interface IUserDetailsMgmtService  extends UserDetailsService{
	
	public String registerUser(UserInfo user);

}
