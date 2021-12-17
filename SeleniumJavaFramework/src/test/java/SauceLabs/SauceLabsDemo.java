package SauceLabs;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import org.testng.*;

public class SauceLabsDemo extends SauceLabsBase {

	public void doLogin() {
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}	
	
	@Test(priority=1)
	public void checkInventoryItemTest() {
		doLogin();
		System.out.println("This is Test 1");
	}
	
	@Test(priority=2)
	public void checkAddToCartButtonTest() {
		doLogin();
		System.out.println("This is Test 2");
	}
}
	