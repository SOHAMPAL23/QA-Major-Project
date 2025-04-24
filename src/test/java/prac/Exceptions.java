package prac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exceptions {
	
    WebDriver driver;
	
	
	@BeforeMethod
	public void Setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // implicit wait 
		driver.get("https://www.google.com");
	}
	
	@Test(priority=1)
	public static void arithmeticException()  {
		
		try {
			int a =10;
			int b=0;
			int result =a/b;
			System.out.print("Result " + result);
		}
		catch(ArithmeticException e) {
			System.out.print("Arithmetic Exception "+ e.getMessage());
		} 
		catch(Exception e) {
			System.out.println("Error Found : " + e.getMessage());
		}
		
	}
	
	@Test(priority=2)
	public void elementNotFound() {
		try {
			WebElement nonExistentElement = driver.findElement(By.id("nonExistentId"));
			System.out.println("After ");
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} 
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
	
}
