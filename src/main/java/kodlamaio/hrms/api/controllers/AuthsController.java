package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/auths")
public class AuthsController {
	
	AuthService authService;

    @Autowired
    public AuthsController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registerEmployee")
    public ResponseEntity<?> registerEmployee(Employee employee, String confirmPassword){
        return ResponseEntity.ok(this.authService.registerEmployee(employee, confirmPassword));
    }

    @PostMapping("/registerEmployer")
    public ResponseEntity<?> registerEmployer(Employer employer, String confirmPassword) {
        return ResponseEntity.ok(this.authService.registerEmployer(employer, confirmPassword));
    }

    @PostMapping("/registerCandidate")
    public ResponseEntity<?> registerCandidate(Candidate candidate, String confirmPassword) {
        return ResponseEntity.ok(this.authService.registerCandidate(candidate, confirmPassword));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors = new ErrorDataResult<>(validationErrors, "Doğrulama hataları");
        return errors;
    }
}
