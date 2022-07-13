package com.mentoring.snippets.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.jsonwebtoken.impl.TextCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {

	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${jwt.secret}")
	private String SECRET_KEY;

	@Value("${jwt.jwtExp}")
	private int JWT_EXP;

	public String generateToken(UserDetails myUserDetails) {
		List<String> roles = myUserDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
		Map<String, Object> claims = new HashMap<>();
		claims.put("USERNAME", myUserDetails.getUsername());
		claims.put("ROLES", roles);

		return createToken(claims, myUserDetails.getUsername());
	}

	public String createToken(Map<String, Object> claims, String subject) {
		System.out.println(SECRET_KEY);
		return Jwts.builder()
				.setIssuer("snippets")
				.setSubject(subject)
				.setClaims(claims)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+ JWT_EXP))
				.signWith(
						SignatureAlgorithm.HS256,
						SECRET_KEY
				)
				.compact();
	}
	
	public boolean validateJwtToken(String token) {
		try {
			Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
			return true;
		} catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
			logger.error("Invalid token");
		} catch (ExpiredJwtException ex) {
			logger.error("Expired token");
		}

		return false;
	}

	public String extractUsername(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
	}
	
	@SuppressWarnings("unchecked")
	public List<String> extractRoles(String token) {
		return (List<String>) extractClaim(token).get("ROLES");
	}
	
	public Claims extractClaim(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}

}