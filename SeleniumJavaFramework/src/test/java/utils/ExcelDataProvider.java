package utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

// This is to Demo Excel Data Provider
// This is dependent on ExcelUtils Class
	
	//Below sample test will display all UN+PW in the excel
	@Test(dataProvider = "test1data")
	public void test1(String Username, String Password) {
		System.out.println(Username+" | "+Password);
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
