package acme.testing;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SignUpTest extends AcmePlannerTest {
	// Test cases -------------------------------------------------------------
/*
	@ParameterizedTest
	@CsvFileSource(resources = "/sign-up/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveSignUp(final String username, final String password, final String name, final String surname, final String email) {
		this.signUp(username, password, name, surname, email);
		this.signIn(username, password);
		assert super.exists(By.linkText("Account"));
		this.signOut();
	}
	*/
	
	@ParameterizedTest
	@CsvFileSource(resources = "/sign-up/negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeSignUp(final String username, final String password, final String name, final String surname, final String email) {
		super.navigateHome();
		super.clickOnMenu("Sign up", null);
		super.fillInputBoxIn("username", username);
		super.fillInputBoxIn("password", password);
		super.fillInputBoxIn("confirmation", password);
		super.fillInputBoxIn("identity.name", name);
		super.fillInputBoxIn("identity.surname", surname);
		super.fillInputBoxIn("identity.email", email);
		super.fillInputBoxIn("accept","true");
		super.clickOnSubmitButton("Sign up");
		super.checkErrorsExist();
		
		
	}
}