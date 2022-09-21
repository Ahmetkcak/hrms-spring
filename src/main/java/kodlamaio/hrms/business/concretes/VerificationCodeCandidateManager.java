package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationCodeCandidateService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeCandidateDao;
import kodlamaio.hrms.entities.concretes.VerificationCodeCandidate;

@Service
public class VerificationCodeCandidateManager implements VerificationCodeCandidateService{
	
	private VerificationCodeCandidateDao verificationCodeCandidateDao;
	
    @Autowired
    public VerificationCodeCandidateManager(VerificationCodeCandidateDao verificationCodeCandidateDao, VerificationCodeService verificationCodeService) {
        this.verificationCodeCandidateDao = verificationCodeCandidateDao;
    }

    @Override
    public Result add(VerificationCodeCandidate verificationCodeCandidate) {
        verificationCodeCandidate.setVerified(false);
        verificationCodeCandidate.setCode(generateCode());
        verificationCodeCandidate.setVerifiedDate(LocalDate.now());
        this.verificationCodeCandidateDao.save(verificationCodeCandidate);
        return new SuccessResult("Verification Code Candidate başarılı");
    }

    @Override
    public Result update(VerificationCodeCandidate verificationCodeCandidate) {
        return null;
    }

    @Override
    public Result delete(VerificationCodeCandidate verificationCodeCandidate) {
        return null;
    }

    @Override
    public DataResult<List<VerificationCodeCandidate>> getAll() {
        return new SuccessDataResult<List<VerificationCodeCandidate>>(this.verificationCodeCandidateDao.findAll());
    }

    @Override
    public DataResult<VerificationCodeCandidate> getById(int id) {
        return new SuccessDataResult<VerificationCodeCandidate>(this.verificationCodeCandidateDao.getById(id));
    }

    private String generateCode() {
        UUID code = UUID.randomUUID();

        return code.toString();
    }
}
