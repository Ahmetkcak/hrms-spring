package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService extends BaseEntityService<VerificationCode>{
	DataResult<List<VerificationCode>> getByIsVerified(boolean isVerified);
    DataResult<VerificationCode> getByCode(String code);
}
