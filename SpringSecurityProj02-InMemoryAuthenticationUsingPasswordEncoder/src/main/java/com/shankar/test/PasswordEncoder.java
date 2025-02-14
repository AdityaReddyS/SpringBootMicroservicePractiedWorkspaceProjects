package com.shankar.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String pwd1=encoder.encode("raja");
		String pwd2=encoder.encode("rani");
		String pwd3=encoder.encode("shankar");
		String pwd4=encoder.encode("aditya");
		String pwd5=encoder.encode("bhavani");
		System.out.println("raja::->"+pwd1);
		System.out.println("rani::->"+pwd2);
		System.out.println("shankar::->"+pwd3);
		System.out.println("aditya::->"+pwd4);
		System.out.println("bhavani::->"+pwd5);
		System.out.println("shankar::->"+pwd3);

	}

}
