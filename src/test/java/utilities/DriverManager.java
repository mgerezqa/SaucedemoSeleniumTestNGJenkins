package utilities;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    private static WebDriver driver;

	public static void startDriver(String browser) throws IOException {
		
		if (driver == null) {
		ConfigFile.startConfig();
		}
		
		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(ConfigFile.read("testurl"));

		}

		else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(ConfigFile.read("testurl"));
		}
		
		else if (browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(ConfigFile.read("testurl")); 

		}

	}

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver newDriver) {
        driver = newDriver;
    }
}

//@AfterTest
//public static void close() {
//	report.getExtent().flush();
//	System.out.println("Script finalizado");
//	driver.close();
//}
//if (driver == null) {
//FileReader fr = new FileReader(
//System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
//prop.load(fr);
//}


///*CONFIGURACIÓN PARA EJECUCIÓN LOCAL */
//@BeforeTest
//public void setUp() throws IOException {
//
//	if (driver == null) {
//		FileReader fr = new FileReader(
//		System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
//		prop.load(fr);
//	}
//
//	if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get(prop.getProperty("testurl")); // properties
//		report = new ExtentConfigTest();  
//	    report.startReport();
//
//
//	}
//
//	else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
//		driver.get(prop.getProperty("testurl")); // properties
//		report = new ExtentConfigTest();  
//	    report.startReport();
//	}
//
//	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//}
//
//

/*CONFIGURACIÓN PARA RUNNERS */
//
//@Parameters("browser")
//@BeforeTest
//public void setUp(String browser) throws IOException {
//
//	if (driver == null) {
//		FileReader fr = new FileReader(
//		System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
//		prop.load(fr);
//	}
//
//	if (browser.equalsIgnoreCase("chrome")) {
//
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get(prop.getProperty("testurl"));
//		report = new ReportManager();  
//	    report.startReport();
//
//	}
//
//	else if (browser.equalsIgnoreCase("firefox")) {
//
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
//		driver.get(prop.getProperty("testurl"));
//		report = new ReportManager();  
//	    report.startReport();
//	}
//	
//	else if (browser.equalsIgnoreCase("edge")) {
//
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
//		driver.get(prop.getProperty("testurl")); 
//		report = new ReportManager();  
//	    report.startReport();
//	}
//
//	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//}

//@AfterTest
//public void tearDown() {
//	report.getExtent().flush();
//	System.out.println("Script finalizado");
//	driver.close();
//}
