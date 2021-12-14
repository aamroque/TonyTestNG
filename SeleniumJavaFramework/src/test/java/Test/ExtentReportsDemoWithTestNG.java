package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemoWithTestNG {

//	Always start to create your Test Script with
//	setUp, test1, tearDown
//	@BeforeTest
//	public void setUp() {	
//	}	
//	@Test
//	public void test1() {
//	}	
//	@AfterTest
//	public void tearDown() {	
//	}
	
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {	
	    htmlReporter = new ExtentSparkReporter("extentReports.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}	
	
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test1() {
		ExtentTest test1 = extent.createTest("Google Search TC1","Sample Google Search");
		//Start your Test Steps below ExtentTest
		
		driver.get("https://www.google.com");
		test1.pass("Navigated to Google.com");
		test1.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot1.png").build());
		test1.addScreenCaptureFromPath("screenshot1.jpg");
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		test1.pass("Entered text in Search Box");
		test1.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot2.png").build());
		test1.addScreenCaptureFromPath("screenshot2.jpg");

		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).sendKeys(Keys.RETURN);
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("Pressed keyboard ENTER Key");
		test1.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot3.png").build());
		test1.addScreenCaptureFromPath("screenshot3.jpg");
		
//		test1.log(Status.INFO,"This step shows usage of log(status, details)");
//		test1.info("This step shows usage of info(details)");
//		test1.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
//		test1.pass("details", MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
//		test1.addScreenCaptureFromPath("screenshot.png");
	}	
	
	@Test
	public void test2() {
	ExtentTest test2 = extent.createTest("Google Search TC2","Sample Google Search");
	driver.get("https://www.google.com");
	test2.pass("Navigated to Google.com");
	test2.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot1.png").build());
	test2.addScreenCaptureFromPath("screenshot1.jpg");
	}	
	
	@AfterTest
		public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed");
	}
	
	@AfterSuite	
		public void tearDown() {
		extent.flush();
	}
	
}
