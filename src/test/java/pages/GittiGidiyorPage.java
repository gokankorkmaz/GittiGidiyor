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
    public String expectedText = "Hesabım";
    public String expectedSecondPageUrl="https://www.gittigidiyor.com/arama?k=bilgisayar&sf=2";



    @FindBy(xpath = "//div[@class='wis_clsbtn']")
    public WebElement popup;


    @FindBy(xpath = "(//div[@class='gekhq4-4 egoSnI'])[1]")
    public WebElement login;

    @FindBy(css = "a[data-cy='header-login-button']")
    public WebElement loginButton;

    @FindBy(id = "L-UserNameField")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='L-PasswordField']")
    public WebElement password;

    @FindBy(id = "gg-login-enter")
    public WebElement loginEnter;


    @FindBy(xpath = "//div[@class='gekhq4-4 egoSnI']")
    public WebElement verifyLogin;

    @FindBy(xpath = "//input[@data-cy='header-search-input']")
    public WebElement searchBox;

    @FindBy(xpath = "(//li[@data-testid='pagination-list-item'])[2]")
    public WebElement secondPage;
}
