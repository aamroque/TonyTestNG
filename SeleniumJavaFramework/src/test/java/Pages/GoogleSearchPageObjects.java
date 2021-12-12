package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {

	//Always initialize WebDriver
	WebDriver driver = null;
	
	//List of Elements
	By textbox_search = By.name("q");
	By button_search = By.name("btnK");
	
	//This is called a constructor
	public GoogleSearchPageObjects(WebDriver driver) {
	this.driver = driver;
	}
	
	//List of Functions/Actions
	//This is a Function/Action
	public void setTextInSearchBox(String text) {
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	public void clickSearchButton() {
		driver.findElement(button_search).sendKeys(Keys.RETURN);
	}
}
