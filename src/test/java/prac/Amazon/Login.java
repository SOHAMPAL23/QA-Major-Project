package prac.Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import prac.Base.Base;

public class Login extends Base {

    @FindBy(name="Login")
    WebElement loginButton;

    @FindBy(xpath="")
    WebElement login;

    @FindBys({
    	@FindBy(),
        @FindBy()
    })
    WebElement logAnd;

    @FindAll({
    	@FindBy(),
        @FindBy()
    })
    
    WebElement logOr;

    public Login() {
        PageFactory.initElements(driver, this);
    }
}
