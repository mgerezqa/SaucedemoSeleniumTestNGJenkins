package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private  WebDriver driver;
	private WebDriverWait wait;
	private  Actions action;
	
    	public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	
	/* METODOS */
	protected  WebElement find(String locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}
	
	public WebElement findByCSS(String locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
	}
	

	public  void clickElement(String locator) {
		find(locator).click();
	}

	public  void write(String locator, String text) {
		find(locator).clear();
		find(locator).sendKeys(text);
	}

	public void goToLinkText(String linkText) {
		find(linkText).click();
	}

	public void submitElement(String locator) {
		find(locator).submit();
	}

	public int dropdownSize(String locator) {
		Select dropdown = new Select(find(locator));
		List<WebElement> dropdownOptions = dropdown.getOptions();
		return dropdownOptions.size();
	}

	public void selectFromDropdownByValue(String locator, String valueToSelect) {
		Select dropdown = new Select(find(locator));

		dropdown.selectByValue(valueToSelect);
	}

	public void selectFromDropdownByIndex(String locator, int valueToSelect) {
		Select dropdown = new Select(find(locator));
		dropdown.selectByIndex(valueToSelect);
	}

	public void selectFromDropdownByText(String locator, String valueToSelect) {
		Select dropdown = new Select(find(locator));
		dropdown.selectByVisibleText(valueToSelect);
	}

	public void hoverOverElement(String locator) {
		action.moveToElement(find(locator));
	}

	public void doubleClick(String locator) {
		action.doubleClick(find(locator));
	}

	public void rightClick(String locator) {
		action.contextClick(find(locator));
	}

	public String getValueFromTable(String locator, int row, int column) {
		String cellINeed = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";

		return find(cellINeed).getText();
	}

	public void setValueOnTable(String locator, int row, int column, String stringToSend) {

		String cellToFill = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";

		find(cellToFill).sendKeys(stringToSend);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void switchToiFrame(int iFrameIndex) {
		driver.switchTo().frame(iFrameIndex);
	}

	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	public String errorFromPlaceHolder(String locator) {
		return find(locator).getAttribute("placeholder");
	}

	public String textFromElement(String locator) {
		return find(locator).getText();
	}

	public boolean elementEnabled(String locator) {
		return find(locator).isEnabled();
	}

	public  boolean elementIsDisplayed(String locator) {

		return find(locator).isDisplayed();
	}

	public boolean elementIsSelected(String locator) {

		return find(locator).isSelected();
	}

	public List<WebElement> bringMeAllElements(String locator) {
		return driver.findElements(By.className(locator));
	}

	public void selectNthElementFromList(String locator, int index) {
		List<WebElement> list = driver.findElements(By.className(locator));
		list.get(index).click();
	}

	public void dragAndDrop(String locator, String locator2) {
		WebElement element = find(locator);
		WebElement element2 = find(locator2);
		action.dragAndDrop(element, element2).build().perform();
	}

	public void selectCriteriaFromList(String locator, String criteria) {
		List<WebElement> list = driver.findElements(By.className(locator));
		for (WebElement element : list) {
			if (element.getText().equals(criteria)) {
				element.click();
				break;
			}

		}
	}
}

