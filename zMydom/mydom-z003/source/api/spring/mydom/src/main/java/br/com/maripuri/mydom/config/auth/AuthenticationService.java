package br.com.maripuri.mydom.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationService {

  private final RestTemplate restTemplate;
  private final String loginServiceUrl = "http://ms-mydom-authserver/validateToken";

  @Autowired
  public AuthenticationService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public boolean validateToken(String token) {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer " + token);
    HttpEntity<String> entity = new HttpEntity<>(headers);
    ResponseEntity<String> response = restTemplate.exchange(
        loginServiceUrl,
        HttpMethod.GET,
        entity,
        String.class
    );

    return response.getStatusCode() == HttpStatus.OK;
  }
}