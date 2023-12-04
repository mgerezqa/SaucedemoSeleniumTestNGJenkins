package pages;

import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
	
	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private  String btnAddCart_BikeLight = "//button[@id='add-to-cart-sauce-labs-bike-light']";
	private  String btnShoppingCart= "//a[@class='shopping_cart_link']";
	private  String btnMenu = "//button[@id='react-burger-menu-btn']";
	private  String btnLogout = "//a[@id='logout_sidebar_link']";
	private  String sortLocator = "//select[@class='product_sort_container']";
	
	public  void add_SauceLabsBikeLight() {
		clickElement(btnAddCart_BikeLight);
	}
	
	public  void click_shoopingCart() {
		clickElement(btnShoppingCart);
	}
	
	public  void click_menu() {
		clickElement(btnMenu);
	}
	
	public  void click_signOff() {
		clickElement(btnLogout);
	}
	
	public  void sortAlfaAscending() {
		selectFromDropdownByIndex(sortLocator,0);
	}
	
	public  void sortAlfaDescending() {
		selectFromDropdownByIndex(sortLocator,1);
	}
	
	public  void sortPriceAscending() {
		selectFromDropdownByIndex(sortLocator,2);
	}
	
	public  void sortPriceDescending() {
		selectFromDropdownByIndex(sortLocator,3);
	}
	
	
}
