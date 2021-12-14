import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

	public static void main(String[] args) throws InterruptedException {
		
//      Always check your Browser version
		
		System.setProperty("webdriver.chrome.driver", "./webdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
 
//	    System.setProperty("webdriver.gecko.driver", "./webdrivers/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
//		System.setProperty("webdriver.edge.driver", "./webdrivers/msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
		
//		//IE will go away soon
//	    System.setProperty("webdriver.ie.driver", "./webdrivers/IEDriverServer.exe");
//		WebDriver driver = new InternetExplorerDriver();
		
//		OR USE WebDriverManager
//		System.setProperty("webdriver.chrome.driver","./webdrivers/chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver","./webdrivers/geckodriver.exe");
//		System.setProperty("webdriver.edge.driver","./webdrivers/msedgedriver.exe");
//		System.setProperty("webdriver.opera.driver","/path/to/operadriver");
//		System.setProperty("webdriver.ie.driver","/path/to/IEDriverServer");
			
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		
//		If you require a specific version, use below Syntax
//		WebDriverManager.chromedriver().driverVersion("2.36").setup();
//		WebDriver driver = new ChromeDriver();		
		
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver();
		
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver = new EdgeDriver();
		
//		WebDriverManager.operadriver().setup();
//		WebDriver driver = new OperaDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));		
		
		driver.get("https://www.google.com");
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		System.out.println("Test Completed");
	}
	
}
