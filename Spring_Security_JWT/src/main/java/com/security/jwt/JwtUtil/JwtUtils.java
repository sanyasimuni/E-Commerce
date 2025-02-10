package com.security.jwt.JwtUtil;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
	
	
	//generated The Token..
	private String GeneratedToken(Map<String,Object>extraClaims,UserDetails userDetails) {
		
		return Jwts.builder()
				.setClaims(extraClaims)
				.setSubject(userDetails.getUsername())
				.setExpiration(new Date(System.currentTimeMillis()+100*60*60*24))
				.setIssuedAt(new Date(System.currentTimeMillis()))
			    .signWith(getSigninKey(),SignatureAlgorithm.HS256).compact();
		
	}
	
	
	private Claims extractAllClaims(String token) {
		
		return Jwts.parserBuilder()
				.setSigningKey(getSigninKey())
				.build().parseClaimsJws(token)
				.getBody();
	}
	
	
	private <T>T extractClaims(String token,Function<Claims,T>claimResolver){
		
		              final   Claims claims= extractAllClaims(token);
		              return claimResolver.apply(claims);
		
	}
	public String extractUserName(String token) {
		return extractClaims(token, Claims::getSubject);
	}
	
	
	//token Expired set
	
	public Date extractExpiration(String token) {
		return extractClaims(token, Claims::getExpiration);
	}
	
	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	public boolean isTokenValid(String token,UserDetails userDetails) {
		
		          final String userName=extractUserName(token);
		          return (userName.equals(userDetails.getUsername())&& isTokenExpired(token));
		
	}
	
	public String generateToken(UserDetails userDetails) {
		return GeneratedToken(new HashMap<>(), userDetails);
	}
	
	

	private Key getSigninKey() {
	
	      String SECRET="247a76b4b95c3546eb591c36ab96204c507322c4b6ab9e94a5b5680cc866d0666041317508ad26e8808cb4d2874f664008121b2b67bbd5a42bb18213691263ca";
		   byte[] keybytes=Decoders.BASE64.decode(SECRET);
				
		return Keys.hmacShaKeyFor(keybytes);
	}
	

}
