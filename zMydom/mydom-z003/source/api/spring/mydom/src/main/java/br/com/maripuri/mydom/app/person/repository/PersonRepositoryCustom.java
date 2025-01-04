package br.com.maripuri.mydom.app.person.repository;

import br.com.maripuri.mydom.app.person.domain.dto.PersonDTO;
import br.com.maripuri.mydom.app.person.domain.model.PersonModel;

import java.util.List;

public interface PersonRepositoryCustom {
  public List<PersonModel> filter(PersonDTO filter);
  

  
}
