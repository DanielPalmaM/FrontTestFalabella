package cl.qa.pages;

import cl.qa.helpers.Ayuda;
import cl.qa.helpers.PageWebPrincipal;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ServiciosPruebasRendimiento extends PageWebPrincipal {

	// Atributos
	private final By labelPruebaRendimiento;
	private final By textQueContempla;
	private final By buttonContactanos;


	// Constructor
	public ServiciosPruebasRendimiento(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds) {
		super(driver, test, TAKE_SS, seconds);

		this.labelPruebaRendimiento = By.xpath("//h1[contains(text(),'Pruebas de Rendimiento')]");
		this.textQueContempla = By.xpath("//p[contains(text(),'¿Qué contempla el servicio de pruebas rendimiento?')]");
		this.buttonContactanos = By.xpath("//span[contains(text(),'Contáctanos')]");

	}

	// Métodos

	/**
	 *
	 * @param subDir
	 * @return
	 */
	public String captureLabelServiciosPruebasRendimiento( String subDir) {
		String labelRendimiento;
		labelRendimiento =wait.until(ExpectedConditions.visibilityOf(driver.findElement(labelPruebaRendimiento))).getText();
		Ayuda.addEvidence(TAKE_SS, driver, test, "Pruebas Rendimiento Page", subDir, "Servicios CLM");
		return labelRendimiento;

	}

	/**
	 *
	 * @param subDir
	 */
	public void clickButtonContactanos( String subDir) {
		WebElement Element;
		Element = driver.findElement(textQueContempla);
		Ayuda.downScrollBarUntilElement(driver, Element);
		Ayuda.addEvidence(TAKE_SS, driver, test, "Boton Contactanos", subDir, "Servicios CLM");
		driver.findElement(buttonContactanos).click();
	}

}
