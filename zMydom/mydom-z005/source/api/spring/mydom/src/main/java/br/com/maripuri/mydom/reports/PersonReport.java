package br.com.maripuri.mydom.reports;


import br.com.maripuri.mydom.app.person.domain.dto.PersonDTO;
import br.com.maripuri.mydom.app.user.domain.model.UserModel;
import br.com.maripuri.mydom.shared.report.BaseReport;
import org.springframework.util.StringUtils;

import java.util.List;


public class PersonReport extends BaseReport<PersonDTO, PersonDTO> {

  public PersonReport(List<PersonDTO> list, PersonDTO filter, UserModel user) {
    super(list, filter, user);
    setParameters();
  }

  private void setParameters() {

    var selectedFilters = "";
    //DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    setJasperReportName("/reports/report-name.jasper");
    setJasperSheetName("/reports/report-name.jasper");

    if (this.filter != null) {

      if (this.filter.getName() != null && StringUtils.hasText(this.filter.getName())) {
        selectedFilters += "Nome: " + this.filter.getName() + ";";
      }

      paramiters.put("SELECTED_FILTERS", selectedFilters);

    }

  }

}
