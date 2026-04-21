package com.codify.backend.service;

import java.util.List;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	private final long EXPIRATION = 1000L * 60 * 60;
	@Value("${jwt.secret}")
	private String secretKey;

	public String generateToken(Authentication authentication) {
		Map<String, Object> claims =  new HashMap<>();
		
		List<String> userRoles = authentication.getAuthorities()
			.stream()
			.map(grantedAuthority -> grantedAuthority.getAuthority())
			.toList();
		
		claims.put("roles", userRoles);
		
		return Jwts.builder()
				.claims(claims)
				.subject(authentication.getName())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + EXPIRATION))
				.signWith(getSigningKey())
				.compact();
	}

	private Key getSigningKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
