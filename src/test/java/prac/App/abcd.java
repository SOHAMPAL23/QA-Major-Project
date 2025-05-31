package prac.App;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class abcd {
     WebDriver driver;
	
	
	@BeforeMethod
	public void Setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // implicit wait 
	}
		
//		
	
	@Test 
	public void testImplicit() {
		driver.get("https://www.amazon.in");
		 // Click on the login/sign-in option
        WebElement signInBtn = driver.findElement(By.id("nav-link-accountList"));
        signInBtn.click();

        // Explicit wait for email input field
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"claim-input-container\"]")));

        // Enter email and proceed
        WebElement emailField = driver.findElement(By.xpath("//div[@id=\"claim-input-container\"]"));
        emailField.sendKeys("sohampal9811@gmail.com");

        // Click on Continue button
        driver.findElement(By.id("continue")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"password\"]")));

        WebElement passwordField = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        passwordField.sendKeys("SOHAMpal6011");
        driver.findElement(By.id("signInSubmit")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));

	}
	
//		@Test
//		public void test3() throws InterruptedException {
//			WebElement profile = driver.findElement(By.id("ember121"));
//			profile.click();
//			driver.navigate().back();
//			driver.navigate().forward();
//			driver.navigate().back();
//			
//			Thread.sleep(2000);
//		}
		
		//@Test
		//public void test4() throws InterruptedException {
//			driver.navigate().to("https://www.youtube.com/");
//			WebElement Search_btn = driver.findElement(By.cssSelector("input[name=\"search_query\"]"));
//			Search_btn.sendKeys("Polaris School of Technology");
//			Search_btn.sendKeys(Keys.ENTER);    // try with all keys functions
//			
//			Thread.sleep(3000);
//			
//			driver.navigate().back();
//		}
//		
//		@Test
//		public void test5() throws InterruptedException {
//			driver.navigate().to("https://www.amazon.in/");
//			Thread.sleep(3000);
//			driver.navigate().back();
//		}
			
//			@Test(priority=1)
//			public void test5() throws InterruptedException {
//				//WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
//				driver.get("https://www.amazon.in");
//				WebElement Search_btn = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
//				Search_btn.sendKeys("bat");
//				Search_btn.sendKeys(Keys.ENTER);    // try with all keys functions
////				
////				WebElement bat= driver.findElement(By.xpath("//a[@href=\"/sspa/click?ie=UTF8&spc=MToyMzM1NjA1ODkyNzA3NzA6MTc0NTMwNTE0MzpzcF9hdGY6MzAwNDcxMTU4MTY4MzMyOjowOjo&url=%2FCricket-Bat-Ball-Plastic-Tournament-Lightweight%2Fdp%2FB0DSLDJ1GB%2Fref%3Dsr_1_2_sspa%3Fdib%3DeyJ2IjoiMSJ9.ZKSermOgZcJCur7baTBtw5PlDO9ZAEklmdecsVPhPxIq0eZV8J1P8NEmWl0NpVUgDDKTWYY5zqNIaXu4I8d8r0VkKSeYckTSVLFpX7t_7RSVewFkMUF6QIIjKW8k9JiAwnsa5Gtqb_Zf25H9VBUaOyBG51upBCWcx8CWv6LnHq9WF3Mx_a-8rINelW5yjrFymb9-lFoiFtWIHrFBBbwhQiGU_dAIyYMaHel5pLTB2xOZfXDX8qe8jNWGd9eEAtuyaq6gjJq-sro7R536D02CvujK7RINwCYTCgpOV1vhZDM.V9bNqPNrOh9jQaZFuE859gcOvNqrE2QZqlGOngsEOJ8%26dib_tag%3Dse%26keywords%3Dbat%26qid%3D1745305143%26sr%3D8-2-spons%26sp_csd%3Dd2lkZ2V0TmFtZT1zcF9hdGY%26psc%3D1\"]"));
////				bat.click();
//				
//			//	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(""))); // until
//				
//				WebElement add = driver.findElement(By.xpath("//button[@id=\"a-autoid-1-announce\"]"));
//				add.click();
//			}	
			
			
			
			
		@AfterMethod
		public void tearDown() throws InterruptedException {
			Thread.sleep(3000);
			driver.quit();
		}
		
	}


// parent[] > child[]  by css selector
//  //input[@]  ny xpath