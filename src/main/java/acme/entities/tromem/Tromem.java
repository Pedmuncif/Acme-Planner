package acme.entities.tromem;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tromem extends DomainEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	@NotBlank
	protected String keylet;
	
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@Valid
	protected Date deadline;
	
	
	@NotNull
	@Valid
	protected Money budget;
	
	@NotNull
	protected Boolean important;
	
}
