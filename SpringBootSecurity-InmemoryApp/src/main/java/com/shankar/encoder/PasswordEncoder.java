package com.shankar.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	
	String password1=encoder.encode("rani");
	String password2=encoder.encode("shankar");
	String password3=encoder.encode("daddy");
	String password4=encoder.encode("aditya");
	
	System.out.println(password1);
	System.out.println(password2);
	System.out.println(password3);
	System.out.println(password4);

	

	}

}
