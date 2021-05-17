package acme.testing;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

public class ShoutTest extends AcmePlannerTest{

	// Test cases -------------------------------------------------------------

		@ParameterizedTest
		@CsvFileSource(resources = "/shout/create-shout-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void positiveCreateShout(final String author, final String text, final String info) {
			super.clickOnMenu("Anonymous", "Create Shout");
			super.fill(By.id("author"), author);
			super.fill(By.id("text"), text);
			super.fill(By.id("info"), info);
			super.clickOnSubmitButton("Shout!");
		}
		
		@ParameterizedTest
		@CsvFileSource(resources = "/shout/create-shout-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void negativeCreateShout(final String author, final String text, final String info) {
			super.clickOnMenu("Anonymous", "Create Shout");
			super.fill(By.id("author"), author);
			super.fill(By.id("text"), text);
			super.fill(By.id("info"), info);
			super.clickOnSubmitButton("Shout!");
			
			super.checkErrorsExist();
		}
	
}
