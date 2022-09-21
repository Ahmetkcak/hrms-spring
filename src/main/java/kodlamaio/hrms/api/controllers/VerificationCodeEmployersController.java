package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.VerificationCodeEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.VerificationCodeEmployer;

@RestController
@RequestMapping("/api/verificationCodeEmployer")
public class VerificationCodeEmployersController {
	
	private VerificationCodeEmployerService verificationCodeEmployerService;

    @Autowired
    public VerificationCodeEmployersController( VerificationCodeEmployerService verificationCodeEmployerService) {
        this.verificationCodeEmployerService = verificationCodeEmployerService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(VerificationCodeEmployer verificationCodeEmployer) {
        return ResponseEntity.ok(this.verificationCodeEmployerService.add(verificationCodeEmployer));
    }

    @GetMapping("/getAll")
    public DataResult<List<VerificationCodeEmployer>> getAll() {
        return this.verificationCodeEmployerService.getAll();

    }

    @GetMapping("/getById")
    public DataResult<VerificationCodeEmployer> getById(int id) {
        return this.verificationCodeEmployerService.getById(id);
    }
}
