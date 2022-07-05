package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchPage() {

    }


    @FindBy(xpath = "//div[@class='gekhq4-4 egoSnI']")
    public WebElement verifyLogin;

    @FindBy(xpath = "//input[@data-cy='header-search-input']")
    public WebElement searchBox;


    @FindBy(xpath = "(//li[@data-testid='pagination-list-item'])[2]")
    public WebElement nextPage;


    @FindBy(xpath = "//img[@src='https://mcdn01.gittigidiyor.net/77341/tn30/773415777_tn30_0.jpg']")
    public WebElement chooseProduct;


}
