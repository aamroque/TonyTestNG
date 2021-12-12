package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import Test.TestNG_Demo1;

//  This is to Demo how Properties Files work
// 	Config.properties file is found on src/test/java/Config/Config.properties

public class PropertiesFile {

	static Properties prop = new Properties();
	static String projectPath = System.getProperty("user.dir");

	public static void main(String[] args) {
		getProperties();
		setProperties();
		getProperties();
	}

	public static void getProperties() {
		try {
			InputStream input = new FileInputStream(projectPath+"/src/test/java/Config/Config.properties");
			prop.load(input);
			//The COnfig file is now declared in this class
			//You can start getting the values after this line.
			String browser = prop.getProperty("browser");
			System.out.println(browser);
			TestNG_Demo1.browserName=browser;

		}
		catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}

	public static void setProperties() {
		try {
			OutputStream output = new FileOutputStream(projectPath+"/src/test/java/Config/Config.properties");
			prop.setProperty("browser", "chrome");
			prop.store(output, null);
		}
		catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
}
