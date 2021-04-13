package cl.qa.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.relevantcodes.extentreports.ExtentTest;
import cl.qa.helpers.Ayuda;
import cl.qa.helpers.PageWebPrincipal;

public class HomePage extends PageWebPrincipal {

	// Atributos
	private final By labelInicio;
	private final By serviciosMenu;
	private final By serviciosPruebasFuncionalesSubMenu;
	private final By serviciosPruebasRendimientoSubMenu;
	private final By serviciosPruebasMobileSubMenu;
	private final By recursosMenu;
	private final By empresaMenu;
	private final By contactoMenu;

	// Constructor

	/**
	 *
	 * @param driver
	 * @param test
	 * @param TAKE_SS
	 * @param seconds
	 */
	public HomePage(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds) {
		super(driver, test, TAKE_SS, seconds);

		this.labelInicio = By.xpath("//header/div[1]/div[2]/div[1]/nav[1]/ul[1]/li[1]/a[1]/span[1]");
		this.serviciosMenu = By.xpath("//header/div[1]/div[2]/div[1]/nav[1]/ul[1]/li[2]/a[1]/span[1]");
		this.serviciosPruebasFuncionalesSubMenu = By.xpath("//header/div[1]/div[2]/div[1]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]");
		this.serviciosPruebasRendimientoSubMenu = By.xpath("//header/div[1]/div[2]/div[1]/nav[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]");
		this.serviciosPruebasMobileSubMenu = By.xpath("//header/div[1]/div[2]/div[1]/nav[1]/ul[1]/li[2]/ul[1]/li[3]/a[1]");
		this.recursosMenu = By.xpath("//header/div[1]/div[2]/div[1]/nav[1]/ul[1]/li[3]/a[1]/span[1]");
		this.empresaMenu = By.xpath("//header/div[1]/div[2]/div[1]/nav[1]/ul[1]/li[4]/a[1]/span[1]");
		this.contactoMenu = By.xpath("//header/div[1]/div[2]/div[1]/nav[1]/ul[1]/li[5]/a[1]/span[1]");

	}
	// Métodos

	/**
	 *
	 * @param subDir
	 * @return
	 */
	public String captureLabelHomePage( String subDir) {
		String labelHomePage;
		labelHomePage =wait.until(ExpectedConditions.visibilityOf(driver.findElement(labelInicio))).getText();
		Ayuda.addEvidence(TAKE_SS, driver, test, "Home Page", subDir, "Home Page CLM");
		return labelHomePage;

	}

	/**
	 *
	 * @param subdir2
	 */
	public void clickSubMenuServicioPruebasFuncionales( String subdir2){
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(serviciosMenu))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(serviciosPruebasFuncionalesSubMenu))).click();
		Ayuda.addEvidence(TAKE_SS, driver, test, "Menu Pruebas Funcionales", subdir2, "Menu Servicios");
	}


	/**
	 * @param subdir3
	 */
	public void clickSubMenuServicioPruebasRendimiento( String subdir3){
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(serviciosMenu))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(serviciosPruebasRendimientoSubMenu))).click();
		Ayuda.addEvidence(TAKE_SS, driver, test, "Menu Pruebas Rendimiento", subdir3, "Menu Servicios");
	}

	/**
	 * @param subdir4
	 */
	public void clickSubMenuServicioPruebasMobile( String subdir4){
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(serviciosMenu))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(serviciosPruebasMobileSubMenu))).click();
		Ayuda.addEvidence(TAKE_SS, driver, test, "Menu Pruebas Mobile", subdir4, "Menu Servicios");
	}

	/**
	 * @param subdir5
	 */
	public void clickMenuRecursos( String subdir5){
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(recursosMenu))).click();
		Ayuda.addEvidence(TAKE_SS, driver, test, "Menu Recursos", subdir5, "Menu Recursos");
	}

	/**
	 *
	 * @param subdir6
	 */
	public void clickMenuEmpresa( String subdir6){
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(empresaMenu))).click();
		Ayuda.addEvidence(TAKE_SS, driver, test, "Menu Empresa", subdir6, "Menu Empresa");
	}

	/**
	 *
	 * @param subdir7
	 */
	public void clickMenuContacto( String subdir7){
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(contactoMenu))).click();
		Ayuda.addEvidence(TAKE_SS, driver, test, "Menu Contacto", subdir7, "Menu Contacto");
	}
}
