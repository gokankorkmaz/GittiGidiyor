package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasketPage {


    WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BasketPage() {

    }

    public String productPriceinBasketTxt;
    public String checkProductAmountTxt;

    @FindBy(xpath = "(//a[@href='https://www.gittigidiyor.com/bilgisayar-tablet/lenovo-v50a-11fk005rtx-i7-10700t-16gb-1tb-256ssd-radeon625-23-8-fullhd-freedos-all-in-one-bilgisaya_pdp_773415777'])[2]")
    public WebElement productInfoinBasket;


    @FindBy(xpath = "//div[@class='total-price']")
    public WebElement productPriceinBasket;


    @FindBy(xpath = "//select[@class='amount']")
    public WebElement increaseAmount;



    @FindBy(xpath = "(//a[@class='btn-delete btn-update-item'])[1]")
    public WebElement deleteProduct;

    @FindBy(xpath = "//h2[contains(text(),'Sepetinizde ürün bulunmamaktadır.')]")
    public WebElement verifyBasket;

}
