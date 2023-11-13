package StepsDefinitions;

import helpers.BaseHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.GoogleHomePage;

public class GoogleSearchSteps extends BaseHelper {
    GoogleHomePage googleHomePage = new GoogleHomePage(driver);

    @Given("user is on homepage")
    public void user_is_on_homepage() {
        googleHomePage.navigateToPage();
    }

    @When("^user inputs (.*)")
    public void user_inputs_search_term(String searchTerm) {
        googleHomePage.inputSearchTerm(searchTerm);
    }

    @When("user clicks search button")
    public void user_clicks_search_button() {
        googleHomePage.clickOnSearchButton();
    }

    @Then("^user is shown search results that contains (.*)")
    public void user_is_shown_search_results(String searchTerm) {
        WebElement results = driver.findElement(By.id("search"));
        Assert.assertTrue("Search term is not on results page!", results.getText().contains(searchTerm));
    }

}
