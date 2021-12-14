package Project1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.compress.harmony.unpack200.bytecode.forms.ThisInitMethodRefForm;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.MethodInstance;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestCase1Sample {

	//WebDriver driver = null;

	//Screenshot with No TimeStamp
	//File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//FileUtils.copyFile(scrFile, new File("./target/Test Results/TC1/image1.png"));
	//use below values to run in multi-thread
	//this means test1 will run 3 times
	//@Test(threadPoolSize=3, invocationCount=3, timeOut=1000)

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
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/webdrivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}

	@Test(priority=2)
	public void test1() throws IOException {
		ExtentTest test1 = extent.createTest("Google Search TC1","Sample Google Search 1");
		System.out.println("I am inside Test1 | "+Thread.currentThread().getId());

		driver.get("https://www.google.com");
		test1.pass("Navigated to Google.com");

		TakesScreenshot ts = (TakesScreenshot)driver;
		File fs = ts.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYY_HHmmss");
		String timeStamp = sdf.format(d);
		FileUtils.copyFile(fs, new File("./target/Test Results/TC1_"+timeStamp+"/image1.png"));
		System.out.println("Test1 Completed");
	}

	@Test(priority=3)
	public void test2() throws IOException {
		ExtentTest test2 = extent.createTest("Google Search TC2","Sample Google Search 2");
		System.out.println("I am inside Test2 | "+Thread.currentThread().getId());

		driver.get("https://www.google.com");
		test2.pass("Navigated to Google.com");

		TakesScreenshot ts = (TakesScreenshot)driver;
		File fs = ts.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYY_HHmmss");
		String timeStamp = sdf.format(d);
		FileUtils.copyFile(fs, new File("./target/Test Results/TC2_"+timeStamp+"/image1.png"));
		System.out.println("Test2 Completed");
	}

	@Test(priority=1)
	public void test3() throws IOException {
		ExtentTest test3 = extent.createTest("Google Search TC3","Sample Google Search");
		System.out.println("I am inside Test3 | "+Thread.currentThread().getId());

		driver.get("https://www.google.com");
		test3.pass("Navigated to Google.com");

		TakesScreenshot ts = (TakesScreenshot)driver;
		File fs = ts.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYY_HHmmss");
		String timeStamp = sdf.format(d);
		FileUtils.copyFile(fs, new File("./target/Test Results/TC3_"+timeStamp+"/image1.png"));
		System.out.println("Test3 Completed");
	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Suite Executed and Completed");
	}

	@AfterSuite	
	public void tearDown() {
		extent.flush();
	}

}
