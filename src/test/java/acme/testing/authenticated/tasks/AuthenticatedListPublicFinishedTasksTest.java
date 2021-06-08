package acme.testing.authenticated.tasks;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

public class AuthenticatedListPublicFinishedTasksTest extends AcmePlannerTest{
	
	/* ################################ AuthenticatedListPublicFinishedTasksTest ###################################
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
	 * Esta feature se encarga de mostrar para usuarios autenticados una lista de las tareas finalizadas. 
	 * Primero se comprueba que los valores en la lista estan bien, y luego comprueba que la tarea tenga cada atributo 
	 * cumpliendo con las restricciones comentadas anteriormente.
	 * Para el caso negativo, un usuario con rol no permitido no puede acceder a la lista de tareas finalizadas. Solo los usuarios 
	 * autenticados pueden acceder.
	 * 
	 * 
	 */
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/task/list-task-public-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
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

	@Test
	@Order(10)
	public void accessNotAuthorised() {
				
		super.navigate("/authenticated/task/list", null);
		super.checkPanicExists();
		}
}
