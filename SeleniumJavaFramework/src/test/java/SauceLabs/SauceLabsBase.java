package SauceLabs;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceLabsBase {

	WebDriver driver;
	
	@Parameters({"browser", "platformName"})
	@BeforeMethod
	public void setUp(String browserName, String platformName, Method name) {
		System.out.print("Browser name is : " + browserName +"\n");
		String methodName = name.getName();
				
		MutableCapabilities sauceOpts = new MutableCapabilities();
		sauceOpts.setCapability("name", methodName);
		sauceOpts.setCapability("build", "Java-W3C-Examples");
		sauceOpts.setCapability("seleniumVersion", "3.141.59");
		sauceOpts.setCapability("username", "wyndham1812");
		sauceOpts.setCapability("accessKey", "eba122d7-403b-460d-89e1-f4f56d39dece");
		sauceOpts.setCapability("tags", "w3c-chrome-tests");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("sauce:options", sauceOpts);
		cap.setCapability("browserVersion", "latest");
		cap.setCapability("platformName", platformName);
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			cap.setCapability("browserName", "chrome");	
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			cap.setCapability("browserName", "firefox");		
		}
//		else if(browserName.equals("edge")) {
//			WebDriverManager.edgedriver().setup();
//			cap.setCapability("browserName", "edge");		
//		}
		
		//https://wyndham1812:eba122d7-403b-460d-89e1-f4f56d39dece@ondemand.us-west-1.saucelabs.com:443/wd/hub
		try {
			driver = new RemoteWebDriver(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
