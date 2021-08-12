package stepDefinitions;

import java.io.IOException;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import tasks.BuscarProductoAleatorioEnOlx;
import userInterface.OlxUserInterface;
import variablesGlobales.VariablesGlobales;

public class OLXBuscadorAleatorioStepDefinitions {

	@Before
	public void before() throws IOException {
		OnStage.setTheStage(new OnlineCast());
	}

	@When("^busco un producto aleatorio en la pagina$")
	public void buscoUnProductoAleatorioEnLaPagina() {
		OnStage.theActorInTheSpotlight().attemptsTo(BuscarProductoAleatorioEnOlx.on());
	}

	@Then("^podre ver un producto aleatorio en pantalla$")
	public void podreVerUnProductoAleatorioEnPantalla() {
		OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(OlxUserInterface.LBL_PRODUCTO_OLX.of(VariablesGlobales.nombreProductoAleatorio)), WebElementStateMatchers.containsText(VariablesGlobales.nombreProductoAleatorio)));
	}
}
