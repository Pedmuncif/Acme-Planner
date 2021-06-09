package acme.entities.XXX;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class XXX extends DomainEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "^21-\\w{2}\\w{2}-0609$", message = "anonymous.xxx.error.pattern")
	protected String fecha;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date moment;
	
	@Valid
	@NotNull
	protected Money amount;
	
	@NotNull
	protected Boolean flag;
	
}
