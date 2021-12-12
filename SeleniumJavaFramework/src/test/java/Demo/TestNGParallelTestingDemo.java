package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGParallelTestingDemo {

	WebDriver driver = null;
	
	//use below values to run in multi-thread
	//this means test1 will run 3 times
	@Test(threadPoolSize=3, invocationCount=3, timeOut=1000)
	public void test1() {
		System.out.println("I am inside test1 | "+Thread.currentThread().getId());
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.close();		
	}
	
	@Test
	public void test2() {
		System.out.println("I am inside test2 | "+Thread.currentThread().getId());
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.close();		
	}
	
	@Test
	public void test3() {
		System.out.println("I am inside test3 | "+Thread.currentThread().getId());
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.close();		
	}
	
}
