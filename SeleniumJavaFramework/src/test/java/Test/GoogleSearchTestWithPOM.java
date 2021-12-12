package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.GoogleSearchPage;

public class GoogleSearchTestWithPOM {

	//This is for GoogleSearchPage Class in Pages Package
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		googleSearch();
	}
	
	public static void googleSearch() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		//Test Steps starts here
		driver.get("https://www.google.com");
//		driver.findElement(By.name("q")).sendKeys("Automation");
//		//driver.findElement(By.name("btnK")).click();
//		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		//Declare WebDriver driver at the class level
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation");
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		System.out.println("Test Completed");
		
	}
}
