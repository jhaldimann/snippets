package com.mentoring.snippets.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.nimbusds.jose.shaded.json.JSONObject;
import io.jsonwebtoken.impl.TextCodec;
import liquibase.pro.packaged.D;
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
		return Jwts.builder()
				.setIssuer("snippet")
				.setHeaderParam("typ", "JWT")
				.claim("name", claims.get("USERNAME"))
				.claim("roles", claims.get("ROLES"))
				.setSubject(subject)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+ JWT_EXP))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				.compact();
	}

	public boolean isValid(String token) {
		try {
			final var claimsJws = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
			return claimsJws != null;
		} catch (Exception exception) {
			return false;
		}
	}

	public String extractUsername(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
	}

	public List<String> extractRoles(String token) {
		return (List<String>) extractClaim(token).get("roles");
	}
	
	public Claims extractClaim(String token) {
		return  Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}

}