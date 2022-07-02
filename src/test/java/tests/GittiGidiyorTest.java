package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.GittiGidiyorPage;
import utilities.TestBase;

import javax.swing.*;

public class GittiGidiyorTest extends TestBase {

    @Test
    public void goGittiGidiyor() throws InterruptedException {
        //1. Navigate to url 'https://www.gittigidiyor.com/'
        //2.Verify that Gittigidiyor is open successfully
        //3. Close popup button
        //4. Click on 'Giriş Yap' button
        //5.Login Account
        //6.Verify login successful
        //7.Search "Bilgisayar" on the searchbox


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
        gittiGidiyorPage.userName.sendKeys("lepifik442@hekarro.com");
        gittiGidiyorPage.password.sendKeys("Lincoln1010");
        gittiGidiyorPage.loginEnter.click();


        //6.Verify login successful
        Assert.assertTrue(gittiGidiyorPage.verifyLogin.getText().contains(gittiGidiyorPage.expectedText));


        //7.Search "Bilgisayar" on the searchbox
        gittiGidiyorPage.searchBox.sendKeys("bilgisayar" + Keys.ENTER);

        //8.go to page two
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", gittiGidiyorPage.secondPage);
        gittiGidiyorPage.secondPage.click();

        Thread.sleep(2000);


        //9.Verify that the second page opens
        Assert.assertTrue(driver.getCurrentUrl().contains(gittiGidiyorPage.expectedSecondPageUrl));
    }


}
