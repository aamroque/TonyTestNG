

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Elements {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com");
		Thread.sleep(3000);
		
//		driver.findElement(By.name("q")).sendKeys("General Syntax for find Element and click");
//		Thread.sleep(3000);
//		//OR
		driver.findElement(By.name("q")).sendKeys("find Element and press enter" + Keys.ENTER);
		Thread.sleep(3000);
//		//OR - Name
//		WebElement searchBox = driver.findElement(By.name("q"));
//		searchBox.sendKeys("Enter text in textbox then click", Keys.ENTER);
//		Thread.sleep(3000);
//		OR - CSS ID
//		driver.findElement(By.cssSelector("input")).sendKeys("Find Element by CSS");
//		Thread.sleep(3000);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(3000);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		Thread.sleep(3000);
		driver.findElement(By.name("txtUsername")).sendKeys(Keys.TAB);
		Thread.sleep(3000);
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement button = driver.findElement(By.name("Submit"));
		js.executeScript("arguments[0].click();",button);
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		System.out.println("Test Completed");
		
	}
	
}
