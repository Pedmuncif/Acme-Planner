package acme.testing.authenticated.tasks;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AuthenticatedListPublicFinishedTasksTest extends AcmePlannerTest{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/task/list-task-public-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listShowAuthenticatedPublicFinishedTasks(final int recordIndex, final String title, final String description, final String startMoment, 
		final String finishMoment, final String workload, final String link, final String status) {
		
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Authenticated", "List finished tasks");
		
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, description);
		super.checkColumnHasValue(recordIndex, 2, startMoment);
		super.checkColumnHasValue(recordIndex, 3, finishMoment);
		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("startMoment", startMoment);
		super.checkInputBoxHasValue("finishMoment", finishMoment);
		super.checkInputBoxHasValue("workload", workload);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("status", status);
		
		super.signOut();

	}

}
