package tasks;

import interactions.ClicProductoAleatorio;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import userInterface.OlxUserInterface;

public class BuscarProductoAleatorioEnOlx implements Task{

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Click.on(OlxUserInterface.BTN_CATEGORIA_MOTO_OLX),
				ClicProductoAleatorio.on()
				);		
	}

	
	public static BuscarProductoAleatorioEnOlx on() {
		return Instrumented.instanceOf(BuscarProductoAleatorioEnOlx.class).withProperties();
	}
}
