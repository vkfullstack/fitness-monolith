package com.project.fitness.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtils {

    private String jwtSecert = "a-string-secret-at-least-256-bits-long";
    private int jwtExprationms = 172800000;

    public String getjwtheader(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer "))
            return bearerToken.substring(7);
        return null;
    }

    public String generateToken(String userId, String role) {

        return Jwts.builder()
                .subject(userId)
                .claim("role", List.of(new SimpleGrantedAuthority(role)))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + jwtExprationms))
                .signWith(key())
                .compact();
    }

    private Key key() {
        // ✅ FIXED: removed BASE64 decode
        return Keys.hmacShaKeyFor(jwtSecert.getBytes());
    }
    public  String getUseridFromToken(String jwt){
        return  Jwts.parser().verifyWith((SecretKey) key())
                .build().parseSignedClaims(jwt)
                .getPayload().getSubject();
    }
    public Claims getAllClaims(String  jwt){
        return Jwts.parser().verifyWith((SecretKey) key())
                .build().parseSignedClaims(jwt).getPayload();
    }
    public boolean validateJwtToken(String jwt) {
        try {
            getAllClaims(jwt); // if parsing works, token is valid
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}