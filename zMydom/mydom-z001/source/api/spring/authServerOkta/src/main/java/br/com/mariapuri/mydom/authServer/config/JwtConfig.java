package br.com.mariapuri.mydom.authServer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

  @Bean
  public JwtTokenProvider jwtTokenProvider(
      @Value("${jwt.secret}") String jwtSecret,
      @Value("${jwt.expirationMs}") int jwtExpirationInMs) {
    return new JwtTokenProvider(jwtSecret, jwtExpirationInMs);
  }
}
