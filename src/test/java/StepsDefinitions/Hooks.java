package StepsDefinitions;

import helpers.BaseHelper;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks extends BaseHelper {
    @After
    public void afterEachTest(Scenario scenario) {
        // This method will be executed after each scenario/test

        //Find path
        Path currentRelativePath = Paths.get("");
        BaseHelper.workingDirectory = currentRelativePath.toAbsolutePath().toString();

        // Check the status of the scenario
        if (scenario.isFailed()) {
            // Scenario failed

            // Take screenshot
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            // Get the scenario name
            String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9.-]", "_");

            // Generate file name with current date-time
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String dateTime = dateFormat.format(new Date());
            String fileName = scenarioName + "_" + dateTime + ".png";

            // Save the screenshot in the workingDirectory/screenshots/ path
            try {
                Path screenshotPath = Path.of(workingDirectory + "/screenshots/", fileName);
                Files.createDirectories(screenshotPath.getParent());
                Files.write(screenshotPath, screenshot);
                System.out.println("Screenshot saved: " + screenshotPath);
            } catch (Exception e) {
                System.out.println("Failed to save the screenshot: " + e.getMessage());
            }

            // Attach the screenshot to the scenario
            scenario.attach(screenshot, "image/png", "Failure Screenshot: " + fileName);
        } else {
            // Scenario passed
            System.out.println("Scenario passed: " + scenario.getName());
        }
    }
}
