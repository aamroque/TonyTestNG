package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"/webdrivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath+"/webdrivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
	}
		
	@Test
	public void test1() throws InterruptedException {
		driver.get("https://www.google.com");
		Thread.sleep(3000);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("Test Completed");
	}

}
