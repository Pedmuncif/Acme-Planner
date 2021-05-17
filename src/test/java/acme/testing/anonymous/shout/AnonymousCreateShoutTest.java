package acme.testing.anonymous.shout;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AnonymousCreateShoutTest extends AcmePlannerTest {
	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-shout-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveCreateShout(final String author, final String text, final String info) {
		super.clickOnMenu("Anonymous", "Create Shout");

		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
		
		super.clickOnSubmitButton("Shout!");
		
		super.checkNotErrorsExist();
		
		super.clickOnMenu("Anonymous", "List Shouts");
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-shout-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeCreateShout(final String author, final String text, final String info) {
		super.clickOnMenu("Anonymous", "Create Shout");
		
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
		
		super.clickOnSubmitButton("Shout!");
		
		super.checkErrorsExist();
	}

}
