package br.com.mariapuri.mydom.authServer.controller;

import br.com.mariapuri.mydom.authServer.config.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Se estiver usando JWT, você também precisará dos imports relacionados:
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

// E os imports para quaisquer serviços ou componentes que você injetar:
//import seu.pacote.JwtTokenProvider; // Substitua 'seu.pacote' pelo pacote real onde sua classe está localizada



@RestController
public class TokenValidationController {

  @Autowired
  private JwtTokenProvider tokenProvider;

  @GetMapping("/validateToken")
  public ResponseEntity<?> validateToken(@RequestParam String token) {
    boolean isValid = tokenProvider.validateToken(token);
    return isValid ? ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
  }
}
