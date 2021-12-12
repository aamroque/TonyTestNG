package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Config.PropertiesFile;

public class TestNG_Demo1 {

//	In TestNG, below lines no longer works
//	public static void main(String[] args) throws InterruptedException {
//		googleSearch();
//	}
	
	WebDriver driver = null;
	public static String browserName = null;
	
	@BeforeTest
	public void setUpTest() {
		//System.setProperty("webdriver.chrome.driver", "./webdrivers/chromedriver.exe");
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"/webdrivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"/webdrivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
	@Test
	public void googleSearch1() throws InterruptedException {
		driver.get("https://www.google.com");
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("Automation");
		Thread.sleep(2000);
		//driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);
	}
	
	@Test
	public void googleSearch2() throws InterruptedException {
		driver.get("https://www.google.com");
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("Automation");
		Thread.sleep(2000);
		//driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		//driver.quit does not work in firefox
		//driver.quit();
		System.out.println("Test Completed");
	}	
}



