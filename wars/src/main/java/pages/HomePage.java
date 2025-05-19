package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HomePage {
    private WebDriver driver;

    private By signInLink = By.linkText("Sign In");
    private By profileIcon = By.cssSelector(".user-avatar");

    
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void clickSignIn() {
        driver.findElement(signInLink).click();
    }

    public boolean isUserLoggedIn() {
        return driver.findElement(profileIcon).isDisplayed();
    }
}
