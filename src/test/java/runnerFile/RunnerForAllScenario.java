package runnerFile;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@CucumberOptions(
        features = "src/test/resources/FeaturesFile/createAndUpdateEmployee.feature",
        glue = {"stepDefinitions", "runnerFile","hooks"},
        plugin = {"pretty", "html:target/report/index.html"}
)

public class RunnerForAllScenario extends AbstractTestNGCucumberTests {
    WebDriver driver = Driver.getDriver();
    
    @AfterClass
    public void setUpDriver() {
        driver.quit();
    }

    @AfterMethod
    public void takeScreenshotWhenTestFails(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss-nn");
            String time = LocalDateTime.now().format(formatter);

            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String folderPath = "C:/Users/ganie_000/Techno Study/Projects/SaturdayProject19/src/test/resources/screenshot/";
            String fileName = result.getMethod().getMethodName() + "_" + time + ".png";

            File destinationFile = new File(folderPath + fileName);

            try {
                FileUtils.copyFile(sourceFile, destinationFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
