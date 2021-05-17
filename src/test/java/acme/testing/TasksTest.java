package acme.testing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

public class TasksTest extends AcmeTest{
	
	@Override
	@BeforeAll
	public void beforeAll() {
		super.beforeAll();

		super.setBaseCamp("http", "localhost", "8080", "/Acme-Planner", "/master/welcome", "?language=en&debug=true");
		super.setAutoPausing(true);
		

	}
	@ParameterizedTest
	@CsvFileSource(resources = "/tasks/list-public-task-nonfinished-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listPublicTasksNonFinished(final int recordIndex, final String title, final String description, final String startMoment, 
		final String finishMoment, final String workload, final String link, final String status) {

		super.clickOnMenu("Anonymous", "List non-finished Tasks");

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
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/tasks/positive2.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listShowAuthenticatedPublicFinishedTasks(final int recordIndex, final String title, final String description, final String startMoment, 
		final String finishMoment, final String workload, final String link, final String status) {
		
		this.signIn("administrator", "administrator");
		
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
		
		this.signOut();

	}

	protected void signIn(final String username, final String password) {
		super.navigateHome();
		super.click(By.linkText("Sign in"));
		super.fill(By.id("username"), username);
		super.fill(By.id("password"), password);
		super.click(By.id("remember$proxy"));
		super.submit(By.className("btn-primary"));
	}

	protected void signOut() {
		super.navigateHome();
		super.submit(By.linkText("Sign out"));
	}
}
