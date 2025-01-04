package br.com.mariapuri.mydom.camundaServer.service;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;

public class CamundaService {
  @Autowired
  private RuntimeService runtimeService;

  public void startProcessInstanceByKey(String meuProcesso){
    runtimeService.startProcessInstanceByKey(meuProcesso);
  }

}
