package com.shankar.service;



import org.springframework.security.core.userdetails.UserDetailsService;

import com.shankar.model.UserInfo;

public interface IUserService extends  UserDetailsService {
public String registerUser(UserInfo user);
}
