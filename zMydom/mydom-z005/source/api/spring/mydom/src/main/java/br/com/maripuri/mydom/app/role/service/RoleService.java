package br.com.maripuri.mydom.app.role.service;

import br.com.maripuri.mydom.app.role.domain.model.RoleModel;
import br.com.maripuri.mydom.app.role.repository.RoleRepository;
import br.com.maripuri.mydom.enums.RoleNameType;
import br.com.maripuri.mydom.shared.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService extends BaseService<RoleModel, RoleRepository> {
	
	public Optional<RoleModel> findByName(RoleNameType name){
		return repository.findByName(name);
	}

}
