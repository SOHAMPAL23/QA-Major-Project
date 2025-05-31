package prac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazon {
	String xpath;
	WebElement element;
	WebDriver driver;
	String id;

	
	@BeforeMethod
	  public void runTest() {
        WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=5248367421345319866&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062082&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1");
    }
	
	@Test(priority = 1)
    public void spicejetAutocompleteLocation() throws InterruptedException {
		Actions a =new Actions(driver);
		Thread.sleep(2000);
       xpath="(//div[@class=\"nav-div\"])[1]";
       element=driver.findElement(By.xpath(xpath));
       a.moveToElement(element).perform();
       
       xpath="(//span[@style=\"unicode-bidi:isolate; direction:ltr;\"])[3]";
       element=driver.findElement(By.xpath(xpath));
       element.click();
	}
	
	@Test(priority=2)
	public void signin() throws InterruptedException
	{
		Actions a =new Actions(driver);
		Thread.sleep(2000);
       id="nav-link-accountList";
       element=driver.findElement(By.id(id));
       a.moveToElement(element).perform();
       
       xpath="//span[@class=\"nav-action-inner\"]";
       element=driver.findElement(By.xpath(xpath));
       element.click();
		
       Thread.sleep(2000);
       id="ap_email_login";
       element=driver.findElement(By.id(id));
       element.sendKeys("9811434406");
       
       xpath="//input[@class=\"a-button-input\"]";
       element=driver.findElement(By.xpath(xpath));
       element.click();
       
       Thread.sleep(5000);
       id="ap_password";
       element=driver.findElement(By.id(id));
       element.sendKeys("SOHAMpal6011");
       
       id="signInSubmit";
       element=driver.findElement(By.id(id));
       element.click();
       
       Thread.sleep(2000);
       xpath="(//div[@class=\"nav-div\"])[1]";
       element=driver.findElement(By.xpath(xpath));
       a.moveToElement(element).perform();
       
       xpath="(//span[@style=\"unicode-bidi:isolate; direction:ltr;\"])[1]";
       element=driver.findElement(By.xpath(xpath));
       element.click();
	}
	
	@AfterMethod
	 public void tearDown () throws InterruptedException {
		Thread.sleep(5000);
		 driver.quit();
	 } 
}


