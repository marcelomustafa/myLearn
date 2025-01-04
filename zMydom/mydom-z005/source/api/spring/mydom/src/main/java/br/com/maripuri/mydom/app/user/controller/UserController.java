package br.com.maripuri.mydom.app.user.controller;

import br.com.maripuri.mydom.app.user.domain.dto.UserDTO;
import br.com.maripuri.mydom.app.user.service.UserService;
import br.com.maripuri.mydom.modelMapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/all")
	public ResponseEntity<List<UserDTO>> getAllUser() {
		var users = userMapper.toDTOList(userService.findAll());
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}	
	
}
