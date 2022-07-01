package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class GittiGidiyorPage {


    WebDriver driver;

    public GittiGidiyorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GittiGidiyorPage() {

    }

    public String expectedUrl = "https://www.gittigidiyor.com/";
    public String expectedText="Hesabım";


    @FindBy(xpath = "//div[@class='wis_clsbtn']")
    public WebElement popup;


    @FindBy(xpath = "(//div[@class='gekhq4-4 egoSnI'])[1]")
    public WebElement login;

    @FindBy(css = "a[data-cy='header-login-button']")
    public WebElement loginButton;

    @FindBy(id="L-UserNameField")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='L-PasswordField']")
    public WebElement password;

    @FindBy(id="gg-login-enter")
    public WebElement loginEnter;


    @FindBy(xpath = "//div[@class='gekhq4-4 egoSnI']")
    public WebElement verifyLogin;

    @FindBy(className = "sc-4995aq-4 dNPmGY")
    public WebElement searchBox;
}
