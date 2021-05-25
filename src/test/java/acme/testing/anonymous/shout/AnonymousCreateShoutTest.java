package acme.testing.anonymous.shout;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AnonymousCreateShoutTest extends AcmePlannerTest {
	



	/* ################################ AnonymousCreateShoutTest ###################################
	 * 
	 *  Los siguientes atributos tienen las siguientes restricciones:
	 *  
	 *  Author: No puede estar en blanco, el tamaño debe estar entre 5 y 25 caracteres.
	 *  Text: No puede estar en blanco, el tamaño máximo es 100 carácteres.
	 *  Info: @URL = Debe tener el formato de una url ("http://www....")
	 * 
	 *  En esta feature estamos comprobando la creación de shouts por un usuario anónimo. Se rellenan los campos comprobando que son válidos
	 *  y crea el shout correspondiente. Si comprobamos los casos positivos, creamos un banco de pruebas en el que todos los
	 *  parámetros cumplen las restricciones definidas anteriormente. Una vez creado el shout comprueba que se ha creado en la lista.
	 *  Para los casos negativos, se crea un banco de prueba en el que los parámetros no cumplan las restricciones definidas anteriormente.
	 *  
	 * 
	 */

	
	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-shout-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveCreateShout(final int recordIndex, final String author, final String text, final String info) {
	
		super.clickOnMenu("Anonymous", "Create Shout");
		
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
		
		super.clickOnSubmitButton("Shout!");		
		super.clickOnMenu("Anonymous", "List Shouts");
	
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);
		super.checkColumnHasValue(recordIndex, 3, info);
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
