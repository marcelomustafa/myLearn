package br.com.mariapuri.mydom.authServer.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

  @GetMapping("/api/public")
  public String publicEndpoint() {
    return "Todos podem ver isso";
  }

  @GetMapping("/api/private")
  @PreAuthorize("isAuthenticated()")
  public String privateEndpoint() {
    return "Somente usuários autenticados podem ver isso";
  }

  @GetMapping("/api/private-scoped")
  @PreAuthorize("hasAuthority('read:messages')")
  public String privateScopedEndpoint() {
    return "Somente usuários com a permissão 'read:messages' podem ver isso";
  }

}
