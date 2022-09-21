package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.VerificationCodeCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.VerificationCodeCandidate;

@RestController
@RequestMapping("/api/verificationCodeCandidate")
public class VerificationCodeCandidatesController {
	
	private VerificationCodeCandidateService verificationCodeCandidateService;

    @Autowired
    public VerificationCodeCandidatesController(VerificationCodeCandidateService verificationCodeCandidateService) {
        this.verificationCodeCandidateService = verificationCodeCandidateService;
    }

    @GetMapping("/getAll")
    public DataResult<List<VerificationCodeCandidate>> getAll() {
        return this.verificationCodeCandidateService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<VerificationCodeCandidate> getById(@RequestParam int id) {
        return this.verificationCodeCandidateService.getById(id);
    }
}
