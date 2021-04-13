package cl.qa.pages;

import cl.qa.helpers.Ayuda;
import cl.qa.helpers.PageWebPrincipal;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Contacto extends PageWebPrincipal {

	// Atributos
	private final By labelContactanos;
	private final By textBoxNombre;
	private final By textBoxEmail;
	private final By textBoxTelefono;
	private final By textBoxEmpresa;
	private final By textBoxCargo;
	private final By selectServicioInteres;
	private final By textBoxConsulta;
	private final By buttonEnviar;
	private final By labelRepuestaFormulario;
	private final By labelRepuestaFormularioFallida;

	// Constructor
	public Contacto(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds) {
		super(driver, test, TAKE_SS, seconds);

		this.labelContactanos = By.xpath("//h2[contains(text(),'Contáctanos')]");
		this.textBoxNombre = By.xpath("//body/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]/span[1]/input[1]");
		this.textBoxEmail = By.xpath("//body/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]/span[2]/input[1]");
		this.textBoxTelefono = By.xpath("//body/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]/span[3]/input[1]");
		this.textBoxEmpresa = By.xpath("//body/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]/span[4]/input[1]");
		this.textBoxCargo = By.xpath("//body/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]/span[5]/input[1]");
		this.selectServicioInteres = By.xpath("//body/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]/span[6]/div[1]/select[1]");
		this.textBoxConsulta = By.xpath("//body/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]/span[7]/textarea[1]");
		this.buttonEnviar = By.xpath("//body/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]/input[1]");
		this.labelRepuestaFormulario = By.xpath("//*[@class = 'wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ok fusion-alert']");
		this.labelRepuestaFormularioFallida = By.xpath("//body/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]");
	}

	// Métodos

	/**
	 * captura el texto del titulo de la página de contacto con su respectiva evidencia
	 * @param subDir
	 * @return
	 */
	public String captureLabelContacto( String subDir) {
		String labelContacto;
		labelContacto =wait.until(ExpectedConditions.visibilityOf(driver.findElement(labelContactanos))).getText();
		Ayuda.addEvidence(TAKE_SS, driver, test, "Home Page", subDir, "Home Page CLM");
		return labelContacto;

	}

	/**
	 * Ingresa texto en campo nombre
	 * @param nombreCompleto
	 */
	public void ingresaNombre(String nombreCompleto){

		driver.findElement(textBoxNombre).sendKeys(nombreCompleto);
	}

	/**
	 * Ingresa texto en campo email
	 * @param email
	 */
	public void ingresaEmail(String email){
		driver.findElement(textBoxEmail).sendKeys(email);
	}

	/**
	 * Ingresa texto en campo teléfono
	 * @param telefono
	 */
	public void ingresaTelefono(String telefono){
		driver.findElement(textBoxTelefono).sendKeys(telefono);
	}

	/**
	 * Ingresa texto en campo empresa
	 * @param empresa
	 */
	public void ingresaEmpresa(String empresa){
		driver.findElement(textBoxEmpresa).sendKeys(empresa);
	}

	/**
	 * Ingresa texto en campo cargo
	 * @param cargo
	 */
	public void ingresaCargo(String cargo){
		driver.findElement(textBoxCargo).sendKeys(cargo);
	}

	/**
	 * Selecciona servicio de interés en selector de listado desplegable
	 * @param servicioInteres
	 */
	public void seleccionaServicioInteres(String servicioInteres){
		Select selectServicio = new Select(driver.findElement(selectServicioInteres));
		selectServicio.selectByVisibleText(servicioInteres);
	}

	/**
	 * Ingresa texto en campo Consulta
	 * @param consulta
	 */
	public void ingresaConsulta(String consulta){
		driver.findElement(textBoxConsulta).sendKeys(consulta);

	}

	/**
	 * Presiona el boton enviar del formulario para realizar consulta
	 */
	public void presionaBotonEnviar(){
		driver.findElement(buttonEnviar).click();
	}

	/**
	 * Captura texto de etiqueta de respuesta del formulario si fue exitoso el envío
	 * @param subDir2
	 * @return
	 */
	public String captureLabelRespuestaFormularioExitosa( String subDir2) {
		String labelRespuesta;
		WebElement Element;
		Element = driver.findElement(buttonEnviar);
		Ayuda.downScrollBarUntilElement(driver, Element);
		labelRespuesta =wait.until(ExpectedConditions.visibilityOf(driver.findElement(labelRepuestaFormulario))).getText();
		Ayuda.addEvidence(TAKE_SS, driver, test, "Home Page", subDir2, "Home Page CLM");
		return labelRespuesta;

	}

	/**
	 * Captura texto de etiqueta de respuesta del formulario si fue erróneo el envío. Ejemplo: no se completa campo obligatorio
	 * @param subDir3
	 * @return
	 */
	public String captureLabelRespuestaFormularioFallida( String subDir3) {
		String labelRespuestaFallida;
		WebElement Element;
		Element = driver.findElement(buttonEnviar);
		Ayuda.downScrollBarUntilElement(driver, Element);
		labelRespuestaFallida =wait.until(ExpectedConditions.visibilityOf(driver.findElement(labelRepuestaFormularioFallida))).getText();
		Ayuda.addEvidence(TAKE_SS, driver, test, "Contacto Page", subDir3, "Contacto Page CLM");
		return labelRespuestaFallida;

	}


}
