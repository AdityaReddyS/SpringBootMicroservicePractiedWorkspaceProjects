package com.shankar.repo;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.shankar.entity.UserInfo;

public interface UserDetailsRepository extends CrudRepository<UserInfo, Integer> {
	
	public Optional<UserInfo> findByUname(String username);

}
