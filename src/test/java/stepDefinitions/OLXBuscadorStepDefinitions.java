package stepDefinitions;

import java.io.IOException;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import driver.SeleniumWebDriver;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import tasks.BuscarProductoEnOlx;
import userInterface.OlxUserInterface;

public class OLXBuscadorStepDefinitions {

	@Before
	public void before() throws IOException {
		OnStage.setTheStage(new OnlineCast());
	}
	
	@Given("^que me encuentro en la pagina de OLX con la url (.*)$")
	public void queMeEncuentroEnLaPaginaDeOLXConLaUrlHttpsWwwOlxComCo(String url) {
		OnStage.theActorCalled("Duvan").can(BrowseTheWeb.with(SeleniumWebDriver.ChromeWebDriver().on(url)));
	}

	@When("^busco el producto (.*) en el buscador$")
	public void buscoElProudctoEnElBuscador(String producto) {
		OnStage.theActorInTheSpotlight().attemptsTo(BuscarProductoEnOlx.on(producto));
	}

	@Then("^podre ver el producto (.*) en pantalla$")
	public void podreVerElProductoEnPantalla(String producto) {
		OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion.the(OlxUserInterface.LBL_PRODUCTO_OLX.of(producto)), WebElementStateMatchers.containsText(producto)));
	}
}
