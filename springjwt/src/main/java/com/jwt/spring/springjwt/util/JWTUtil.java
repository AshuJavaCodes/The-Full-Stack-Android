package com.jwt.spring.springjwt.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTUtil {
    private String SECRET_KEY = "secret";


    //Method to Extract Username from the token and Other Details from the Token
    public String extractUsernameFromToken(String token){

        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();

    }

    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+10*60*60*1000))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();


    }
    public boolean validateToken (String token, UserDetails userDetails){
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        Date expiryDate = claims.getExpiration();
        String username = claims.getSubject();
        if (userDetails.getUsername().equals(username) && (new Date().before(expiryDate))) {
            return true;
        }
        return false;



    }


}
