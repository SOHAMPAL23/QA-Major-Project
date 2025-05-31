package prac.App;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class App {		
		WebDriver driver;
	    WebDriverWait wait;
	    String id;
	    JavascriptExecutor js;
	    WebElement element;

	    
	    @BeforeSuite
	    public void beforeSuite() {
	        System.out.println("Before Suite");
	    }
	    @BeforeTest
	    public void openBrowser() {
	       
	    }

	    @BeforeTest
	    @Parameters({"env", "browser"})
	    public void beforeTest(String env, String browser) {
	        System.out.println("Before Test - Environment: " + env + ", Browser: " + browser);
	    }

	    @BeforeClass
	    public void beforeClass() {
	        System.out.println("Before Class");
	    }

	    @BeforeMethod
	    public void beforeMethod() {
	        System.out.println("Before Method");
	    }

	    @Test(priority = 0, groups = {"smoke"})
	    public void testLogin() {
	        System.out.println("Executing testLogin - Smoke Test");
	    }

	    @Test(priority = 1, groups = {"regression"})
	    public void testUserRegistration() {
	        System.out.println("Executing testUserRegistration - Regression Test");
	    }

	    @Test(priority = 2, dependsOnMethods = {"testLogin"}, groups = {"smoke", "regression"})
	    public void testProfileUpdate() {
	        System.out.println("Executing testProfileUpdate - Smoke & Regression Test");
	    }

	    @Test(priority = 3, dataProvider = "userData")
	    public void testParameterized(String username, String email) {
	        System.out.println("Executing Parameterized Test - Username: " + username + ", Email: " + email);
	    }
//	    @Test (groups = {"tests"})
//		public void test1() {
//	    	 WebDriverManager.chromedriver().setup();
//	         driver = new ChromeDriver();
//	         driver.manage().window().maximize();
//	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
//	         js = (JavascriptExecutor)driver;
//			driver.get("https://www.amazon.in/");
//			
//			WebElement element = driver.findElement(By.id("searchDropdownBox"));
//			
//			Select dropDown = new Select(element);
//			
//			
//			dropDown.selectByIndex(6);
//			System.out.println(dropDown.getFirstSelectedOption().getText());
//			
//			element = driver.findElement(By.id("twotabsearchtextbox"));	
//			element.sendKeys("Batman");
//			element.sendKeys(Keys.ENTER);
//			
//			element = driver.findElement(By.id("a-autoid-1-announce"));
//			
//			element.click();
//			
//			
//		}
	//	
//		@Test (groups = {"tests" , "test2"})
//		public void test2() {
//			 WebDriverManager.chromedriver().setup();
//		        driver = new ChromeDriver();
//		        driver.manage().window().maximize();
//		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
//		        js = (JavascriptExecutor)driver;
//			driver.get("https://www.amazon.in/");
	//
	//
//			WebElement element = driver.findElement(By.id("searchDropdownBox"));
	//
//			Select dropDown = new Select(element);
	//
	//
//			dropDown.selectByIndex(6);
//			System.out.println(dropDown.getFirstSelectedOption().getText());
//			element = driver.findElement(By.id("twotabsearchtextbox"));	
//			element.sendKeys("Batman");
//			element.sendKeys(Keys.ENTER);
//			
//			element = driver.findElement(By.id("a-autoid-2-announce"));
	//
//			element.click();
//		}


	    @DataProvider(name = "userData")
	    public Object[][] getUserData() {
	        return new Object[][]{
	            {"Chandan", "Chandan@gmail.com"},
	            {"Shivam", "Shivam@gmail.com"}
	        };
	    }

	    @AfterMethod
	    public void afterMethod() {
	        System.out.println("After Method");
	    }

	    @AfterClass
	    public void afterClass() {
	        System.out.println("After Class");
	    }

	    @AfterTest
	    public void afterTest() {
	        System.out.println("After Test");
	    }

	    @AfterSuite
	    public void afterSuite() {
	        System.out.println("After Suite");
	    }
	
	
	
	
	
	
//	    @BeforeSuite
//	    public void beforeSuite() {
//	        System.out.println("Before Suite");
//	    }
//
//	    @BeforeTest
//	    @Parameters({"env", "browser"})
//	    public void beforeTest(String env, String browser) {
//	        System.out.println("Before Test - Environment: " + env + ", Browser: " + browser);
//	    }
//
//	    @BeforeClass
//	    public void beforeClass() {
//	        System.out.println("Before Class");
//	    }
//
//	    @BeforeMethod
//	    public void beforeMethod() {
//	        System.out.println("Before Method");
//	    }
//
//	    @Test(priority = 0, groups = {"smoke"})
//	    public void testLogin() {
//	        System.out.println("Executing testLogin - Smoke Test");
//	    }
//
//	    @Test(priority = 1, groups = {"regression"})
//	    public void testUserRegistration() {
//	        System.out.println("Executing testUserRegistration - Regression Test");
//	    }
//
//	    @Test(priority = 2, dependsOnMethods = {"testLogin"}, groups = {"smoke", "regression"})
//	    public void testProfileUpdate() {
//	        System.out.println("Executing testProfileUpdate - Smoke & Regression Test");
//	    }
//
//	    @Test(priority = 3, dataProvider = "userData")
//	    public void testParameterized(String username, String email) {
//	        System.out.println("Executing Parameterized Test - Username: " + username + ", Email: " + email);
//	    }
//
//	    @DataProvider(name = "userData")
//	    public Object[][] getUserData() {
//	        return new Object[][]{
//	            {"Chandan", "Chandan@gmail.com"},
//	            {"Shivam", "Shivam@gmail.com"}
//	        };
//	    }
//
//	    @AfterMethod
//	    public void afterMethod() {
//	        System.out.println("After Method");
//	    }
//
//	    @AfterClass
//	    public void afterClass() {
//	        System.out.println("After Class");
//	    }
//
//	    @AfterTest
//	    public void afterTest() {
//	        System.out.println("After Test");
//	    }
//
//	    @AfterSuite
//	    public void afterSuite() {
//	        System.out.println("After Suite");
//	    }
}
//div/followin