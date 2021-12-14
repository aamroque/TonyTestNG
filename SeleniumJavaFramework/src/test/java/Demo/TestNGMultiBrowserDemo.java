package Demo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserDemo {

	//After setting the browserName value in TestNGMultiBrowser xml
	//You can now run test cases on a specific browser by only updating 1 field
	//You can also test this in Parallel, see XML
	
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");

	@BeforeTest
	@Parameters("browserName")
	public void setUp(String browserName) {
		System.out.println("Browser Name is : "+browserName+" | "+Thread.currentThread().getId());
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"/webdrivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"/webdrivers/geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			driver = new FirefoxDriver(options);
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath+"/webdrivers/msedgedriver.exe");
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--headless");
			driver = new EdgeDriver(options);
		}
	}
		
	@Test
	public void test1() throws InterruptedException, IOException {
		driver.get("https://www.google.com");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File fs = ts.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYY_HHmmss");
		String timeStamp = sdf.format(d);
		FileUtils.copyFile(fs, new File("./target/Test Results/TC1_"+timeStamp+"/image1.png"));
		Thread.sleep(3000);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed");
	}

}
