package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import utilities.TestBase;

import java.io.*;

public class GittiGidiyorTest extends TestBase {

    @Test
    public void goGittiGidiyor() throws InterruptedException, IOException {
        //1. Navigate to url 'https://www.gittigidiyor.com/'
        //2.Verify that Gittigidiyor is open successfully
        //3. Close popup button
        //4. Click on 'Giriş Yap' button
        //5.Login Account
        //6.Verify login successful
        //7.Search "Bilgisayar" on the searchbox
        //8.go to page two
        //9.Verify that the second page opens
//TODO 19 :Senaryonun geri kalan kısmını ingilizce olarak yaz.


        //1. Navigate to url 'https://www.gittigidiyor.com/'
        driver.get("https://www.gittigidiyor.com/");
        GittiGidiyorPage gittiGidiyorPage = new GittiGidiyorPage(driver);


        //2.Verify that Gittigidiyor is open successfully
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(gittiGidiyorPage.expectedUrl, actualUrl);

        //3. Close popup button
        gittiGidiyorPage.popup.click();

        //4. Click on 'Giriş Yap' button
        Actions actions = new Actions(driver);
        actions.moveToElement(gittiGidiyorPage.login).build().perform();
        actions.moveToElement(gittiGidiyorPage.loginButton);
        actions.click().build().perform();


        //5.Login Account
        LoginPage loginPage = new LoginPage(driver);

        loginPage.userName.sendKeys("lepifik442@hekarro.com");
        loginPage.password.sendKeys("Lincoln1010");
        loginPage.loginEnter.click();


        //6.Verify login successful
        SearchPage searchPage = new SearchPage(driver);

        Assert.assertTrue(searchPage.verifyLogin.getText().contains(gittiGidiyorPage.expectedText));


        //7.Search "Bilgisayar" on the searchbox
        searchPage.searchBox.sendKeys("bilgisayar" + Keys.ENTER);

        //8.Go to page two
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", searchPage.nextPage);
        searchPage.nextPage.click();


        //9.Verify that the second page opens
        Assert.assertTrue(driver.getCurrentUrl().contains(gittiGidiyorPage.expectedSecondPageUrl));


        //10.Select a product
        searchPage.chooseProduct.click();

        //11.Product information and amount information are written to the txt file
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        productDetailPage.productInfoTxt = productDetailPage.productInfo.getText();
        productDetailPage.productPriceTxt = productDetailPage.productPriceInfo.getText();

        File file = new File("file.txt");
        FileWriter writer = new FileWriter(file);
        //writer.write("How are you doing?");
        writer.write("Product Info: " + productDetailPage.productInfoTxt + "\n" + "Price Info: " + productDetailPage.productPriceTxt);
        writer.close();

        //12.Add the product to cart and go to the basket
        productDetailPage.addToBasket.click();
        productDetailPage.gotoBasket.click();


        //13.Compare the accuracy of the price on the product page with the price on the cart page.

        BasketPage basketPage = new BasketPage(driver);
        basketPage.productPriceinBasketTxt = basketPage.productPriceinBasket.getText();
        System.out.println("Sepetteki Ürün Tutarı " + basketPage.productPriceinBasketTxt);
        System.out.println("Product Sayfasındaki Ürün Tutarı " + productDetailPage.productPriceTxt);

        Assert.assertEquals(productDetailPage.productPriceTxt, basketPage.productPriceinBasketTxt);

        //TODO 13 : yorum satırları silinecek.


        //TODO 14.ürün miktarını arttır
        Select dropdown = new Select(basketPage.increaseAmount);
        dropdown.selectByValue("2");

        //TODO 15.ürün adetinin 2 olduğunun kontrolü
        basketPage.checkProductAmountTxt = String.valueOf(dropdown.getFirstSelectedOption());
        //basketPage.checkProductAmountTxt=basketPage.checkProductAmount.getText();
        System.out.println("Selected element: " + basketPage.checkProductAmountTxt);


        //TODO 16.Ürünü sepetten sil
        basketPage.deleteProduct.click();

        //TODO 17.Sepetin boş olduğunun kontrolünü yap

        Thread.sleep(2000);
        //TODO 18 Sleep metodu DriverWait ile Değiştirilebilir.
        Boolean b= basketPage.verifyBasket.isDisplayed();
        System.out.println("Dönen Değer: "+ b);
        //TODO 20 logları sil
        Assert.assertTrue(basketPage.verifyBasket.isDisplayed());

        //TODO 21 Logları Log4j ile güncelle.



    }


}
