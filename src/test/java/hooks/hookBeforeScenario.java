package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class hookBeforeScenario {
    @After
    public void takeScreenshot(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }

    @After
    public void getScenario(Scenario scenario){
        System.out.println("Status Scenario is " + scenario.getStatus());
    }

}
