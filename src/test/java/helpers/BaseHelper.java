package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseHelper {
    public static String workingDirectory;
    protected static WebDriver driver = setUpWebDriver();
    protected static JavascriptExecutor js = (JavascriptExecutor) driver;
    protected static Actions action = new Actions(driver);
    public WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public static WebDriver setUpWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

    //method for clicking on provided element
    public void clickOnElement(WebElement element) {
        wdWait.until(ExpectedConditions.visibilityOf(element));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        wdWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

}
