package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerConfirmService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeConfirmDao;
import kodlamaio.hrms.entities.concretes.EmployeeConfirm;

@Service
public class EmployerConfirmManager implements EmployerConfirmService{
	
	private EmployeeConfirmDao employeeConfirmDao;

    @Autowired
    public EmployerConfirmManager(EmployeeConfirmDao employerConfirmDao) {
        this.employeeConfirmDao = employerConfirmDao;
    }

    @Override
    public Result add(EmployeeConfirm entity) {
        return null;
    }

    @Override
    public Result update(EmployeeConfirm entity) {
        return null;
    }

    @Override
    public Result delete(EmployeeConfirm entity) {
        return null;
    }

    @Override
    public DataResult<List<EmployeeConfirm>> getAll() {
        return null;
    }

    @Override
    public DataResult<EmployeeConfirm> getById(int id) {
        return null;
    }

    @Override
    public DataResult<EmployeeConfirm> getByIdAndEmployee_FirstName(int id, String employeeFirstName) {
        return new SuccessDataResult<EmployeeConfirm>(this.employeeConfirmDao.getByIdAndEmployee_FirstName(id, employeeFirstName), "Data Listelendi");
    }
}
