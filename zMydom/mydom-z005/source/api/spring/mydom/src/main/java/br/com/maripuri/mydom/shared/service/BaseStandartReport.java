package br.com.maripuri.mydom.shared.service;


import br.com.maripuri.mydom.app.user.domain.model.UserModel;
import br.com.maripuri.mydom.shared.report.StandartReport;

import java.util.List;

//@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class BaseStandartReport<L, F> {

  public byte[] getReport(List<L> list, F filter, String reportName) throws Exception {
    var user = new UserModel();
		var report = new StandartReport(list, filter, user, reportName);
    return report.getReport();
  }
  
  public byte[] getSheet(List<L> list, F filter, String reportName) throws Exception {
    var user = new UserModel();
		var report = new StandartReport(list, filter, user, reportName);
    return report.getSheet();    
  } 	
	
}
