package acme.testing.administrator.dashboard;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AdministratorDashboardTest extends AcmePlannerTest{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/dashboard-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void showAdministratorDashboardPositive(final String nTasksPublic, final String nTasksPrivate, final String nTasksFinished, 
		final String nTasksNoFinished, final String averageWorkload, final String standardDeviationWorkload, final String maxWorkload, final String minWorkload, 
		final String averageExecutionPeriod, final String standardDeviationExecutionPeriod, final String maxExecutionPeriod, final String minExecutionPeriod) {
		
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Dashboard");
		super.checkNotPanicExists();
		super.checkInputBoxHasValue("nTasksPublic", nTasksPublic);
		super.checkInputBoxHasValue("nTasksPrivate", nTasksPrivate);
		super.checkInputBoxHasValue("nTasksFinished", nTasksFinished);
		super.checkInputBoxHasValue("nTasksNoFinished", nTasksNoFinished);
		super.checkInputBoxHasValue("averageWorkload", averageWorkload);
		super.checkInputBoxHasValue("standardDeviationWorkload", standardDeviationWorkload);
		super.checkInputBoxHasValue("maxWorkload", maxWorkload);
		super.checkInputBoxHasValue("minWorkload", minWorkload);
		super.checkInputBoxHasValue("averageExecutionPeriod", averageExecutionPeriod);
		super.checkInputBoxHasValue("standardDeviationExecutionPeriod", standardDeviationExecutionPeriod);
		super.checkInputBoxHasValue("maxExecutionPeriod", maxExecutionPeriod);
		super.checkInputBoxHasValue("minExecutionPeriod", minExecutionPeriod);
		super.signOut();
	}
}
