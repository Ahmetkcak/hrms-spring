package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeDao extends JpaRepository<VerificationCode,Integer>{
    
	List<VerificationCode> getByIsVerified(boolean isVerified);
    VerificationCode getByCode(String code);
}
