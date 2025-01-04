package br.com.maripuri.mydom.app.person.repository;

import br.com.maripuri.mydom.app.person.domain.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository
    extends JpaRepository<PersonModel, UUID>,
            PersonRepositoryCustom,
            PersonRepositoryQuery{

}
