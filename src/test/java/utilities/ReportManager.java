package utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {
	private static ExtentReports extent;
	private static ExtentSparkReporter spark;
	private ExtentTest test;
	
  public  void startReport() {
	  
	// Configuración del reporte
	if (extent == null) {

	  spark = new ExtentSparkReporter("..\\Saucedemo_TestAutomationFramework\\src\\test\\resources\\reports\\Spark.html");
      extent = new ExtentReports();
      extent.attachReporter(spark);

      spark.config().setTheme(Theme.STANDARD);
      spark.config().setDocumentTitle("Saucedemo Automation Project");
      spark.config().setReportName("Test report by Martin R Gerez");
	}   
	  
  }

	public ExtentReports getExtent() {
		return extent;
	}

//	public void setExtent(ExtentReports extent) {
//		this.extent = extent;
//	}
//  
	
    public void createTestInstance(String testName) {
        test = extent.createTest(testName);
    }

    public ExtentTest getTest() {
		return test;
	}

	public void setTest(ExtentTest test) {
		this.test = test;
	}

}
