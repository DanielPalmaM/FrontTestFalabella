package cl.qa.pages;

import cl.qa.helpers.Ayuda;
import cl.qa.helpers.PageWebPrincipal;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Recursos extends PageWebPrincipal {

	// Atributos
	private final By labelTituloRecursos;
	private final By textBusqueda;
	private final By buttonBusqueda;
	private final By labelResultadoBusqueda;


	// Constructor
	public Recursos(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds) {
		super(driver, test, TAKE_SS, seconds);

		this.labelTituloRecursos = By.xpath("//h2[contains(text(),'Recursos')]");
		this.textBusqueda = By.xpath("//body/div[@id='wrapper']/main[@id='main']/div[1]/aside[1]/section[1]/form[1]/div[1]/div[1]/input[1]");
		this.buttonBusqueda = By.xpath("//body/div[@id='wrapper']/main[@id='main']/div[1]/aside[1]/section[1]/form[1]/div[1]/div[2]/input[1]");
		this.labelResultadoBusqueda = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/h1[1]");

	}

	// Métodos

	/**
	 *
	 * @param subDir
	 * @return
	 */
	public String captureLabelRecursos( String subDir) {
		String labelRecursos;
		labelRecursos =wait.until(ExpectedConditions.visibilityOf(driver.findElement(labelTituloRecursos))).getText();
		Ayuda.addEvidence(TAKE_SS, driver, test, "Recursos Page", subDir, "Recursos Page CLM");
		return labelRecursos;

	}

	/**
	 *
	 * @param subdir2
	 * @param busqueda
	 */
	public void clickBusquedaRecursos( String subdir2, String busqueda){
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(textBusqueda))).sendKeys(busqueda);
		Ayuda.addEvidence(TAKE_SS, driver, test, "Recursos Page - Busqueda", subdir2, "Busqueda de Recursos");
		driver.findElement(buttonBusqueda).click();
	}

	/**
	 *
	 * @param subdir3
	 * @return
	 */
	public String captureLabelResultadoBusqueda( String subdir3){
		String labelBusquedaRecursos;
		labelBusquedaRecursos =wait.until(ExpectedConditions.visibilityOf(driver.findElement(labelResultadoBusqueda))).getText();
		Ayuda.addEvidence(TAKE_SS, driver, test, "Recursos Page - Resultado Busqueda", subdir3, "Titulo Resultado de la Busqueda");
		return labelBusquedaRecursos;
	}
}
