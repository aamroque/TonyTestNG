package Demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TestNGParallelTestingDemo {

	WebDriver driver = null;
	
	//use below values to run in multi-thread
	//this means test1 will run 3 times
	//@Test(threadPoolSize=3, invocationCount=3, timeOut=1000)
	@Test
	public void test1() throws IOException {
		System.out.println("I am inside test1 | "+Thread.currentThread().getId());
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/webdrivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./target/Test Results/TC1/image1.png"));
		driver.close();		
	}
	
	@Test
	public void test2() throws IOException {
		System.out.println("I am inside test2 | "+Thread.currentThread().getId());
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/webdrivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile2, new File("./target/Test Results/TC2/image1.png"));
		driver.close();		
	}
	
	@Test
	public void test3() throws IOException {
		System.out.println("I am inside test3 | "+Thread.currentThread().getId());
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/webdrivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		File scrFile3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile3, new File("./target/Test Results/TC3/image1.png"));
		driver.close();		
	}
	
}
