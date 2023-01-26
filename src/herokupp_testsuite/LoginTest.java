package herokupp_testsuite;
       /*Create the package ‘testsuite’ and create the following
         class inside the ‘testsuite’ package.
       1. LoginTest
       3. Write down the following test into ‘LoginTest’ class
       1. userShouldLoginSuccessfullyWithValidCredentials
         * Enter “tomsmith” username
         * Enter “SuperSecretPassword!” password
          * Enter “tomsmith1” username
        * Enter “SuperSecretPassword!” password
        * Click on ‘LOGIN’ button
        * Verify the error message “Your username   is invalid!”
        3. verifyThePasswordErrorMessage
         * Enter “tomsmith” username
         * Enter “SuperSecretPassword” password
         * Click on ‘LOGIN’ button
         * Verify the error message “Your password is invalid!”
          */
import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
public class LoginTest extends BaseTest {
    String baseurl = "http://the-internet.herokuapp.com/login";
    @Before
    public void setup() {
        openBrowser(baseurl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter “tomsmith” username
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("tomsmith");
        //Enter “SuperSecretPassword!” password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();
        // Verify the text “Secure Area”
        WebElement msg = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2"));
        String actualText = msg.getText();
        String expectedText = "Secure Area";
        assertEquals(expectedText, actualText);
    }

    //Verify the error message “Your username   is invalid!”
    @Test
    public void verifyTheUsernameErrorMessage() {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("tomsmith1");
        //Enter “SuperSecretPassword!” password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();
        //verifyThePasswordErrorMessage
        //Enter “tomsmith” username
        WebElement Username = driver.findElement(By.name("username"));
        Username.sendKeys("tomsmith");
        //Enter “SuperSecretPassword!” password
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("SuperSecretPassword");
        //Click on ‘LOGIN’ button
        WebElement log = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        log.click();
        //verify the message "Your username is invalid!"
        WebElement errorMsgVerify=driver.findElement(By.xpath("//div[@id='flash']"));
        String actualText = errorMsgVerify.getText();
        String expectedText ="Your username is invalid!";
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
}

