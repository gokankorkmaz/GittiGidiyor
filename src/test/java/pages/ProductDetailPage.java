package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {

    WebDriver driver;

    public ProductDetailPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public ProductDetailPage(){

    }


    public String productInfoTxt;
    public String productPriceTxt;


    @FindBy(xpath = "//h1[@id='sp-title']")
    public WebElement productInfo;


    @FindBy(id="sp-price-container")
    public WebElement productPriceInfo;


    @FindBy(css = "button[id='add-to-basket']")
    public WebElement addToBasket;

    //button[@id='add-to-basket']  --> xpath

    @FindBy(css = "a[class='header-cart-hidden-link']")
    public WebElement gotoBasket;


}
