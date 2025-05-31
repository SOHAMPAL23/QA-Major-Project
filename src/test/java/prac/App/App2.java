package prac.App;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App2 {

	 WebDriver driver;
	 @BeforeMethod
	 public void setup(ITestContext context) {
	 try {
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 driver.get("https://www.youtube.com");
	 context.setAttribute("driver", driver);
	 } catch (Exception e) {
	 System.out.println("Driver failed to initialize: " + e.getMessage());
	 throw e;
	 }
	 }
	 @Test(priority = 1)
	 public void failedTest() {
	 System.out.println("Executing failedTest");

	 Assert.assertTrue(false);
	 driver.quit();
	 }
	
}
