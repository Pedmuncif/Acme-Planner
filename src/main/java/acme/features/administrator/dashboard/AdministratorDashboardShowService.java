package acme.features.administrator.dashboard;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.dashboard.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	protected AdministratorDashboardRepository repository;

	
	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model,"nTasksPublic", "nTasksPrivate","nTasksFinished", "nTasksNoFinished", "averageWorkload","standardDeviationWorkload",
			"maxWorkload","minWorkload","averageExecutionPeriod","standardDeviationExecutionPeriod","maxExecutionPeriod","minExecutionPeriod",
			"averageShoutaverageEur","stdevpShoutaverageEur","stdevpShoutaverageUSD","averageShoutaverageUSD","averageShoutaverageGbp","stdevpShoutaverageGbp","nShoutImportant","nShoutbudget");

		
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result;
		final Integer		nTasksPublic;
		final Integer		nTasksPrivate;
		final Integer		nTasksFinished;
		final Integer		nTasksNoFinished;
		
		final Double		averageWorkload;
		final Double		standardDeviationWorkload;
		final Integer		maxWorkload;
		final Integer		minWorkload;
		
		final Double		averageExecutionPeriod;
		final Double		standardDeviationExecutionPeriod;
		final Integer		maxExecutionPeriod;
		final Integer		minExecutionPeriod;

		final Double nShoutImportant;
		final Double stdevpShoutaverageEur;
		final Double averageShoutaverageEur;
		final Double stdevpShoutaverageUSD;
		final Double averageShoutaverageUSD;
		final Double stdevpShoutaverageGbp;
		final Double averageShoutaverageGbp;
		final Double nShoutbudget;
		
		
		Calendar calendar;
		calendar = Calendar.getInstance();
		final Date now = calendar.getTime();
		
		
		nTasksPublic = this.repository.nTasksPublic();
		nTasksPrivate = this.repository.nTasksPrivate();
		nTasksFinished = this.repository.findTaskFinished(now);
		nTasksNoFinished = this.repository.findTaskNonFinished(now);
		
		averageWorkload = this.repository.averageTaskWorkload();
		standardDeviationWorkload = this.repository.stdevpTaskWorkload();
		maxWorkload = this.repository.maxTaskWorkload();
		minWorkload = this.repository.minTaskWorkload();
		
		averageExecutionPeriod = this.repository.averageTaskExecutionPeriod();
		standardDeviationExecutionPeriod = this.repository.stdevpTaskExecutionPeriod();
		maxExecutionPeriod = this.repository.maxTaskExecutionPeriod();
		minExecutionPeriod = this.repository.minTaskExecutionPeriod();
		
		nShoutImportant = this.repository.nShoutImportant();
		stdevpShoutaverageEur = this.repository.stdevpShoutaverageEur();
		averageShoutaverageEur = this.repository.averageShoutaverageEur();
		stdevpShoutaverageUSD = this.repository.stdevpShoutaverageUSD();
		averageShoutaverageUSD = this.repository.averageShoutaverageUSD();
		stdevpShoutaverageGbp = this.repository.stdevpShoutaverageGbp();
		averageShoutaverageGbp = this.repository.averageShoutaverageGbp();
		nShoutbudget = this.repository.nShoutbudget();
		
		result = new Dashboard();
		
		result.setNTasksPublic(nTasksPublic);
		result.setNTasksPrivate(nTasksPrivate);
		result.setNTasksFinished(nTasksFinished);
		result.setNTasksNoFinished(nTasksNoFinished);
		
		result.setAverageWorkload(averageWorkload);
		result.setStandardDeviationWorkload(standardDeviationWorkload);
		result.setMaxWorkload(maxWorkload);
		result.setMinWorkload(minWorkload);
		
		result.setAverageExecutionPeriod(averageExecutionPeriod);
		result.setStandardDeviationExecutionPeriod(standardDeviationExecutionPeriod);
		result.setMaxExecutionPeriod(maxExecutionPeriod);
		result.setMinExecutionPeriod(minExecutionPeriod);
		
		
		result.setNShoutImportant(nShoutImportant);
		result.setStdevpShoutaverageEur(stdevpShoutaverageEur);
		result.setAverageShoutaverageEur(averageShoutaverageEur);
		result.setStdevpShoutaverageUSD(stdevpShoutaverageUSD);
		result.setAverageShoutaverageUSD(averageShoutaverageUSD);
		result.setStdevpShoutaverageGbp(stdevpShoutaverageGbp);
		result.setAverageShoutaverageGbp(averageShoutaverageGbp);
		
		result.setNShoutbudget(nShoutbudget);
		
		
		return result;

	}

}