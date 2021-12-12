package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsBasicDemo {

	private static WebDriver driver = null;
		
	public static void main(String[] args) {
		
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReports.html");
		//
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		//
		ExtentTest test1 = extent.createTest("Google Search TC1","Indicate TC Desc here");
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		test1.log(Status.INFO, "Stating Test Case");
		
		driver.get("https://www.google.com");
		test1.pass("Navigated to Google.com");
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		test1.pass("Entered text in Search Box");

		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("Pressed keyboard ENTER Key");
		
		driver.close();
		driver.quit();
		test1.pass("Browser Closed");
		
		test1.info("Test Completed");
		extent.flush();
	}

}
