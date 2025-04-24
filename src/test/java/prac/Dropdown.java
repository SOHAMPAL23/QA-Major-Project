package prac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

static WebDriver driver;
	
	@BeforeMethod
	public void Setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //driver.get("https://www.amazon.in/");

	}
	
	@Test(priority =1)
	public static void test() {
		driver.get("https://www.amazon.in/b?node=976419031");
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@class=\"nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown\"]"));
		
		Select dropDown = new Select(staticDropdown);
		
		dropDown.selectByIndex(1);
		System.out.println(dropDown.getFirstSelectedOption().getText());
		
		dropDown.selectByVisibleText("Amazon Fresh");
		System.out.println(dropDown.getFirstSelectedOption().getText());

		dropDown.selectByValue("search-alias=fashion");
		System.out.println(dropDown.getFirstSelectedOption().getText());

	}
	
	@Test(priority=2)
	public void selectBatman() throws InterruptedException {
		  driver.get("https://www.amazon.in/gp/browse.html?node=1389401031&ref_=nav_em_sbc_mobcomp_all_mobiles_0_2_8_2");

	        WebElement searchdropdown = driver.findElement(By.id("searchDropdownBox"));
	        Select dropdown = new Select(searchdropdown);
	        dropdown.selectByIndex(0);
	        System.out.println(dropdown.getFirstSelectedOption().getText());

	        WebElement srchbx = driver.findElement(By.id("twotabsearchtextbox"));
	        srchbx.sendKeys("batman");
	        srchbx.sendKeys(Keys.ENTER);
	        
	        String tt = driver.findElement(By.xpath("(//a[@class=\"a-link-normal s-line-clamp-4 s-link-style a-text-normal\"])[1]")).getText();
	        System.out.println(tt);

	        driver.navigate().back();

	  
	        searchdropdown = driver.findElement(By.id("searchDropdownBox"));
	        dropdown = new Select(searchdropdown); 
	        dropdown.selectByVisibleText("Books");

	        srchbx = driver.findElement(By.id("twotabsearchtextbox"));
	        srchbx.clear(); 
	        srchbx.sendKeys("batman");
	        srchbx.sendKeys(Keys.ENTER);
	        
	        String tc = driver.findElement(By.xpath("(//a[@class=\"a-link-normal s-line-clamp-4 s-link-style a-text-normal\"])[1]")).getText();
	        System.out.println(tc);

	        Assert.assertNotEquals(tt, tc);



	}

	@Test(priority=3)
	public void selectClassFlipkart() throws InterruptedException {
		driver.get("https://www.flipkart.com/search?q=laptop&sid=6bo%2Cb5g&as=on&as-show=on&otracker=AS_QueryStore_HistoryAutoSuggest_1_3_na_na_na&otracker1=AS_QueryStore_HistoryAutoSuggest_1_3_na_na_na&as-pos=1&as-type=HISTORY&suggestionId=laptop%7CLaptops&requestId=6df323eb-8acd-4691-940b-0d28c435ea4c");
		WebElement minDropdown = driver.findElement(By.xpath("//div[@class=\"suthUA\"]/select"));
		WebElement maxDropdown = driver.findElement(By.xpath("//div[@class=\"tKgS7w\"]/select"));

		
		Select dropdownMin = new Select(minDropdown);
		Select dropdownMax = new Select(maxDropdown);

		Thread.sleep(2000);
		
		dropdownMin.selectByIndex(2);
		System.out.println(dropdownMin.getFirstSelectedOption().getText());
		
		Thread.sleep(2000);
		
		dropdownMax.selectByVisibleText("₹60000");
		System.out.println(dropdownMax.getFirstSelectedOption().getText());
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
