package prac;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	JavascriptExecutor js;
	WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        js = (JavascriptExecutor)driver;
    }
    
    @Test(priority=1)
   	public void loginCheck() throws InterruptedException {
    	
       	driver.get("https://switch-tabs-qa-z77q.vercel.app/");
       	WebElement mail = driver.findElement(By.xpath("//input[@placeholder=\"Email\"]"));
       	WebElement pass = driver.findElement(By.xpath("//input[@placeholder=\"Password\"]"));
       	WebElement btn = driver.findElement(By.xpath("//button[text()=\"Login\"]")); 
       	
//       	mail.sendKeys("pst@gmail.com");
//       	pass.sendKeys("1");
//       	btn.click();
//       	
//       	Thread.sleep(2000);
//       	driver.switchTo().alert().accept();
//       	
//       	mail.clear();
//       	pass.clear();
//       	Thread.sleep(2000);
       	mail.sendKeys("pst@gmail.com");
       	pass.sendKeys("1234512345");
       	Thread.sleep(2000);
       	btn.click();
       	Alert alert = driver.switchTo().alert();
       	Thread.sleep(2000);//iframe
       	alert.accept();
       	
       	WebElement iframe = driver.findElement(By.xpath("//iframe"));
        Thread.sleep(1000);
       	driver.switchTo().frame(iframe);
       	WebElement clickBtn = driver.findElement(By.id("clickButton"));
       	clickBtn.click();
       	
       	WebElement btnText = driver.findElement(By.xpath("(//section[@class=\"section\"]/p)[1]"));
       	String output = btnText.getText();
       	Assert.assertEquals(output, "Button Clicked!");
       	
       	driver.switchTo().defaultContent();
       	
       	WebElement couponLink = driver.findElement(By.xpath("//a[@href=\"/coupon\"]"));
       	couponLink.click();
       	
       	ArrayList<String> tab = new ArrayList <>(driver.getWindowHandles());
       	driver.switchTo().window(tab.get(1));
       	
       	Thread.sleep(2000);
       	WebElement divTxt = driver.findElement(By.xpath("//span"));
	    String coupon = divTxt.getText();
	    driver.close();
	    
	    driver.switchTo().window(tab.get(0));
	
	    WebElement inputCoupon = driver.findElement(By.xpath("//input[@placeholder=\"Enter special code\"]"));
	    inputCoupon.sendKeys(coupon);
	    
	    WebElement submitBtn = driver.findElement(By.xpath("//button[text()=\"Submit Code\"]"));
	    submitBtn.click();
       
     
       }
    
    @Test(priority=2)
	public void amazoncon() throws InterruptedException {
		 driver.get("https://www.amazon.in/s?hidden-keywords=B0DP7BZ8FD+%7C+B0B4JPC8GT+%7C+B0D6MPVN7B+%7C+B0DFH99H7X+%7C+B0DPWRX9V6+%7C+B0D4M15QMW+%7C+B0B7RZCVLC+%7C+B0CYTD8DVF+%7C+B0DB1WCBBS+%7C+B0BP2M7CCS+%7C+B0CJ36X76S+%7C+B0DDL4CPZ5+%7C+B0DPXBHF8H+%7C+B0CJBP38HR+%7C+B0D4TGZG1H+%7C+B0CJ2KWNNQ+%7C+B0BVRKBNRH+%7C+B0D82F4JMC+%7C+B0CY2PZZJB+%7C+B0DCG26YC5+%7C+B0CCPBPYSB+%7C+B0BTVMBLZC+%7C+B0CCP9PH92+%7C+B0BQJ68HHC+%7C+B0C4ZM63RP+%7C+B0DTYKLHYC+%7C+B0DTYHD5D1+%7C+B0DRNSHRKK+%7C+B0BQJ7NMVM+%7C+B0D22LZFNT+%7C+B0DR96PF63+%7C+B0C4ZWLS7B+%7C+B0D46P4V5V+%7C+B0D2Y1BLDT+%7C+B0BQJ7WR2R+%7C+B0BV2FF71G+%7C+B0BRT8BRKY+%7C+B0C3RF3HT3+%7C+B0DB1SDB87+%7C+B0D2KDCWJL+%7C+B0B1MBFJJ2+%7C+B0D4M66F6R+%7C+B0CSG4G18G+%7C+B0DDY3XT48+%7C+B0DKG94BTN+%7C+B0C2HVSHX6+%7C+B0DSFQZTVW+%7C+B0DDL495SX+%7C+B0F2152TZL+%7C+B0BSDZY5FV+%7C+B0DTK9DZB4+%7C+B0F2162VGQ+%7C+B0DL5N2TFC+%7C+B0CLTW4D7T+%7C+B0CJBL2QWY+%7C+B0D4LZMJ5Z+%7C+B0C9JC8XDB+%7C+B0CJM5Z6FY+%7C+B0D4M1XZ3D+%7C+B0DYDZF2DQ+%7C+B0DYDZQYKP+%7C+B0D262KC1J+%7C+B0DTYGNS9P+%7C+B0DSFP9FCS+%7C+B0CWDBJ3Q8+%7C+B0D83D32DK+%7C+B0CJTRM3QW+%7C+B0BRTBVSHS+%7C+B0DTTS34NW+%7C+B0BSDYWDNG+%7C+B0C1GGJCSF+%7C+B0CHMZRC89+%7C+B0CHMYJ9BK+%7C+B0DMT4NLMR+%7C+B0C46JV581+%7C+B0DR8NCVY1+%7C+B0DDL27FHN+%7C+B0C5N5J44V+%7C+B0CYQ257C1+%7C+B0DCG279M2+%7C+B0CLTVYC1Q+%7C+B0D4Z8WJY4+%7C+B0DCG73TNK+%7C+B0B1MDHJCC+%7C+B0C2D3NV1S+%7C+B0C3D99LTP+%7C+B0CNK1VTZW+%7C+B0D1VKPSH7+%7C+B0D1VKJBP3+%7C+B0CY1Z82QW+%7C+B0DPX8PLQW+%7C+B0CRKQ144S+%7C+B0DSL4R3DL+%7C+B0C9HTBMLW+%7C+B0CWNL2NSL+%7C+B0D8WJX91M+%7C+B0BX9RCY3R+%7C+B0D22KDRLM+%7C+B0CRVKFF7X+%7C+B0D4VQP8M8+%7C+B0CRVJBGLS+%7C+B0DTKL6F17+%7C+B0D9LTHCQ9+%7C+B0CCSMVFWS+%7C+B0BVW6R9CH+%7C+B0B5GB1XZ6+%7C+B0DTYWCHDQ+%7C+B0DTYKSSDP+%7C+B0DTYTXNX2+%7C+B0CY1SF54S+%7C+B0DPXBBPB7+%7C+B0D4Z8TBXC+%7C+B0CRVKPYX2+%7C+B0DCG7GYZ2+%7C+B0C1CKBD29+%7C+B0D62FWHW6+%7C+B0D62BZYL6+%7C+B0C3MGYZQX+%7C+B0C3MGXYGK+%7C+B0DTYHV92K+%7C+B0DTYFPSN2+%7C+B0DTTS9B1F+%7C+B0D266DSG7+%7C+B0DTYL975Y+%7C+B0DFLQZMJD&crid=2LPI2SKSWN1GY&pf_rd_i=1375424031&pf_rd_m=A1VBAL9TL5WCBF&pf_rd_p=948ff67c-179e-4e0b-b421-bf32994ef8e9&pf_rd_r=RWDBD052KKH4KP7WYE9T&pf_rd_s=merchandised-search-6&sprefix=%2Caps%2C257&ref=nb_sb_noss_2");
		 WebElement element = driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-none a-spacing-top-small s-title-instructions-style\"]"));
		 element.click();
		 Set<String> windows =driver.getWindowHandles();
		 Iterator<String> ac = windows.iterator();
		 String parent = ac.next();
		 String child = ac.next();
		 driver.switchTo().window(child);
		 String desc = driver.findElement(By.xpath("(//li[@class=\"a-spacing-mini\"]/span)[1]")).getText();
		 js.executeScript("console.log(arguments[0]);",desc);
	}
    
    
//    @AfterMethod
//    public void closeBrowser() throws InterruptedException {
//    	Thread.sleep(10000);
//        driver.quit();
//    }
}