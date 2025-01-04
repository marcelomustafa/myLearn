package br.com.maripuri.mydom.app.person.service;

import br.com.maripuri.mydom.app.person.domain.dto.PersonDTO;
import br.com.maripuri.mydom.app.person.domain.model.PersonModel;
import br.com.maripuri.mydom.app.person.repository.PersonRepository;
import br.com.maripuri.mydom.app.user.domain.model.UserModel;
import br.com.maripuri.mydom.reports.PersonReport;
import br.com.maripuri.mydom.shared.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

//@AllArgsConstructor
@Service
public class PersonService extends BaseService<PersonModel, PersonRepository> {
  
  public List<PersonModel> filter(PersonDTO filter) {
    //return Arrays.asList(new PersonModel()); 
    return repository.filter(filter);
  } 

  public byte[] getReportPerson(List<PersonDTO> list, PersonDTO filter) throws Exception {
    var user = new UserModel();
    var report = new PersonReport(list, filter, user);
    return report.getReport();
  }
  
  public byte[] getSheetPerson(List<PersonDTO> list, PersonDTO filter) throws Exception {
    var user = new UserModel();
    var report = new PersonReport(list, filter, user);
    return report.getSheet();    
  } 
  
}
