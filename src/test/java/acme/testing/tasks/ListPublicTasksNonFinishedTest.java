package acme.testing.tasks;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class ListPublicTasksNonFinishedTest extends AcmePlannerTest{
	
	
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
	}
}
