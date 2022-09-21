package kodlamaio.hrms.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeConfirmEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.EmployeeConfirmEmployer;

@RestController
@RequestMapping("/api/employeeConfirmEmployers")
public class EmployeeConfirmEmployersController {
	
	private EmployeeConfirmEmployerService employeeConfirmEmployerService;

    public EmployeeConfirmEmployersController(EmployeeConfirmEmployerService employeeConfirmEmployerService) {
        this.employeeConfirmEmployerService = employeeConfirmEmployerService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(EmployeeConfirmEmployer employeeConfirmEmployer){
        return ResponseEntity.ok(this.employeeConfirmEmployerService.add(employeeConfirmEmployer));
    }
    @GetMapping("/getById")
    public DataResult<EmployeeConfirmEmployer> getById(int id) {
        return this.employeeConfirmEmployerService.getById(id);
    }

    @GetMapping("/getByEmployeeFirstNameAndEmployerCompanyName")
    public DataResult<EmployeeConfirmEmployer> getByEmployee_FirstNameAndEmployer_CompanyName(String employeeFirstName, String employerCompanyName) {
        return this.employeeConfirmEmployerService.getByEmployee_FirstNameAndEmployer_CompanyName(employeeFirstName,employerCompanyName);
    }
}
