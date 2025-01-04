package br.com.maripuri.mydom.shared.report;


import br.com.maripuri.mydom.app.user.domain.model.UserModel;

import java.util.List;

public class StandartReport<L, F> extends BaseReport<L, F>  {
	
	private String reportName;
	
  public StandartReport(List<L> list, F filter, UserModel user, String reportName) {
    super(list, filter, user);

    //"/reports/report-name.jasper"
    this.reportName = reportName;
    
    setParameters();
  }

  private void setParameters() {

    var selectedFilters = "";
    //DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    setJasperReportName(reportName);
    setJasperSheetName(reportName);

    if (this.filter != null) {

//      if (this.filter.getName() != null && StringUtils.hasText(this.filter.getName())) {
//        selectedFilters += "Nome: " + this.filter.getName() + ";";
//      }

      paramiters.put("SELECTED_FILTERS", selectedFilters);

    }

  }	

}
