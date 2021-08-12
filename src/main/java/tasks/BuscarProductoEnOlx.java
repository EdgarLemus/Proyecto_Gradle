package tasks;

import interactions.Esperar;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userInterface.OlxUserInterface;
import variablesGlobales.VariablesGlobales;

public class BuscarProductoEnOlx implements Task{
	
	private String producto;

	public BuscarProductoEnOlx(String producto) {
		this.producto = producto;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Enter.theValue(producto).into(OlxUserInterface.TXT_BUSCADOR_OLX),
				Click.on(OlxUserInterface.BTN_BUSCADOR_OLX),
				Click.on(OlxUserInterface.BTN_PRODUCTO_OLX.of(producto)),
				Esperar.estosSegundos(30)
				);
		VariablesGlobales.nombreProductoAleatorio = OlxUserInterface.LBL_PRODUCTO_OLX.of(producto).resolveFor(actor).getText();
	}

	public static BuscarProductoEnOlx on(String producto) {
		return Instrumented.instanceOf(BuscarProductoEnOlx.class).withProperties(producto);
	}
}
