package pages;

import org.openqa.selenium.WebDriver;

public class CheckOutStepTwoPage extends BasePage {
	private String btnFinish = "//button[@id='finish']";

	public CheckOutStepTwoPage(WebDriver driver) {
		super(driver);
	}

	
	public  void click_finish() {
		clickElement(btnFinish);
	}

}
