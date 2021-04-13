package cl.qa.tests;


import java.io.File;
import java.util.concurrent.TimeUnit;
import cl.qa.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cl.qa.helpers.Ayuda;


public class MainTest {
	private WebDriver driver;
	private ExtentReports extent;
	private ExtentTest test;
	private static final String SUBDIR = "CLMPage\\";
	private static final Boolean TAKE_SS = true;
	private static final int WAITING = 10;
	private String URL_PRINCIPAL;

	@BeforeSuite
	public void configExtentReports() {
		// ExtentReports config
		this.extent = new ExtentReports("ExtentReports/Reporte.html", true);
		this.extent.addSystemInfo("Host Name", "Prueba Tecnica Front Falabella");
		this.extent.addSystemInfo("Environment", "Automation Testing");
		this.extent.addSystemInfo("User Name", "Daniel Palma M");
        //llamada a objeto de configuracion de Extent report
		File conf = new File("src/test/resources/extentReports/" + "extent-config.xml");
		this.extent.loadConfig(conf);
		URL_PRINCIPAL="https://clmconsultores.cl/";
	}

	@BeforeMethod
	//@Parameters({ "URL_PRINCIPAL" })
	//public void configSelenium( String URL_PRINCIPAL ) {
	public void configSelenium() {
		// Selenium config
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("Empresa", "CLM Consultores");
		System.setProperty("webdriver.chrome.driver", "DRIVERS/chromedriver.exe");
		driver = new ChromeDriver();
		//Implicit Waits No usar si se estan usando explicit wait
		driver.manage().timeouts().implicitlyWait(WAITING, TimeUnit.SECONDS);
		//Maximizar Ventana
		driver.manage().window().maximize();
		//Navegar a url principal
		driver.navigate().to(URL_PRINCIPAL);
	}

	@Test
	public void ValidaHomePage() {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Prueba Página Principal", "Prueba Página principal");
		test.log(LogStatus.INFO, "Prueba Pagina Principal");
		HomePage home = new HomePage(driver, test, TAKE_SS, 20);
		ServiciosPruebasFuncionales publicate = new ServiciosPruebasFuncionales(driver, test, TAKE_SS, 20);
		// Valida que esta en el Home Page y que existe la etiqueta Inicio
		Assert.assertEquals(home.captureLabelHomePage(subDir), "Inicio");
	}

	@Test
	public void ValidaModuloServiciosPruebasFuncionales() {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("ValidaModuloServiciosPruebasFuncionales", "Prueba Menu Servicios - Pruebas Funcionales");
		test.log(LogStatus.INFO, "Menu Pruebas Funcionales");
		HomePage home = new HomePage(driver, test, TAKE_SS, 20);
		ServiciosPruebasFuncionales spf = new ServiciosPruebasFuncionales(driver, test, TAKE_SS,20);
		Contacto contacto = new Contacto(driver, test, TAKE_SS,20);
		// Valida que esta en el Home Page y que existe la etiqueta Inicio
		Assert.assertEquals(home.captureLabelHomePage(subDir),"Inicio");
		home.clickSubMenuServicioPruebasFuncionales(subDir);
		// Valida que se encuentre posicionado en la página de Servicios Pruebas Funcionales
		Assert.assertEquals(spf.captureLabelServiciosPruebasFuncionales(subDir),"Pruebas Funcionales");
		spf.clickButtonContactanos(subDir);
		// Valida que se encuentre posicionado en la página de Contáctanos
		Assert.assertEquals(contacto.captureLabelContacto(subDir),"Contáctanos");
	}

	@Test
	public void ValidaModuloServiciosPruebasRendimiento() {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("ValidaModuloServiciosPruebasRendimiento", "Prueba Menu Servicios - Pruebas Rendimiento");
		test.log(LogStatus.INFO, "Menu Prueba Rendimiento");
		HomePage home = new HomePage(driver, test, TAKE_SS, 20);
		ServiciosPruebasRendimiento rendimiento = new ServiciosPruebasRendimiento(driver, test, TAKE_SS, 20);
		Contacto contacto = new Contacto(driver, test, TAKE_SS,20);
		// Valida que esta en el Home Page y que existe la etiqueta Inicio
		Assert.assertEquals(home.captureLabelHomePage(subDir),"Inicio");
		home.clickSubMenuServicioPruebasRendimiento(subDir);
		Assert.assertEquals(rendimiento.captureLabelServiciosPruebasRendimiento(subDir),"Pruebas de Rendimiento");
		rendimiento.clickButtonContactanos(subDir);
		// Valida que se encuentre posicionado en la página de Contáctanos
		Assert.assertEquals(contacto.captureLabelContacto(subDir),"Contáctanos");

	}

	@Test
	public void ValidaModuloServiciosPruebasMobile() {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("ValidaModuloServiciosPruebasMobile", "Prueba Menu Servicios - Pruebas Mobile");
		test.log(LogStatus.INFO, "Menu Prueba Mobile");
		HomePage home = new HomePage(driver, test, TAKE_SS, 20);
		ServiciosPruebasMobile mobile = new ServiciosPruebasMobile(driver, test, TAKE_SS, 20);
		Contacto contacto = new Contacto(driver, test, TAKE_SS,20);
		// Valida que esta en el Home Page y que existe la etiqueta Inicio
		Assert.assertEquals(home.captureLabelHomePage(subDir),"Inicio");
		home.clickSubMenuServicioPruebasMobile(subDir);
		// Valida que este en el modulo de Pruebas Mobile
		Assert.assertEquals(mobile.captureLabelServiciosPruebasMobile(subDir),"Pruebas Mobile");
		mobile.clickButtonContactanos(subDir);
		// Valida que se encuentre posicionado en la página de Contáctanos
		Assert.assertEquals(contacto.captureLabelContacto(subDir),"Contáctanos");
	}

	@Test
	public void ValidaModuloRecursosBusqueda() {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("ValidaModuloRecursosBusqueda", "Prueba Menu Recursos");
		test.log(LogStatus.INFO, "Menu Recursos");
		HomePage home = new HomePage(driver, test, TAKE_SS, 20);
		Recursos recursos = new Recursos(driver, test, TAKE_SS, 20);
		// Valida que esta en el Home Page y que existe la etiqueta Inicio
		Assert.assertEquals(home.captureLabelHomePage(subDir),"Inicio");
		home.clickMenuRecursos(subDir);
		// Valida que este en el modulo de Recursos
		Assert.assertEquals(recursos.captureLabelRecursos(subDir),"Recursos");
		// Insertar recurso a buscar
		recursos.clickBusquedaRecursos(subDir,"agile");
		// Valida que esté en el recurso buscado anteriormente
		Assert.assertEquals(recursos.captureLabelResultadoBusqueda(subDir),"Resultados de la búsqueda de: agile");

	}

	@Test
	public void ValidaModuloEmpresa() {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("ValidaModuloEmpresa", "Prueba Menu Empresa");
		test.log(LogStatus.INFO, "Menu Empresa");
		HomePage home = new HomePage(driver, test, TAKE_SS, 20);
		Empresa empresa = new Empresa(driver, test, TAKE_SS, 20);
		// Valida que esta en el Home Page y que existe la etiqueta Inicio
		Assert.assertEquals(home.captureLabelHomePage(subDir),"Inicio");
		home.clickMenuEmpresa(subDir);
		// Valida que este en el modulo de Recursos
		Assert.assertEquals(empresa.captureLabelEmpresa(subDir),"Empresa");
		// Valida texto identidad CLM
		Assert.assertEquals(empresa.captureIdentidadCLM(subDir),"Somos un equipo de especialistas que, además de saber lo que hacemos, " +
				"lo disfrutamos. Nos comprometemos en cada proyecto con ganas y profesionalismo, entregándole el mejor servicio a nuestros clientes");

	}

	@Test
	public void ValidaModuloContactoExitoso() {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("ValidaModuloContactoExitoso", "Prueba Menu Contacto");
		test.log(LogStatus.INFO, "Menu Contacto");
		HomePage home = new HomePage(driver, test, TAKE_SS, 20);
		Contacto contacto = new Contacto(driver, test, TAKE_SS, 20);
		//home.captureLabelHomePage(subDir);
		// Valida que esta en el Home Page y que existe la etiqueta Inicio
		Assert.assertEquals(home.captureLabelHomePage(subDir),"Inicio");
		home.clickMenuContacto(subDir);
		// Valida que se encuentre posicionado en la página de Contáctanos
		Assert.assertEquals(contacto.captureLabelContacto(subDir),"Contáctanos");
		// Ingresa y completa campos obligatorios de formulario de contacto
		contacto.ingresaNombre("Daniel Palma Manriquez");
		contacto.ingresaEmail("dpalma@clmconsultores.com");
		contacto.ingresaTelefono("993452939");
		contacto.ingresaEmpresa("CLM_PRUEBA");
		contacto.ingresaCargo("Analista QA CLM Consultores");
		contacto.seleccionaServicioInteres("Pruebas Funcionales");
		contacto.ingresaConsulta("Prueba Tecnica para Ingresar a Falabella");
		Ayuda.waitSeconds(3);
		contacto.presionaBotonEnviar();
		Assert.assertTrue(contacto.captureLabelRespuestaFormularioExitosa(subDir).contains("GRACIAS POR TU MENSAJE. HA SIDO ENVIADO."),"Respuesta exitosa");
	}

	@Test
	public void ValidaModuloContactoFallido() {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("ValidaModuloContactoFallido", "Prueba Menu Contacto");
		test.log(LogStatus.INFO, "Menu Contacto");
		HomePage home = new HomePage(driver, test, TAKE_SS, 20);
		Contacto contacto = new Contacto(driver, test, TAKE_SS, 20);
		//home.captureLabelHomePage(subDir);
		// Valida que esta en el Home Page y que existe la etiqueta Inicio
		Assert.assertEquals(home.captureLabelHomePage(subDir),"Inicio");
		home.clickMenuContacto(subDir);
		// Valida que se encuentre posicionado en la página de Contáctanos
		Assert.assertEquals(contacto.captureLabelContacto(subDir),"Contáctanos");
		// Ingresa y completa campos obligatorios de formulario de contacto
		contacto.ingresaEmail("dpalma@clmconsultores.com");
		contacto.ingresaTelefono("993452939");
		contacto.ingresaEmpresa("CLM_PRUEBA");
		contacto.ingresaCargo("Analista QA CLM Consultores");
		contacto.seleccionaServicioInteres("Pruebas Funcionales");
		contacto.ingresaConsulta("Prueba Técnica para ingresar a Falabella");
		Ayuda.waitSeconds(3);
		contacto.presionaBotonEnviar();
		Assert.assertTrue(contacto.captureLabelRespuestaFormularioFallida(subDir).contains("UNO O MÁS CAMPOS TIENEN UN ERROR. POR FAVOR REVISA E INTÉNTALO DE NUEVO."),"Respuesta fallida");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test failed.- <br>" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test skipped.- <br>" + result.getThrowable());
		} else {
			test.log(LogStatus.PASS, "Test passed.-");
		}
		driver.close();
		Ayuda.waitSeconds(2);
		extent.endTest(test);
	}

	@AfterSuite
	public void closeExtentReports() {
		// Escribimos los datos al reporte.
		extent.flush();
		driver.quit();
		//extent.endTest(test);
	}
}
