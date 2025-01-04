package br.com.maripuri.mydom.app.mydom.service;


import br.com.maripuri.mydom.app.mydom.domain.dto.MyDomDTO;
import br.com.maripuri.mydom.app.mydom.domain.model.MyDomModel;
import br.com.maripuri.mydom.app.mydom.repository.MyDomRepository;
import br.com.maripuri.mydom.modelMapper.MyDomMapperDTO;
import br.com.maripuri.mydom.shared.service.BaseService;
import org.springframework.stereotype.Service;


@Service
public class MyDomService extends BaseService<MyDomModel, MyDomRepository> {
	
	private final MyDomMapperDTO myDomMapperDTO;

	public MyDomService(
			MyDomMapperDTO myDomMapperDTO
	) {

		this.myDomMapperDTO = myDomMapperDTO;
	}

	
	public MyDomDTO getMyDom() {

		return myDomMapperDTO.apply(
				new MyDomModel(
						"MyDom",
						"Apresentação de estudo."
				)
		) ;
	}

	
}
