package cl.qa.pages;

import cl.qa.helpers.Ayuda;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentTest;

import cl.qa.helpers.PageWebPrincipal;

public class ServiciosPruebasFuncionales extends PageWebPrincipal {

	// Atributos
	private final By labelTitulo;
	private final By buttonContactanos;
	private final By textQuieroSaberMas;


	// Constructor
	public ServiciosPruebasFuncionales(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds) {
		super(driver, test, TAKE_SS, seconds);
		// TODO Auto-generated constructor stub
		this.labelTitulo = By.xpath("//h1[contains(text(),'Pruebas Funcionales')]");
		this.buttonContactanos = By.xpath("//span[contains(text(),'Contáctanos')]");
		this.textQuieroSaberMas = By.xpath("//p[contains(text(),'¿Qué contempla el servicio de Pruebas Funcionales?')]");


	}

	// Mëtodos

	/**
	 *
	 * @param subDir
	 * @return
	 */
	public String captureLabelServiciosPruebasFuncionales( String subDir) {
		String labelHomePage;
		labelHomePage =wait.until(ExpectedConditions.visibilityOf(driver.findElement(labelTitulo))).getText();
		Ayuda.addEvidence(TAKE_SS, driver, test, "Pruebas Funcionales Page", subDir, "Servicios CLM");
		return labelHomePage;

	}

	/**
	 *
	 * @param subDir
	 */
	public void clickButtonContactanos( String subDir) {
		WebElement Element;
		Element = driver.findElement(textQuieroSaberMas);
		Ayuda.downScrollBarUntilElement(driver, Element);
		Ayuda.addEvidence(TAKE_SS, driver, test, "Boton Contactanos", subDir, "Servicios CLM");
		driver.findElement(buttonContactanos).click();
	}
}
