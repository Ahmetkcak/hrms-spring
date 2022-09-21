package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;

public interface AuthService {
	 Result registerEmployee(Employee employee, String confirmPassword);
	 Result registerEmployer(Employer employer, String confirmPassword);
	 Result registerCandidate(Candidate candidate, String confirmPassword);
}
