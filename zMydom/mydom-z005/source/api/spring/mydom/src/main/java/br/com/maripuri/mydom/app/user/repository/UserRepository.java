package br.com.maripuri.mydom.app.user.repository;

import br.com.maripuri.mydom.app.user.domain.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
	
	Optional<UserModel> findByUserName(String userName);
	Optional<UserModel> findByPersonEmail(String email);
	Boolean existsByUserName(String userName);
	Boolean existsByPersonEmail(String email);
		
}

