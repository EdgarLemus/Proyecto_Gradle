package userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class OlxUserInterface {

	public static final Target TXT_BUSCADOR_OLX = Target.the("El campo donde se realiza la busque del producto").locatedBy("//input[contains(@placeholder,'Encuentra')]");
	public static final Target BTN_BUSCADOR_OLX = Target.the("").locatedBy("//div[@data-aut-id='btnSearch']");
	public static final Target BTN_PRODUCTO_OLX = Target.the("").locatedBy("//span[contains(text(),'{0}')]//ancestor::a");
	public static final Target LBL_PRODUCTO_OLX = Target.the("").locatedBy("//h1[contains(text(),'{0}')]");
	public static final Target BTN_CATEGORIA_MOTO_OLX = Target.the("").locatedBy("//div[@class='_2xg5B']//span[text()='Motos']//ancestor::a");
	public static final Target BTN_PRODUCTO_ALEATORIO_OLX = Target.the("").locatedBy("//li[@data-aut-id='itemBox']//a");
	public static final Target LBL_NOMBRE_PRODUCTO_ALEATORIO_OLX = Target.the("").locatedBy("//li[@data-aut-id='itemBox']//a//span[@data-aut-id='itemTitle']");
}
