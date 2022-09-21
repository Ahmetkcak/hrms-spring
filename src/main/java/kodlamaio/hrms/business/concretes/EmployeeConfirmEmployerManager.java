	package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeConfirmEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeConfirmEmployerDao;
import kodlamaio.hrms.entities.concretes.EmployeeConfirmEmployer;

@Service
public class EmployeeConfirmEmployerManager implements EmployeeConfirmEmployerService{
	
	private EmployeeConfirmEmployerDao employeeConfirmEmployerDao;

    public EmployeeConfirmEmployerManager(EmployeeConfirmEmployerDao employeeConfirmEmployerDao) {
        this.employeeConfirmEmployerDao = employeeConfirmEmployerDao;
    }

    @Override
    public Result add(EmployeeConfirmEmployer employeeConfirmEmployer) {
    	
        employeeConfirmEmployer.setConfirmDate(LocalDate.now());

        employeeConfirmEmployerDao.save(employeeConfirmEmployer);
        return new SuccessResult("İşveren işciyi onayladı");
    }

    @Override
    public Result update(EmployeeConfirmEmployer employeeConfirmEmployer) {
        return null;
    }

    @Override
    public Result delete(EmployeeConfirmEmployer employeeConfirmEmployer) {
        return null;
    }

    @Override
    public DataResult<List<EmployeeConfirmEmployer>> getAll() {
        return null;
    }

    @Override
    public DataResult<EmployeeConfirmEmployer> getById(int id) {
        return new SuccessDataResult<EmployeeConfirmEmployer>(this.employeeConfirmEmployerDao.getById(id), "Data Listelendi");
    }

    @Override
    public DataResult<EmployeeConfirmEmployer> getByEmployee_FirstNameAndEmployer_CompanyName(String employeeFirstName, String employerCompanyName) {
        return new SuccessDataResult<EmployeeConfirmEmployer>(this.employeeConfirmEmployerDao.getByEmployee_FirstNameAndEmployer_CompanyName(employeeFirstName,employerCompanyName), "Data Listelendi");
    }
}
