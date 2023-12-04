package tests;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import pages.CartPage;
import pages.CheckOutCompletePage;
import pages.CheckOutStepOnePage;
import pages.CheckOutStepTwoPage;
import pages.LoginPage;
import pages.ProductPage;
import utilities.ConfigFile;
import utilities.DatosExcel;
import utilities.DriverManager;
import utilities.ReportManager;
import utilities.ScreenCapture;

public class SauceDemoTest {
	WebDriver driver ;
	ReportManager report = new ReportManager();
	String directorioDatos = "..\\Saucedemo_TestAutomationFramework\\Datos\\";
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) throws IOException {
		if(driver == null) {
			DriverManager.startDriver(browser);
			driver = DriverManager.getDriver();
		}
		
		report.startReport();
	}


	@Test(dataProvider = "DatosInicioSesionValido", groups = {"smokeTest","regression","caseOne"}) 
	public void CP001_LoginSuccesfull(String user,String password) throws IOException  {
		LoginPage loginPage = new LoginPage(driver);
		report.createTestInstance("CP001_LoginSuccesfull");
        loginPage.verifyTitle(report);
        loginPage.enterCredentials(user, password);
        report.getTest().log(Status.PASS, "Ingreso de usuario válido:", MediaEntityBuilder.createScreenCaptureFromPath(ScreenCapture.capture(driver)).build());
        loginPage.clickLogin();
        report.getTest().log(Status.PASS, "Ingreso a la pagina de productos:", MediaEntityBuilder.createScreenCaptureFromPath(ScreenCapture.capture(driver)).build());
        ProductPage productPage = new ProductPage(driver);
        productPage.click_menu();
        productPage.click_signOff();
	}
	
	@Test (groups = "regression")
	void CP002_LoginPassFail() throws IOException {
		report.createTestInstance("CP002_LoginPassFail");
		LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyTitle(report);
		loginPage.enterCredentials(ConfigFile.read("validUser"),ConfigFile.read("invalidPass"));
		loginPage.clickLogin();
		loginPage.errorMessageInvalidUserOrPass();
		report.getTest().log(Status.PASS, "Validar error de usuario o pass incorrecto",MediaEntityBuilder.createScreenCaptureFromPath(ScreenCapture.capture(driver)).build());

	}
	
	@Test (groups = "regression")
	void CP003_LoginInvalidUser() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		report.createTestInstance("CP003_LoginUserFail");
        loginPage.verifyTitle(report);
		loginPage.enterCredentials(ConfigFile.read("invalidUser"),ConfigFile.read("validPass"));
		loginPage.clickLogin();
		loginPage.errorMessageInvalidUserOrPass();
		report.getTest().log(Status.PASS, "Validar error de usuario o pass incorrecto",MediaEntityBuilder.createScreenCaptureFromPath(ScreenCapture.capture(driver)).build());

	}
	
	@Test(priority = 10, groups = "regression") 
	void CP004_LoginEmptyFields() throws IOException {
		report.createTestInstance("CP004_EmptyFields");
		LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyTitle(report);
		loginPage .enterCredentials(ConfigFile.read("emptyField"),ConfigFile.read("emptyField"));
		loginPage .clickLogin();
		loginPage .errorMessageEmptyFields();
		report.getTest().log(Status.PASS, "Validar error de ingreso con campos vacíos",MediaEntityBuilder.createScreenCaptureFromPath(ScreenCapture.capture(driver)).build());

	}
	
	@Test (groups = {"smokeTest","regression"})
	void CP005_MakePurchase() throws IOException {
		report.createTestInstance("CP005_MakePurchase");
		LoginPage loginPage = new LoginPage(driver);
		loginPage .emptyFields();
		loginPage .enterCredentials(ConfigFile.read("validUser"),ConfigFile.read("validPass"));
		report.getTest().log(Status.PASS, "Ingreso de usuario válido:",MediaEntityBuilder.createScreenCaptureFromPath(ScreenCapture.capture(driver)).build());
		loginPage .clickLogin();
		ProductPage productPage = new ProductPage(driver);
		productPage .add_SauceLabsBikeLight();
		report.getTest().log(Status.PASS, "Agregar producto a carro de compras:",MediaEntityBuilder.createScreenCaptureFromPath(ScreenCapture.capture(driver)).build());
		productPage .click_shoopingCart();
		report.getTest().log(Status.PASS, "Hacer click en carro de compras:",MediaEntityBuilder.createScreenCaptureFromPath(ScreenCapture.capture(driver)).build());		
		CartPage cartPage = new CartPage(driver);
		cartPage .click_checkOut();
		report.getTest().log(Status.PASS, "Hacer click en checkout:",MediaEntityBuilder.createScreenCaptureFromPath(ScreenCapture.capture(driver)).build());
		CheckOutStepOnePage checkOutStepOnePage = new CheckOutStepOnePage(driver);
		checkOutStepOnePage.completePurchaseInformation();
		report.getTest().log(Status.PASS, "Completar información:",MediaEntityBuilder.createScreenCaptureFromPath(ScreenCapture.capture(driver)).build());
		checkOutStepOnePage.click_continue();
		CheckOutStepTwoPage checkOutStepTwoPage = new CheckOutStepTwoPage(driver);
		checkOutStepTwoPage.click_finish();
		report.getTest().log(Status.PASS, "Compra realizada:",MediaEntityBuilder.createScreenCaptureFromPath(ScreenCapture.capture(driver)).build());
		CheckOutCompletePage checkOutCompletePage = new CheckOutCompletePage(driver);
		checkOutCompletePage .click_backHome();
		report.getTest().log(Status.PASS, "Volver a home:",MediaEntityBuilder.createScreenCaptureFromPath(ScreenCapture.capture(driver)).build());
		productPage.click_menu();
		productPage.click_signOff();
	}
	
	@DataProvider(name = "DatosInicioSesionValido")
	public Object[][] obtenerDatosExcel() throws Exception {
		// Leer los datos que estan en el archivo excel y armar un arreglo de objetos con esos datos
		return DatosExcel.leerExcel(directorioDatos + "Datos_IniciarSesion.xlsx", "Hoja1");
	}
	
	@AfterTest
	public void tearDown() {
		report.getExtent().flush();
		System.out.println("Script finalizado");
		DriverManager.closeDriver();
		ConfigFile.close();
		
	}
}


