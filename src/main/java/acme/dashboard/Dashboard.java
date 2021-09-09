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
	Integer		maxWorkload;
	Integer		minWorkload;
	
	Double		averageExecutionPeriod;
	Double		standardDeviationExecutionPeriod;
	Integer		maxExecutionPeriod;
	Integer		minExecutionPeriod;
	
	
	Double 	    nShoutImportant;
	Double 		averageShoutaverageEur;
	Double 		stdevpShoutaverageEur;
	Double 		stdevpShoutaverageUSD;
	Double 		averageShoutaverageUSD;
	Double 		averageShoutaverageGbp;
	Double 		stdevpShoutaverageGbp;
	Double 		nShoutbudget;
}