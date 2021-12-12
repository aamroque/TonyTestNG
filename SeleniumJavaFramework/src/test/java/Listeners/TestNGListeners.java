package Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {

	public void onTestStart(ITestResult context) {
		System.out.println("======Test Started : "+context.getName());
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("======Test Failed : "+result.getName());
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("======Test Skipped : "+result.getName());
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("======Test Failed But within Success Percentage : "+result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("======Test Success : "+result.getName());
	}
	public void onTestFinish(ITestResult context) {
		System.out.println("======Test Finished : "+context.getName());
	}
}
