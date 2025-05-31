package prac.Screenshots;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Screenshots implements ITestListener {
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: " + result.getName());
		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("driver");
		if (driver != null) {
			System.out.println("Driver found, taking screenshot...");
			takeScreenshot(driver, result.getName());
		} else {
			System.out.println("Driver is NULL in onTestFailure. Cannot take screenshot.");
		}
	}


	public void takeScreenshot(WebDriver driver, String testName) {
	    try {
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        String screenshotName = "screenshots/" + testName + "_" + timestamp + ".png";

	        new File("screenshots").mkdirs(); // Ensure directory exists
	        FileUtils.copyFile(screenshot, new File(screenshotName)); // Corrected method

	        System.out.println("Screenshot saved at: " + screenshotName);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
		
		
	 @Override
	 public void onStart(ITestContext context) {
	 System.out.println("Test Started");
	 }
	 @Override
	 public void onFinish(ITestContext context) {
	 System.out.println("Test Ended");
	 }
	 @Override
	 public void onTestSuccess(ITestResult result) {
	 System.out.println("Test Passed: " + result.getName());
	 }
	 @Override
	 public void onTestSkipped(ITestResult result) {
	 System.out.println("Test Skipped: " + result.getName());
	 }
}
