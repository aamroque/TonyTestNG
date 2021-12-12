package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelUtils;

public class ExcelDataProviderSampleTC {

// This is to Demo Excel Data Provider
// This is dependent on ExcelUtils Class
// Make TEST CASES WITH THIS
	
	static WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		//System.setProperty("webdriver.chrome.driver", "./webdrivers/chromedriver.exe");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	//Below sample test will display all UN+PW in the excel
	@Test(dataProvider = "test1data")
	public void test1(String Username, String Password) throws InterruptedException {
		System.out.println(Username+" | "+Password);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(Username);
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		Thread.sleep(2000);
	}

	//This is your TestNG Function
	@DataProvider(name = "test1data")
	public Object[][] getData() {
		String excelPath = "C:/Users/trmro/eclipse-workspace/SeleniumJavaFramework/Excel/TestData.xlsx";
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
	}
	
	public Object[][] testData(String excelPath, String sheetName) {
		
		ExcelUtils  excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		//This is an object array
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i=1; i<rowCount; i++) {
		for(int j=0; j<colCount; j++) {
		String cellData = excel.getCellDataString(i, j);
		//System.out.print(cellData+" | ");
		data[i-1][j] = cellData;
		}
		//System.out.println();
	    }
		return data;
	}
}
