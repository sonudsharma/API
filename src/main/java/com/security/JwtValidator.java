package com.security;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.models.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	private String secret = "raystechserv";

	public JwtUser validate(String token) {

		JwtUser jwtUser = null;

		try {
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			// body.getExpiration();

			jwtUser = new JwtUser();
			jwtUser.setUserName(body.getSubject());
			jwtUser.setId(Long.parseLong((String) body.get("userId")));
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			String strDate = dateFormat.format(body.getExpiration());
			jwtUser.setExpiration(strDate);

			// System.out.println(strDate);
			// jwtUser.setExpiration(body.getExpiration());
			// jwtUser.setRole((String) body.get("role"));
		} catch (ExpiredJwtException e) {
			System.out.println(e);

		}

		return jwtUser;
	}

	/*
	 * public static void main(String[] a) { String token =
	 * "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuZXdAdXNlci5jb20iLCJ1c2VySWQiOiIxNCIsImlhdCI6MTUyMTc4NDY0MywiZXhwIjoxNTIxNzg0NzQzfQ.xCUpSDVkyi9-RAdmONHxYNUqTeQ_rzXEI1h0f-M12jBpPpcRbe2XymUeulLjusaHOmb0aPLD6YYICYENSULcZQ";
	 * 
	 * JwtUser jwtUser = new JwtValidator().validate(token);
	 * System.out.println(jwtUser); }
	 */

}
