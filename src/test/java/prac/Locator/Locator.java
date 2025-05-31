package prac;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locator {
	WebDriver driver;
	
	@BeforeMethod
	public void Setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void test4() throws InterruptedException {
		driver.navigate().to("https://www.youtube.com/");
		WebElement Search_btn = driver.findElement(By.cssSelector("input[name=\"search_query\"]"));
		Search_btn.sendKeys("Polaris School of Technology");
		Search_btn.sendKeys(Keys.ENTER);    // try with all keys functions	
		Thread.sleep(3000);		
		driver.navigate().back();
	}
			
	@Test
	public void test5() throws InterruptedException {
		driver.navigate().to("https://www.amazon.in/");
		Thread.sleep(3000);
		driver.navigate().back();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
