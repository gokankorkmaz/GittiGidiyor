package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public LoginPage() {

    }


    @FindBy(id = "L-UserNameField")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='L-PasswordField']")
    public WebElement password;

    @FindBy(id = "gg-login-enter")
    public WebElement loginEnter;


}
