package com.shankar.utility;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JWTUtil {
	
	public static  String generateToken(String id,String subject,String skey) {
		return Jwts.builder().
				setId(id).
				setSubject(subject).
				setIssuer("Puja Services").
				setIssuedAt(new Date(System.currentTimeMillis())).
				setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(1))).
				signWith(SignatureAlgorithm.HS256,Base64.getEncoder().encode(skey.getBytes())).compact();
	}

}
