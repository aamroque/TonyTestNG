

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesTest {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		//driver.manage().window().minimize();
		//driver.manage().window().fullscreen();
		//driver.manage().window().setSize(new Dimension(1366,768));
		
		driver.get("https://www.google.com");
		//String originalWindow = driver.getWindowHandle();
		//driver.navigate().to("https://www.selenium.dev");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		//driver.navigate().back();
		//Thread.sleep(1000);
		//driver.navigate().forward();
		//Thread.sleep(1000);
		//driver.navigate().refresh();
		
		//driver.switchTo().newWindow(WindowType.WINDOW);
		//driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().window(originalWindow);
	
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./image1.png"));
		Thread.sleep(5000);
		
	    driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile2, new File("./image2.png"));
	    Thread.sleep(5000);
	    
	    driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("AddHasContext")).click();
		driver.switchTo().defaultContent();
		File scrFile3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile3, new File("./image3.png"));
		Thread.sleep(5000);
		
		driver.switchTo().frame("classFrame");
		driver.findElement(By.linkText("AdditionalHttpCommands.class")).click();
		driver.switchTo().defaultContent();
		File scrFile4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile4, new File("./image4.png"));
		Thread.sleep(5000);
		
		driver.manage().window().getSize().getWidth();
		driver.manage().window().getSize().getHeight();
		Dimension size = driver.manage().window().getSize();
		System.out.println(size.getWidth());
		System.out.println(size.getHeight());
		
//		//If a button has JS function, use below sample syntax
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		WebElement button = driver.findElement(By.name("btnI"));
//		js.executeScript("arguments[0].click();",button);
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}
}
