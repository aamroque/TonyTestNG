package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

	//For POM or Page Object Model
	//You can save all the elements/objects in a single class
	//This will help with easier maintenance when elements get refactored
	
	private static WebElement element = null;
	
	public static WebElement textbox_search(WebDriver driver) {
		element = driver.findElement(By.name("q"));
		return element;
	}
	public static WebElement button_search(WebDriver driver) {
		element = driver.findElement(By.name("btnK"));
		return element;
	}
}
