package prac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class amazonTestNG {
WebDriver driver;

    @BeforeMethod
    public void beforemethod(){
    	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=8752967527293722007&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062082&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1");
		}


    @DataProvider(name="userData")
    
    public Object[] [] data() {
    	System.out.println("Test 2 run");
		return new Object[] [] {
			{"9776630115","Som@135790"}
			
		};
    }
    

    @Test(dataProvider="userData")
    public void test3(String name,String pass) {
    	driver.findElement(By.id("nav-link-accountList")).click();
    	WebElement el=driver.findElement(By.id("ap_email_login"));
    	el.click();
    	el.sendKeys(name);
    	driver.findElement(By.xpath("//*[@class=\"a-button-input\"]")).click();
        WebElement a=driver.findElement(By.id("ap_password"));
        a.click();
        a.sendKeys(pass);
        driver.findElement(By.id("signInSubmit")).click();

    }
    
    @AfterMethod
    public void aftermethod() {
    	driver.quit();
    }




}