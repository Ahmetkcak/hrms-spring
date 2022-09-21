package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.EmployeeConfirmEmployer;

public interface EmployeeConfirmEmployerService extends BaseEntityService<EmployeeConfirmEmployer>{
	DataResult<EmployeeConfirmEmployer> getByEmployee_FirstNameAndEmployer_CompanyName(String employeeFirstName, String employerCompanyName);
}
