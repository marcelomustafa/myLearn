package br.com.maripuri.mydom.modelMapper;

import br.com.maripuri.mydom.app.mydom.domain.dto.MyDomDTO;
import br.com.maripuri.mydom.app.mydom.domain.model.MyDomModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MyDomMapperDTO implements Function<MyDomModel, MyDomDTO> {
	
	@Override
	public MyDomDTO apply(MyDomModel mydom) {
		return new MyDomDTO(
				mydom.getName(), 
				mydom.getDescription()
		);
	}

}
