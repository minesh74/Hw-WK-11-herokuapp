package saucedemo_testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
public class LoginTest  extends BaseTest {
    String baseurl = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        WebElement username = driver.findElement(By.name("user-name"));
        username.sendKeys("standard_user");
        //Enter “SuperSecretPassword!” password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        //Verify the text “PRODUCTS”
        WebElement productsText = driver.findElement(By.xpath("//span[text()='Products']"));
        String actualText = productsText.getText();
        String expectedText = "PRODUCTS";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    //div[@class='inventory_item']
    //verifyThatSixProductsAreDisplayedOnPage
    public void verifyThatSixProductsAreDisplayedOnPage() {
      // Enter 'standard_user' username
        WebElement Username = driver.findElement(By.id("user-name"));
        Username.sendKeys("standard_user");
        //Enter "secret_sauce" password
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("secret_sauce");
        //Click on Login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        //VERIFY THAT SIX PRODUCTS ARE DISPLAYED ON PAGE
        int expectedCount = 6;
        int actualCount = driver.findElements(By.xpath("//div[@class='inventory_item']")).size();
        Assert.assertEquals(expectedCount,actualCount);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}