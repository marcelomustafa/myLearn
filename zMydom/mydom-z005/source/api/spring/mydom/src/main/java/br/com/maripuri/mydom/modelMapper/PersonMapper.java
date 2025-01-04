package br.com.maripuri.mydom.modelMapper;

import br.com.maripuri.mydom.app.person.domain.dto.PersonDTO;
import br.com.maripuri.mydom.app.person.domain.model.PersonModel;
import br.com.maripuri.mydom.shared.modelMapper.SimpleMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper implements SimpleMapper<PersonModel, PersonDTO> {

	@Override
	public PersonDTO toDTO(PersonModel item) {
		return modelMapper.map(item, PersonDTO.class);
	}

	@Override
	public PersonModel toModel(PersonDTO itemDTO) {
		return modelMapper.map(itemDTO, PersonModel.class);
	}

}
