package utils;

public class ExcelUtilsDemo {

// This is to Demo how to use Excel as utils location
// Functions are located at ExcelUtils.java
	
	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projectPath+"/Excel/TestData.xlsx", "Sheet1");
		
		//You can now call your functions from ExcelUtils.java class
		excel.getRowCount();
		excel.getColCount();
		excel.getCellDataString(0, 0);
		excel.getCellDataNumber(1, 1);
	}
	
}
