package pages;

import org.openqa.selenium.WebDriver;

public class CheckOutCompletePage extends BasePage{
	public CheckOutCompletePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	private static String btnBackHome = "//button[@id='back-to-products']";
	
	
	public  void click_backHome() {
		clickElement(btnBackHome);
	}
}
