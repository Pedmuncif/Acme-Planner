package acme.dashboard;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Dashboard implements Serializable {

	protected static final long	serialVersionUID	= 1L;

	Integer		nTasksPublic;
	Integer		nTasksPrivate;
	Integer		nTasksFinished;
	Integer		nTasksNoFinished;
	
	Double		averageWorkload;
	Double		standardDeviationWorkload;
	Double		maxWorkload;
	Double		minWorkload;
	
	Double		averageExecutionPeriod;
	Double		standardDeviationExecutionPeriod;
	Integer		maxExecutionPeriod;
	Integer		minExecutionPeriod;
}
