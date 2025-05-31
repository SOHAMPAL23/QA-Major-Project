package prac;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown3{
WebDriver driver;
	
	@BeforeMethod
	  public void runTest() {
        WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.spicejet.com/");
    }
	
	@Test(priority = 1)
    public void spicejetAutocompleteLocation() throws InterruptedException {
       
        WebElement from = driver.findElement(By.xpath("(//input[@class=\"css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu\"])[1]"));
        from.sendKeys("Be");
        
        List<WebElement> fromPlaces = driver.findElements(By.xpath("//div[@class=\"css-76zvg2 r-cqee49 r-ubezar r-1kfrs79\"]"));
       
        for (WebElement place : fromPlaces) {
            if (place.getText().equals("Bengaluru")) { 
                place.click();
                System.out.println("Clicked on Bengaluru!");
                break; 
            }
        }
        Thread.sleep(2000);
        WebElement to = driver.findElement(By.xpath("(//input[@class=\"css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu\"])[2]"));
        to.sendKeys("De");
      
        List<WebElement> toPlaces = driver.findElements(By.xpath("//div[@class=\"css-76zvg2 r-cqee49 r-ubezar r-1kfrs79\"]"));
       
        for (WebElement place : toPlaces) {
            if (place.getText().equals("Delhi")) { 
                place.click();
                System.out.println("Clicked on Delhi!");
                break; 
            }
        }
        Thread.sleep(3000);
	
		String xpath="(//div[@class=\"css-1dbjc4n\"])[54]";
    	 WebElement element=driver.findElement(By.xpath(xpath));
    	element.click();
    	
    	xpath="//div[@data-testid=\"undefined-month-May-2025\"]//div[text()=\"5\"]";
    	element=driver.findElement(By.xpath(xpath));
    	element.click();
    	
    	xpath="(//div[@class=\"css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep\"])[4]";
    	element=driver.findElement(By.xpath(xpath));
    	element.click();
    	
    	xpath="(//div[@class=\"css-1dbjc4n\"])[56]";
    	element=driver.findElement(By.xpath(xpath));
    	element.click();
    	
    	Thread.sleep(2000);
    	xpath="(//div[@class=\"css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c\"])";
    	element=driver.findElement(By.xpath(xpath));
    	element.click();
    	
    	Thread.sleep(2000);
    	xpath="//div[@data-testid=\"undefined-month-August-2025\"] // div[text()=\"5\"]";
    	element=driver.findElement(By.xpath(xpath));
    	element.click();
    	
    	Thread.sleep(2000);    	
    
	}
 
    	
    
	
	@Test(priority=2)
	public void selectClass() throws InterruptedException {
		String xpath;
		WebElement element;

		// Define maximum limits
		int maxAdults = 9, maxInfants = 4, maxChildren = 4, minAdults = 4;

		xpath = "//div[@data-testid=\"home-page-travellers\"]";
		element = driver.findElement(By.xpath(xpath));
		element.click();

		// Increment adults
		xpath = "//div[@data-testid=\"Adult-testID-plus-one-cta\"]";
		element = driver.findElement(By.xpath(xpath));
		int adultCount = 0;
		while (adultCount < maxAdults) {
		    element.click();
		    adultCount++;
		}

		// Increment infants
		xpath = "//div[@data-testid=\"Infant-testID-plus-one-cta\"]";
		element = driver.findElement(By.xpath(xpath));
		int infantCount = 0;
		while (infantCount < maxInfants) {
		    element.click();
		    infantCount++;
		}

		// Decrement adults dynamically based on element state
		xpath = "//div[@data-testid=\"Adult-testID-minus-one-cta\"]";
		element = driver.findElement(By.xpath(xpath));
		while (adultCount > minAdults && element.getAttribute("class").contains("enabled")) {
		    element.click();
		    adultCount--;
		    element = driver.findElement(By.xpath(xpath));
		}

		// Increment children
		xpath = "//div[@data-testid=\"Children-testID-plus-one-cta\"]";
		element = driver.findElement(By.xpath(xpath));
		int childCount = 0;
		while (childCount < maxChildren && element.getAttribute("class").contains("enabled")) {
		    element.click();
		    childCount++;
		    element = driver.findElement(By.xpath(xpath));
		}

		Thread.sleep(2000); 
	}
	
	
	@Test(priority=3)
	public void currency() throws InterruptedException {

    	String xpath;
		WebElement element; 
    	xpath = "//div[text()=\"Currency\"]";
    	element = driver.findElement(By.xpath(xpath));
    	element.click();
    	
    	xpath = "//div[text()=\"USD\"]";
    	element = driver.findElement(By.xpath(xpath));
    	element.click();
    	
    	Thread.sleep(2000);
    	
    	
    }
	
	@Test(priority=4)
	public void radio() throws InterruptedException {
		String xpath;
		WebElement element;
		xpath = "(//div[@class=\"css-1dbjc4n r-18u37iz r-1w6e6rj\"])[2]/div[1]";
    	element = driver.findElement(By.xpath(xpath));
    	element.click();
    	Thread.sleep(1000);
    	xpath = "(//div[@class=\"css-1dbjc4n r-18u37iz r-1w6e6rj\"])[2]/div[2]";
    	element = driver.findElement(By.xpath(xpath));
    	element.click();
    	Thread.sleep(1000);
    	xpath = "(//div[@class=\"css-1dbjc4n r-18u37iz r-1w6e6rj\"])[2]/div[3]";
    	element = driver.findElement(By.xpath(xpath));
    	element.click();
    	Thread.sleep(1000);
    	xpath = "(//div[@class=\"css-1dbjc4n r-18u37iz r-1w6e6rj\"])[2]/div[6]";
    	element = driver.findElement(By.xpath(xpath));
    	element.click();
    	Thread.sleep(1000);
    	xpath = "(//div[@class=\"css-1dbjc4n r-18u37iz r-1w6e6rj\"])[2]/div[5]";
    	element = driver.findElement(By.xpath(xpath));
    	element.click();
    	Thread.sleep(1000);
    	xpath = "(//div[@class=\"css-1dbjc4n r-18u37iz r-1w6e6rj\"])[2]/div[4]";
    	element = driver.findElement(By.xpath(xpath));
    	element.click();
    	Thread.sleep(1000);
    	
    	xpath = "//div[@data-testid=\"home-page-flight-cta\"]";
    	element = driver.findElement(By.xpath(xpath));
    	element.click();
    	Thread.sleep(3000);
	}

	@AfterMethod
	 public void tearDown () {
		 driver.quit();
	 } 
}