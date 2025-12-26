package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.util.*;

public class JwtTokenProvider {

    private final String secret = "test-secret-key-test-secret-key";
    private final long validityMs = 3600000;

    public String createToken(Long userId, String email, Set<String> roles) {
        return Jwts.builder()
                .claim("uid", userId)
                .claim("roles", roles)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityMs))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secret.getBytes()).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
