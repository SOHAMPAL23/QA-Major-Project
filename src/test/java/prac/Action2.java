package prac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action2 {

	
	WebDriver driver;
	String id;
	String xpath;
	WebElement element;
	JavascriptExecutor js;
	
	@BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
         js = (JavascriptExecutor)driver;
    }
	
	
	@Test(priority=1)
    public void teardown() throws InterruptedException{
    	driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=748926027055&hvpos=&hvnetw=g&hvrand=15332655698738012773&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062082&hvtargid=kwd-64107830&hydadcr=14452_2417699&gad_source=1");
    	WebElement btn=driver.findElement(By.id("navBackToTop"));
    	js.executeScript("window.scrollBy(arguments[0],arguments[1])",0,6000);
    	Thread.sleep(5000);
    	js.executeScript("window.scrollBy(arguments[0],arguments[1])",0,-6000);
    	//zoom
    	js.executeScript("document.body.style.zoom ='20%';");
    	Thread.sleep(5000);
    	//zoom
    	js.executeScript("document.body.style.zoom ='125%';");
    	// height
    	js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
    	
    
		 js.executeScript("console.log(1234);");
    	
    }
	
	@Test(priority=2)
	
	public void enable() throws InterruptedException {
		driver.get("https://action-class-practice.vercel.app/");
		WebElement btn=driver.findElement(By.id("clickButton"));
		js.executeScript("arguments[0].setAttribute('disabled','');",btn);
		Thread.sleep(4000);
		if(btn.isEnabled()) {
			System.out.println("Not Clicked");
		}else {
			System.out.print("Clicked");
		}
	}

	@Test(priority=3)
	public void borderColor() throws InterruptedException {
		driver.get("https://action-class-practice.vercel.app/");
		WebElement btn=driver.findElement(By.id("disabledButton"));
		js.executeScript("arguments[0].style.border='200px solid red';",btn);
		Thread.sleep(4000);
		if(btn.isEnabled()) {
			System.out.println("Not Clicked");
		}else {
			System.out.print("Clicked");
		}
	}
	
	  @AfterMethod
	    public void closeBrowser() throws InterruptedException {
	        driver.quit();
	    }

	
}
