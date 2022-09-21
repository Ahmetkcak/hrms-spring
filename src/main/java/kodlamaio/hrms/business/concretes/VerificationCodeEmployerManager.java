package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationCodeEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeEmployerDao;
import kodlamaio.hrms.entities.concretes.VerificationCodeEmployer;

@Service
public class VerificationCodeEmployerManager implements VerificationCodeEmployerService{
	
	 private VerificationCodeEmployerDao verificationCodeEmployerDao;

	    @Autowired
	    public VerificationCodeEmployerManager(VerificationCodeEmployerDao verificationCodeEmployerDao) {
	        this.verificationCodeEmployerDao = verificationCodeEmployerDao;
	    }

	    @Override
	    public Result add(VerificationCodeEmployer verificationCodeEmployer) {
	        verificationCodeEmployer.setVerified(false);
	        verificationCodeEmployer.setCode(generateCode());
	        verificationCodeEmployer.setVerifiedDate(LocalDate.now());
	        this.verificationCodeEmployerDao.save(verificationCodeEmployer);
	        return new SuccessResult("Verification Code Employer başarılı");
	    }

	    @Override
	    public Result update(VerificationCodeEmployer verificationCodeEmployer) {
	        return null;
	    }

	    @Override
	    public Result delete(VerificationCodeEmployer verificationCodeEmployer) {
	        return null;
	    }

	    @Override
	    public DataResult<List<VerificationCodeEmployer>> getAll() {
	        return new SuccessDataResult<List<VerificationCodeEmployer>>(this.verificationCodeEmployerDao.findAll());
	    }

	    @Override
	    public DataResult<VerificationCodeEmployer> getById(int id) {
	        return new SuccessDataResult<VerificationCodeEmployer>(this.verificationCodeEmployerDao.getById(id));
	    }

	    private String generateCode(){
	        UUID code = UUID.randomUUID();
	        return code.toString();
	    }
}
