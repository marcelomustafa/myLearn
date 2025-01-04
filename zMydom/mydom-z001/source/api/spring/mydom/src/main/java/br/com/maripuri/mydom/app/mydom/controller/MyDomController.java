package br.com.maripuri.mydom.app.mydom.controller;

import br.com.maripuri.mydom.app.mydom.domain.dto.MyDomDTO;
import br.com.maripuri.mydom.app.mydom.service.MyDomService;
import br.com.maripuri.mydom.app.person.domain.dto.PersonDTO;
import br.com.maripuri.mydom.modelMapper.MyDomMapperDTO;
import br.com.maripuri.mydom.shared.utils.PaginationTools;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyDomController {
	
	private final MyDomService myDomService;
	private final MyDomMapperDTO myDomMapperDTO;
	private final PaginationTools pagination;
	
	public MyDomController(
			MyDomService myDomService,
			MyDomMapperDTO myDomMapperDTO,
			PaginationTools pagination
	){
		this.myDomService = myDomService;
		this.myDomMapperDTO = myDomMapperDTO;
		this.pagination = pagination;
	}
	
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping
    public ResponseEntity<MyDomDTO> getMyDom(){
        return ResponseEntity.status(HttpStatus.OK).body(myDomService.getMyDom());
    }	
	
	@GetMapping("/all")
	public ResponseEntity<List<MyDomDTO>> getAllPerson() {
		var mydoms = myDomService.findAll().stream().map(myDomMapperDTO).toList();
		return ResponseEntity.status(HttpStatus.OK).body(mydoms);
	}

	@PostMapping("/paged")
	public ResponseEntity<Page<MyDomDTO>> filterPersonPaged(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
			@RequestBody PersonDTO filter) {
		//List<PersonModel> persons = myDomService.filter(filter);
		var mydoms = myDomService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(pagination.ofList(mydoms, pageable, myDomMapperDTO));
	}	
	
}
