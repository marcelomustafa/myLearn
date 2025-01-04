package br.com.mariapuri.mydom.camundaServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessController {

  @GetMapping("/processes")
  public String getProcesses() {
    // Aqui você pode adicionar a lógica para interagir com a API do Camunda
    return "Lista de processos";
  }
}
