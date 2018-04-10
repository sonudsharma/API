package com.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.models.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	public static String generate(JwtUser jwtUser) {

		// Date currentTime = new Date();

		Claims claims = Jwts.claims().setSubject(jwtUser.getUserName());
		claims.put("userId", String.valueOf(jwtUser.getId()));
		// claims.put("role", jwtUser.getRole());

		return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24))).signWith(SignatureAlgorithm.HS512, "raystechserv").compact();

	}
}
