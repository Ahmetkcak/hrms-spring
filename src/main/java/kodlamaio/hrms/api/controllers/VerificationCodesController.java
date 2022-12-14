package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@RestController
@RequestMapping("/api/verificationCodes")
public class VerificationCodesController {
	
	private VerificationCodeService verificationCodeService;

	@Autowired
	public VerificationCodesController(VerificationCodeService verificationCodeService) {
		super();
		this.verificationCodeService = verificationCodeService;
	}
	
	 @GetMapping("/getAll")
	    public DataResult<List<VerificationCode>> getAll() {
	        return verificationCodeService.getAll();
	    }

	 @GetMapping("/getById")
	 	public DataResult<VerificationCode> getById(int id) {
	        return verificationCodeService.getById(id);
	    }
}
