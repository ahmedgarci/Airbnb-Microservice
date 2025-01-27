package com.AirbnbClone.AuthService.Security;

import java.security.Key;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class JwtUtils {

    private final String JwtSecret="1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef";

    public String generateJwtToken(Integer userId,String userEmail){
        return Jwts.builder()
            .setSubject(String.valueOf(userId))
            .claim("email", userEmail)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis()+360000))
            .signWith(getSecretKey())
            .compact();
    }

    public boolean isTokenValid (String jwtToken,UserDetails userDetailsToCheckWith ){
        return (extractUserEmail(jwtToken).equals(userDetailsToCheckWith.getUsername()) && !checkIsTokenNotExpired(jwtToken));
    }
    
    public boolean checkIsTokenNotExpired(String jwtToken){
        Date expirationDate = this.extractAllClaims(jwtToken).getExpiration();
        return expirationDate.before(new Date()); 
    }

    public String extractUserEmail(String token){
        return String.valueOf(extractAllClaims(token).get("email"));
    }

    private Claims extractAllClaims(String jwtToken){
        return Jwts.parserBuilder().setSigningKey(getSecretKey())
        .build().parseClaimsJws(jwtToken).getBody();
    }

    public Integer ExtractUserId(String token){
        return Integer.valueOf(extractAllClaims(token).getSubject());
    }

    private Key getSecretKey(){
        byte[] KeyBytes = Decoders.BASE64.decode(JwtSecret);
        return Keys.hmacShaKeyFor(KeyBytes);
    }


}
