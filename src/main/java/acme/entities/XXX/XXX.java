package acme.entities.XXX;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
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
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@Pattern(regexp = "yyyy/MM/dd")
	protected Date fecha;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	protected Date moment;
	
	@Valid
	@NotNull
	protected Money amount;
	
	protected Boolean flag;
	
}
