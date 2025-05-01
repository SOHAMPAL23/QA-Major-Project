package prac;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown2 {

	static WebDriver driver;
	
	@BeforeMethod
	public void Setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://selenium-select-practice.vercel.app");

	}
	
// color choose 	
	@Test(priority =1)
	public static void test1() {
		driver.get("https://selenium-select-practice.vercel.app");
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@style=\"width: 100%; padding: 0.5rem; border-radius: 5px; border: 1px solid rgb(204, 204, 204); font-size: 1rem;\"]"));
		
		Select dropDown = new Select(staticDropdown);
		dropDown.selectByVisibleText("Blue");
		System.out.println(dropDown.getFirstSelectedOption().getText());
		
	}
	
// select option
	
	@Test(priority =2)
	public static void test2() throws InterruptedException {
		driver.get("https://selenium-select-practice.vercel.app");
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@style=\"width: 100%; padding: 0.5rem; border-radius: 5px; border: 1px solid rgb(204, 204, 204); font-size: 1rem; height: 120px;\"]"));
		
		Select dropDown = new Select(staticDropdown);
		
		dropDown.selectByIndex(0);
	
		dropDown.selectByIndex(1);
		
		dropDown.selectByIndex(3);
		
		List<WebElement> lists = dropDown.getOptions();
		for (WebElement list1: lists) {
			System.out.println(list1.getText()); 
		}
		Assert.assertTrue(true, "HTML");
		Assert.assertTrue(true, "CSS");
		Assert.assertTrue(true, "React");
	
		
		Thread.sleep(1000);
		dropDown.deselectAll();
	}
	
	// Radio button
	
	@Test(priority=3)
	public void radio() {
		String xpath = "//input[@value='Male']";
		WebElement element = driver.findElement(By.xpath(xpath));
		element.click();
		
		WebElement element1=driver.findElement(By.xpath("//input[@value='Female']"));
		WebElement element2=driver.findElement(By.xpath("//input[@value='Other']"));
		Assert.assertTrue(element.isSelected());
		Assert.assertFalse(element1.isSelected());
		Assert.assertFalse(element2.isSelected());
		
	}

	//Multi Select 
	@Test(priority=4)
	public void checkbox() throws InterruptedException {
		String xpath = "//input[@name=\"cherry\"]";
		WebElement element = driver.findElement(By.xpath(xpath));
		element.click();
		
		xpath="//input[@name=\"mango\"]";
		element=driver.findElement(By.xpath(xpath));
		element.click();
		
		xpath="//input[@name=\"orange\"]";
		element=driver.findElement(By.xpath(xpath));
		element.click();
		
		Assert.assertTrue(element.isSelected());
		
		Thread.sleep(2000);
		element.click();
		
	}
	
	
	@Test(priority=4)
    public void checkbox1() throws InterruptedException {
    	driver.get("https://selenium-select-practice.vercel.app/");
    	
    	WebElement rdbtn = driver.findElement(By.xpath("//input[@name='cherry']"));
    	rdbtn.click();
    	Assert.assertTrue(rdbtn.isSelected());
    	rdbtn = driver.findElement(By.xpath("//input[@name='mango']"));
    	rdbtn.click();
    	Assert.assertTrue(rdbtn.isSelected());
    	rdbtn = driver.findElement(By.xpath("//input[@name='orange']"));
    	rdbtn.click();
    	Assert.assertTrue(rdbtn.isSelected());
    	
    	rdbtn.click();
    	Assert.assertFalse(rdbtn.isSelected());
    	System.out.println("Test Case 4 passed");
    }
    
    @Test(priority=5)
    public void SpiceJet() throws InterruptedException {
    	driver.get("https://www.spicejet.com/");
    	WebElement return_date = driver.findElement(By.xpath("//div[@data-testid=\"return-date-dropdown-label-test-id\"]"));
    	Assert.assertTrue(return_date.isEnabled());
    	System.out.println("button is enabled");
    	WebElement from = driver.findElement(By.xpath("(//div[@class=\"css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-tju18j r-5njf8e r-1otgn73\"])[1]"));
    	from.click();
    	WebElement Beng = driver.findElement(By.xpath("//div[text() = \"Bengaluru\"]"));
    	Beng.click();
    	
    	WebElement to = driver.findElement(By.xpath("(//div[@class=\"css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-tju18j r-5njf8e r-1otgn73\"])[2]"));
    	to.click();
    	
    	List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"css-1dbjc4n r-19yat4t r-1rt2jqs\"]/div"));
    	
    	for(WebElement option : list) {
    		if(option.getText()=="Delhi") {
    			option.click();
    			break;
    		}
    	}
    	System.out.println("Test Case 5 passed");
    }

		
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
