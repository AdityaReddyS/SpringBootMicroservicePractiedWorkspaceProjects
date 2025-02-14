package com.shankar.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shankar.entity.UserInfo;
import com.shankar.repo.UserDetailsRepository;

@Service("userService")
public class IuserDetailsMgmtServiceImpl implements IUserDetailsMgmtService {
@Autowired
private UserDetailsRepository userrepo;

@Autowired
private BCryptPasswordEncoder encoder;

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Optional<UserInfo> opt=userrepo.findByUname(username);
	if(opt.isEmpty()) {
		throw new IllegalArgumentException("User Name is Not Found");
	}
	UserInfo info=opt.get();
	/*Set<GrantedAuthority> roles=new HashSet();
	for(String role:info.getRoles()) {
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(role);
		roles.add(authority);
	}*/
	
	User user=new User(info.getUname(),info.getPwd(),info.getRoles().stream().map(role-> new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
	
	return user;
}

@Override
	public String registerUser(com.shankar.entity.UserInfo user) {
		user.setPwd(encoder.encode(user.getPwd()));
		int idVal=userrepo.save(user).getUnid();
		return "User Is Registered With the UNID value::;"+idVal;
	}

	
}
