package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService{
	
	private VerificationCodeDao verificationCodeDao;

    @Autowired
    public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
        this.verificationCodeDao = verificationCodeDao;

    }

    @Override
    public Result add(VerificationCode entity) {
        return null;
    }

    @Override
    public Result update(VerificationCode entity) {
        return null;
    }

    @Override
    public Result delete(VerificationCode entity) {
        return null;
    }

    @Override
    public DataResult<List<VerificationCode>> getAll() {
        return new SuccessDataResult<List<VerificationCode>>(verificationCodeDao.findAll());
    }

    @Override
    public DataResult<VerificationCode> getById(int id) {
        return new SuccessDataResult<VerificationCode>(verificationCodeDao.getById(id));
    }

    @Override
    public DataResult<List<VerificationCode>> getByIsVerified(boolean isVerified) {
        return new SuccessDataResult<List<VerificationCode>>(this.verificationCodeDao.getByIsVerified(isVerified));
    }

    @Override
    public DataResult<VerificationCode> getByCode(String code) {
        return new SuccessDataResult<VerificationCode>(this.verificationCodeDao.getByCode(code));
    }
}
