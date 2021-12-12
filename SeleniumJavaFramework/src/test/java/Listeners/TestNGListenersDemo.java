package Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

// This is for TestNG Listeners Demo
// This is dependent on TestNGListeners java class

// Once you have generated a testNG.xml for this class
// and declared this class under testng_Listener.xml file
// You can now omit below line
// @Listeners(TestNGListeners.class)

public class TestNGListenersDemo {
	
	@Test(priority = 1)
	public void test1() {
		System.out.println("I am inside Test 1");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		WebElement textBox = driver.findElement(By.name("q"));
		textBox.sendKeys("Automation");
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
	}
	
	@Test(priority = 2)
	public void test2() {
		System.out.println("I am inside Test 2");
		//Assert.assertTrue(false);
	}
	
	@Test(priority = 3)
	public void test3() {
		System.out.println("I am inside Test 3");
		//throw new SkipException("This test is skipped");
	}
	
}
