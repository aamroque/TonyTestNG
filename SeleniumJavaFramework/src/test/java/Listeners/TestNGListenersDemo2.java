package Listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

// This is for TestNG Listeners Demo
// This is dependent on TestNGListeners java class

// Once you have generated a testNG.xml for this class
// and declared this class under testng_Listener.xml file
// You can now omit below line
// @Listeners(TestNGListeners.class)

public class TestNGListenersDemo2 {
	
	@Test
	public void test4() {
		System.out.println("I am inside Test 4");
	}
	
	@Test
	public void test5() {
		System.out.println("I am inside Test 5");
		//Assert.assertTrue(false);
	}
	
	@Test
	public void test6() {
		System.out.println("I am inside Test 6");
		//throw new SkipException("This test is skipped");
	}
	
}
