package prac.App;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App1 {

	String xpath;
	WebElement element;
	WebDriver driver;
	String id;
	
	@Test
	public void runTest() {
        WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
        driver.getTitle();
        Assert.assertEquals(false, null);
        System.out.print("Failed");
        
    }
	
	
	
	@Test
	 public void tearDown () throws InterruptedException {
		Thread.sleep(5000);
		 driver.quit();
	 }
}
