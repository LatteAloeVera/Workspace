package com.example.library.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
    
    private final String SECRET_KEY = "mysecretkey";

    public String generateToken(String username, String role) {
        long currentTimeMillis = System.currentTimeMillis();
        long expirationMillis = currentTimeMillis + (1000 * 60 * 60); // 1 hour

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(expirationMillis))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    /**
     * Extracts all claims from a JWT token.
     */
    // public Claims getClaims(String token) {
    //     // TO DO: Add exception handling
    // }

    /**
     * Checks if the token is expired.
     */
    // public boolean isTokenExpired(String token) {
    //     return getClaims(token).getExpiration().before(new Date());
    // }
}