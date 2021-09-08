package acme.testing.anonymous.tasks;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class AnonymousListPublicNonFinishedTasksTest extends AcmeWorkPlansTest{
	
	/* ################################ AnonymousListPublicNonFinishedTasksTest ###################################
	 * 
	 *  Los siguientes atributos tienen las siguientes restricciones:
	 *  
	 * title: @NotEmpty(No puede estar vacío), @Length(max=80)(Tamaño máximo 80 crácteres).
	 * description: @NotBlank(No puede estar en blanco), @Length(max=500)(Tamaño máximo 500 crácteres).
	 * startMoment: @Temporal(TemporalType.TIMESTAMP), @NotNull(No puede ser nulo).
	 * finishMoment: @Temporal(TemporalType.TIMESTAMP), @NotNull(No puede ser nulo).
	 * workload: @Min(0)(Minimo valor=0), @Max(999)(Máximo valor=999).
	 * link: @URL(Formato de una url "http://www.....").
	 * status: @NotNull(No puede ser nulo).
	 * 
	 * Esta feature se encarga de mostrar para usuarios anónimos una lista de las tareas finalizadas. 
	 * Primero se comprueba que los valores en la lista estan bien, y luego comprueba que la tarea tenga cada atributo 
	 * cumpliendo con las restricciones comentadas anteriormente.
	 * Para el caso negativo, un usuario con rol no permitido no puede acceder a la lista de tareas no finalizadas. Solo los usuarios 
	 * anónimos pueden acceder.	  
	 */
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/task/list-public-task-nonfinished-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
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

	@Test
	@Order(10)
	public void accessNotAuthorised() {
				
		super.signIn("administrator", "administrator");
		super.navigate("/anonymous/task/list", null);
		super.checkPanicExists();
		}
}
