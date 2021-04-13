package cl.qa.helpers;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;

/**
 * <P>
 * Clase utilitaria para ser utilizada y reutilizada en cualquier página.
 * <p>
 * Se presentan los siguientes utilitarios:
 * <ul>
 * <li>{@link #addEvidence(Boolean, WebDriver, ExtentTest, String, String, String)}</li>
 * <li>{@link #waitSeconds(int)}</li>
 * </ul>
 * 
 * @author Daniel Palma Manriquez
 * @version 1.0
 */
public class Ayuda {

	private static final String PATH_EVIDENCE = "ExtentReports\\Evidence";
	private static final String DIR_EVIDENCE = ".\\Evidence\\";

	/**
	 * <p>Ejecuta código javascript que permite bajar el scroll bar hasta que detecte el elemento indicado</>
	 * @param driver
	 * @param element
	 * @author Daniel Palma
	 * @since 1.0
	 */

	public static void downScrollBarUntilElement(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	/**
	 * <p>
	 * Agrega la evidencia de prueba al reporte a generar.
	 *
	 * @param TAKE_SS    boolean que indica si se debe adjuntar la evidencia.
	 * @param driver     WebDriver del navegador utilizado.
	 * @param test       referencia al reporte de ExtentReports.
	 * @param imageTitle titulo/descripci�n de la imagen.
	 * @param subDir     Subdirectorio en el cual se guardara la imagen.
	 * @param imageName  nombre de la imagen sin extension.
	 *
	 * @author Daniel Palma
	 * @since 1.0
	 */
	public static void addEvidence(Boolean TAKE_SS, WebDriver driver, ExtentTest test, String imageTitle, String subDir,
			String imageName) {
		if (TAKE_SS) {
			Ayuda.takeScreenShot(driver, subDir, imageName);
			Ayuda.takeEvidence(test, imageTitle, subDir, imageName);
		}
	}

	/**
	 * <p>
	 * Adjunta una imagen como evidencia de prueba, la imagen ya ha sido capturada
	 * por:
	 * <ul>
	 * <li>{@link #takeScreenShot(WebDriver, String, String)}</li>
	 * </ul>
	 *
	 * @param test       referencia a la instancia de ExtentReports.
	 * @param imageTitle titulo de la imagen.
	 * @param subDir     subdirectorio de la imagen.
	 * @param imageName  nombre de la imagen sin extension.
	 * @author Daniel Palma
	 * @since 1.0
	 */
	private static void takeEvidence(ExtentTest test, String imageTitle, String subDir, String imageName) {
		File directory = new File(PATH_EVIDENCE);

		try {
			if (directory.isDirectory()) {
				test.log(LogStatus.INFO,
						imageTitle + test.addScreenCapture(DIR_EVIDENCE + subDir + "\\" + imageName + ".png"));

			} else {
				// Se lanza la excepcion cuando no encuentre el directorio
				throw new IOException("ERROR : La ruta especificada no es un directorio!");
			}
		} catch (IOException e) {
			// Impresion de Excepciones
			e.printStackTrace();
		}
	}


	/**
	 * <p>
	 * Toma una impresion de pantalla y la guarda en un directorio donde quedan
	 * todas las evidencias de prueba
	 *
	 * @param driver    driver navegador.
	 * @param subDir    directorio de las imagenes.
	 * @param imageName nombre de la imagen sin extension.
	 * @author Daniel Palma
	 * @since 1.0
	 */
	private static void takeScreenShot(WebDriver driver, String subDir, String imageName) {
		// Directorio donde quedan las imagenes
		File directory = new File(PATH_EVIDENCE);

		try {
			if (directory.isDirectory()) {
				// Toma la captura de imagen
				File imagen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// Mueve el archivo a la carga especificada con el respectivo nombre
				FileUtils.copyFile(imagen,
						new File(directory.getAbsolutePath() + "\\" + subDir + "\\" + imageName + ".png"));
			} else {
				// Se lanza la excepcion cuando no encuentre el directorio
				throw new IOException("ERROR : La ruta especificada no es un directorio!");
			}
		} catch (IOException e) {
			// Impresion de Excepciones
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * Detiene la ejecucion la cantidad de segundos indicados por parametro.
	 * <p>
	 * Utilitario para usarse en conjunto con los implicitWait.
	 *
	 * @param seconds cantidad de segundos a detener la ejecucion.
	 * @author Daniel Palma
	 * @since 1.0
	 */
	public static void waitSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
