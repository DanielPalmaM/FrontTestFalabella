package cl.qa.pages;

import cl.qa.helpers.Ayuda;
import cl.qa.helpers.PageWebPrincipal;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Empresa extends PageWebPrincipal {

	// Atributos
	private final By labelTituloEmpresa;
	private final By labelIdentidadClM;
	private final By textIdentidadCLM;


	// Constructor
	public Empresa(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds) {
		super(driver, test, TAKE_SS, seconds);

		this.labelTituloEmpresa = By.xpath("//h2[contains(text(),'Empresa')]");
		this.labelIdentidadClM = By.xpath("//h1[contains(text(),'Identidad CLM')]");
		this.textIdentidadCLM = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]");

	}
	// Métodos

	/**
	 * Captura el titulo de la página empresa con su respectiva evidencia
	 * @param subDir
	 * @return
	 */
	public String captureLabelEmpresa( String subDir) {
		String labelEmpresa;
		labelEmpresa =wait.until(ExpectedConditions.visibilityOf(driver.findElement(labelTituloEmpresa))).getText();
		Ayuda.addEvidence(TAKE_SS, driver, test, "Empresa Page", subDir, "Empresa Page CLM");
		return labelEmpresa;

	}

	/**
	 * Captura el párrafo de identidad CLM con su respectiva evidencia
	 * @param subdir2
	 * @return
	 */
	public String captureIdentidadCLM( String subdir2){
		String textIdentidad;
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(labelIdentidadClM)));
		textIdentidad = wait.until(ExpectedConditions.visibilityOf(driver.findElement(textIdentidadCLM))).getText();
		Ayuda.addEvidence(TAKE_SS, driver, test, "Empresa Page - Identidad CLM", subdir2, "Identidad CLM");
		return textIdentidad;
	}
}
