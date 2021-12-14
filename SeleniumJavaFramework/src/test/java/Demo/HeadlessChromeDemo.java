package Demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeDemo {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		test();
	}
	
	public static void test() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./webdrivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.google.com");
		Thread.sleep(2000);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./TC1/image1.png"));
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		Thread.sleep(2000);
		
		File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile2, new File("./TC1/image2.png"));
		Thread.sleep(2000);
		
//		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.close();
		driver.quit();
		System.out.println("Test Completed");
	}
	
}
