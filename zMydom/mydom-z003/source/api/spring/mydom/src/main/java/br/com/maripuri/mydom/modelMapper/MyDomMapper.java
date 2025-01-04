package br.com.maripuri.mydom.modelMapper;


import br.com.maripuri.mydom.app.mydom.domain.dto.MyDomDTO;
import br.com.maripuri.mydom.app.mydom.domain.model.MyDomModel;
import br.com.maripuri.mydom.shared.modelMapper.SimpleMapper;
import org.springframework.stereotype.Service;


@Service
public class MyDomMapper implements SimpleMapper<MyDomModel, MyDomDTO> {
	
	@Override
	public MyDomDTO toDTO(MyDomModel item) {
		return modelMapper.map(item, MyDomDTO.class);
	}

	@Override
	public MyDomModel toModel(MyDomDTO itemDTO) {
		return modelMapper.map(itemDTO, MyDomModel.class);
	}
	
}
