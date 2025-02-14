package com.shankar.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.shankar.model.UserInfo;

public interface IUserDetailsRepo extends CrudRepository<UserInfo, Integer>{
	public Optional<UserInfo> findByUname(String username);

}
