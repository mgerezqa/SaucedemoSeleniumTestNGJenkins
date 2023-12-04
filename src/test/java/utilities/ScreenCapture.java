package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenCapture {

	
	public static String capture(WebDriver driver) throws IOException {
	    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String timeStamp = String.valueOf(System.currentTimeMillis());
	    String destPath = System.getProperty("user.dir") + "\\src\\test\\resources\\images\\" + timeStamp + ".png";
	    File dest = new File(destPath);
	    FileUtils.copyFile(scrFile, dest);
	    return destPath;
	}
}
