package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import utilities.ReportManager;

public class LoginPage extends BasePage{

	private static String userField = "//input[@id='user-name']";
	private static String passField = "//input[@id='password']";
	private static String loginButton = "//input[@id='login-button']";
	private static String error = "//h3[normalize-space()='Epic sadface: Username is required']";
	private static String error2 = "//h3[normalize-space()='Epic sadface: Username and password do not match any user in this service']";
	
	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	public  void verifyTitle(ReportManager report) {
		String expectedTitle = "Swag Labs";
		String actualTitle = getTitle();
		System.out.println(actualTitle);
		if(expectedTitle.equals(actualTitle)) {
			report.getTest().log(Status.PASS,"Verificación correcta de título de página");
		} else {
			report.getTest().log(Status.FAIL,"No paso la verificación de título de página");
		}
	}

	
	public  void enterCredentials(String user,String password) {
		write(userField,user);
		write(passField,password);
	}
	
	public  void clickLogin() {
		clickElement(loginButton);
	}
	
	public  void emptyFields() {
		find(userField).clear();
		find(passField).clear();
	}
	
	public  void errorMessageEmptyFields() {
		WebElement errorElement = find(error);
		if (errorElement.isDisplayed()) {
			 String errorMessage = errorElement.getText();
	         System.out.println("Inicio de sesión fallido: " + errorMessage);
	         assert errorElement.isDisplayed();
	        } else {
	            System.out.println("Inicio de sesión exitoso");
	        }
		}
	
	public  void errorMessageInvalidUserOrPass() {
		WebElement errorElement = find(error2);
		if (errorElement.isDisplayed()) {
			 String errorMessage = errorElement.getText();
	         System.out.println("Inicio de sesión fallido: " + errorMessage);
	         assert errorElement.isDisplayed();
	        } else {
	            System.out.println("Inicio de sesión exitoso");
	        }
		}
		
}



