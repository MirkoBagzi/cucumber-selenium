package StepsDefinitions;

import helpers.BaseHelper;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
        "src/test/resources/Features",
},
        glue = {"StepsDefinitions"})
public class TestRunner extends BaseHelper {
    @BeforeClass
    public static void testInit() {
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void testTearDown() {
        driver.close();
        driver.quit();
    }
}
