package browserfactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class BaseTest {
    public static WebDriver driver;
    public void openBrowser(String baseUrl) {
        ChromeOptions options = new ChromeOptions(); // setting Webdriver
        driver = new ChromeDriver(options);
        driver.get(baseUrl);// Launch the URL
        driver.manage().window().maximize();
    }
    public void closeBrowser() {
        driver.quit();
    }
}