package br.com.mariapuri.mydom.authServer.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import io.jsonwebtoken.io.Decoders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtTokenProvider {

  private final String jwtSecret;
  private final int jwtExpirationInMs;


  public JwtTokenProvider(String jwtSecret, int jwtExpirationInMs) {
    this.jwtSecret = jwtSecret;
    this.jwtExpirationInMs = jwtExpirationInMs;
  }

  public String generateToken(String username) {
    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

    SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));

    return Jwts.builder()
        .claim("sub", username)
        .issuedAt(now)
        .expiration(expiryDate)
        .signWith(key) // Algoritmo determinado automaticamente
        .compact();
  }

  public boolean validateToken(String authToken) {
    try {
      SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));

      Jwts.parser()
          .verifyWith(key)
          .build()
          .parseSignedClaims(authToken);

      return true;
    } catch (Exception ex) {
      // Tratamento de exceções
    }
    return false;
  }

  public String getUsernameFromJWT(String token) {
    Claims claims = Jwts.parser()
        .verifyWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret)))
        .build()
        .parseSignedClaims(token)
        .getPayload();

    return claims.getSubject();
  }
}


