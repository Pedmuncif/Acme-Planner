package acme.testing.anonymous.shout;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class AnonymousListShoutTest extends AcmeWorkPlansTest {
	
	/* ################################ AnonymousListShoutTest ###################################
	 * 
	 *  Los siguientes atributos tienen las siguientes restricciones:
	 *  
	 *  Author: No puede estar en blanco, el tamaño debe estar entre 5 y 25 caracteres.
	 *  Text: No puede estar en blanco, el tamaño máximo es 100 carácteres.
	 *  Info: @URL = Debe tener el formato de una url ("http://www....")
	 * 
	 * En esta feature estamos comprobando que los shouts que estan en la lista están bien añadidos checkeando cada atributo con las
	 * restricciones definidas para cada uno.
	 *  
	 * 
	 */
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/list-shout.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listAllShouts(final int recordIndex,final String moment, final String author, final String text, final String info,final String keylet,
		final String budget,final String important) {
		super.clickOnMenu("Anonymous", "List Shouts");
		
		super.checkColumnHasValue(recordIndex, 0, moment);
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);
		super.checkColumnHasValue(recordIndex, 3, info);
		super.checkColumnHasValue(recordIndex, 4, keylet);
		super.checkColumnHasValue(recordIndex, 5, budget);
		super.checkColumnHasValue(recordIndex, 6, important);
	
	}
}
