

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//WebDriverManager.edgedriver().setup();
		//WebDriver driver = new EdgeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
				
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		
		//JS Alert
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		Thread.sleep(3000);
		alert1.accept();
		if(driver.getPageSource().contains("You successfully clicked an alert"))
			System.out.println("You successfully clicked an alert");
			System.out.println("==================================");
		
		Thread.sleep(3000);
		
		//JS Confirm
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		Thread.sleep(3000);
		alert2.dismiss();
		if(driver.getPageSource().contains("You clicked: Cancel"))
			System.out.println("You clicked: Cancel");
			System.out.println("====================");
		
		Thread.sleep(3000);
		
		//JS Prompt
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert alert3 = driver.switchTo().alert();
		System.out.println(alert3.getText());
		alert3.sendKeys("Automation");
		Thread.sleep(3000);
		alert3.accept();
		if(driver.getPageSource().contains("You entered: Automation"))
			System.out.println("You entered: Automation");
			System.out.println("====================================");

		Thread.sleep(3000);
		
		//OR
	/*
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement button = driver.findElement(By.xpath("//*[@id=\'content\']/div/ul/li[1]/button"));
		js.executeScript("arguments[0].click();",button);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement button = driver.findElement(By.xpath("//*[@id=\'content\']/div/ul/li[2]/button"));
		js.executeScript("arguments[0].click();",button);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement button = driver.findElement(By.xpath("//*[@id=\'content\']/div/ul/li[3]/button"));
		js.executeScript("arguments[0].click();",button);
	*/
		driver.close();
		driver.quit();

	}
	
}
