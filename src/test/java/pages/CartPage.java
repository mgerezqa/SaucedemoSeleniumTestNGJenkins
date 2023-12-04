package pages;

import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
	private static String btnCheckOut = "//button[@id='checkout']";
	
	public CartPage(WebDriver driver){
		super(driver);
	}
	public void click_checkOut() {
		clickElement(btnCheckOut);
	}
}
