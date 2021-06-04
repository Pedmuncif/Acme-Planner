package acme.entities.XXX;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
	@NotNull
	@DateTimeFormat(pattern="^\\d{4}/\\d{2}/\\d{2}$")
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
