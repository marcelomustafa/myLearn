package br.com.maripuri.mydom.app.role.repository;

import br.com.maripuri.mydom.app.role.domain.model.RoleModel;
import br.com.maripuri.mydom.enums.RoleNameType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleModel, UUID> {
	
	public Optional<RoleModel> findByName(RoleNameType name);

}
