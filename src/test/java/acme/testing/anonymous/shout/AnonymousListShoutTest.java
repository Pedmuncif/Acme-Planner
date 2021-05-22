package acme.testing.anonymous.shout;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AnonymousListShoutTest extends AcmePlannerTest {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/shout/list-shout.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listAllShouts(final int recordIndex,final String moment, final String author, final String text, final String info) {
		super.clickOnMenu("Anonymous", "List Shouts");
		
		super.checkColumnHasValue(recordIndex, 0, moment);
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);
		super.checkColumnHasValue(recordIndex, 3, info);
	}
}
