package br.com.maripuri.mydom.app.user.service;

import br.com.maripuri.mydom.app.user.domain.dto.UserDTO;
import br.com.maripuri.mydom.app.user.domain.model.UserModel;
import br.com.maripuri.mydom.app.user.repository.UserRepository;
import br.com.maripuri.mydom.shared.service.BaseServiceWithStandartReport;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService extends BaseServiceWithStandartReport<UserModel, UserRepository, UserDTO, UserDTO> {
	
	public Optional<UserModel> findByUserName(String userName){
		return  repository.findByUserName (userName);
	}
 		
	public Optional<UserModel> findByEmail(String userName){
		return repository.findByPersonEmail(userName);
	}
	
	public Boolean existsByUserName(String userName) {
		return repository.existsByUserName(userName);
	}
	
	public Boolean existsByEmail(String email) {
		return repository.existsByPersonEmail(email);
	}
	
	
}
