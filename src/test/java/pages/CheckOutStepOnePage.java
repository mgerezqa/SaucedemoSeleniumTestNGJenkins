package pages;

import org.openqa.selenium.WebDriver;

public class CheckOutStepOnePage extends BasePage{
	public CheckOutStepOnePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private  String firstNameField = "//input[@id='first-name']";
	private  String lastNameField = "//input[@id='last-name']";
	private  String zipCodeField = "//input[@id='postal-code']";
	private  String btnContinue = "//input[@id='continue']";
	
	
	public  void completePurchaseInformation() {
		write(firstNameField,"Harcodeado");
		write (lastNameField,"Harcodeado");
		write (zipCodeField,"Harcodeado");
	}
	
	public  void click_continue() {
		clickElement(btnContinue);
	}
	
	
}
