package kodlamaio.hrms.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor	
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
@Table(name = "verification_code_candidates")

public class VerificationCodeCandidate extends VerificationCode{
	@OneToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
	private Candidate candidate;
}
