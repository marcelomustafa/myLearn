package br.com.maripuri.mydom.modelMapper;

import br.com.maripuri.mydom.app.user.domain.dto.UserDTO;
import br.com.maripuri.mydom.app.user.domain.model.UserModel;
import br.com.maripuri.mydom.shared.modelMapper.SimpleMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements SimpleMapper<UserModel, UserDTO> {

	@Override
	public UserDTO toDTO(UserModel item) {
		return modelMapper.map(item, UserDTO.class);
	}

	@Override
	public UserModel toModel(UserDTO itemDTO) {
		return modelMapper.map(itemDTO, UserModel.class);
	}

}
