package com.seifeakalu.jwt.api.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.seifeakalu.jwt.api.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

@Service
public class JwtUtil {

    private String secret = "random secret";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

   
    public String generateToken( HttpServletRequest httpServletRequest) {
    	String authorizationHeader = httpServletRequest.getHeader("Authorization");
        String token = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
        	 token = authorizationHeader.substring(7);
        }
        return token;
    }
    
    public User parseToken(String token) {
       System.out.println(token);
    	try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            User loggedUser = new User();
            loggedUser.setUserName( body.getSubject());
            System.out.println(body.get("userId")+body.getSubject());
            long id = ((Number) body.get("userId")).longValue();
            loggedUser.setId( (long) id);
            loggedUser.setFirstName((String) body.get("firstName"));
            loggedUser.setLastName((String) body.get("lastName"));
            return loggedUser;

        } catch (JwtException | ClassCastException e) {
    		throw new RuntimeException(e);
        }
    }
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(Long id,String username,String firstName, String lastName, String email) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, id,username,firstName,lastName,email);
    }

    private String createToken(Map<String, Object> claims, Long id,String user, String firstName, String lastName, String email) {

        return Jwts.builder().setClaims(claims).setSubject(user).claim("userId",id).claim("firstName",firstName).claim("lastName",lastName).claim("lastName",email).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}

