package Test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import Pages.GoogleSearchPage;
import Pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {

	//This is for GoogleSearchPageObjects Class in Pages Package
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		//After completing Test Steps, call this function in the main method
		googleSearchTest();
	}
	
	public static void googleSearchTest() {
		
		System.setProperty("webdriver.chrome.driver", "./webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
	
		driver.get("https://www.google.com");
		
		searchPageObj.setTextInSearchBox("Automation");
		searchPageObj.clickSearchButton();
		
		driver.close();
		driver.quit();
	}
	
}
