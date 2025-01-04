package br.com.maripuri.mydom.app.mydom.repository;

import br.com.maripuri.mydom.app.mydom.domain.model.MyDomModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MyDomRepository extends JpaRepository<MyDomModel, UUID> {

}
