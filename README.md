# <h1>FrontTestFalabella</h1>

Proyecto Maven desarrollado en lenguaje Java utilizando TestNG y patron de diseño Page Object Model(POM). Para la documentación se utilizó JavaDoc y para la generación de reporte extent report con captura de screenshot. El navegador utilizado es Chrome y cuya versión del binario es <strong> 89.0.4389.114 </strong>

La Suite permite probar el front de la página de CLM Consultores y cuenta con 8 tests:
URL Site: http://clmconsultores.cl/

<h4>Se recomienda seguir el siguiente instructivo: </h4>

1.) Una vez descargado el código, es necesario exportar como proyecto maven al IDE que utilice<strong>(se recomienda utilizar IntelliJ)</strong>  <br>
2.) Luego esperar que descargue todas las dependencias asociadas al <strong> POM.XML </strong> <br>
3.) Previo a ejecución asegurarse de tener la versión del binario que corrresponde al navegador y reemplazar en la ruta que se encuentra actualmente: <strong> DRIVERS -> chromedriver.exe </strong> <br>
4.) Finalmente para ejecutar suite, ingrese comando en terminal en la raíz del proyecto: <strong> mvn test </strong><br>
5.) Una vez finalizada la ejecución ir a la ruta del proyecto <strong> ExtentReports -> Reporte.html y abrir con el navegador que se desee </strong> <br>


