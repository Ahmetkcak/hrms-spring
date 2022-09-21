package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.EmployeeConfirm;

public interface EmployerConfirmService extends BaseEntityService<EmployeeConfirm>{
	DataResult<EmployeeConfirm> getByIdAndEmployee_FirstName(int id, String employeeFirstName);
}	
