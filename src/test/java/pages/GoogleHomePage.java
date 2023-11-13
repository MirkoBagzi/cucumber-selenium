package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleHomePage extends BaseHelper {
    WebDriver driver;

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    WebElement inputField;
    @FindBy(name = "btnK")
    WebElement searchButton;

    public void navigateToPage() {
        driver.get("https://www.google.com/");
    }

    public void inputSearchTerm(String searchTerm) {
        inputField.sendKeys(searchTerm);
    }

    public void clickOnSearchButton() {
        wdWait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }
}
