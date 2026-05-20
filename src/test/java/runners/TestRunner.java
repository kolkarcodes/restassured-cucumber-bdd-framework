package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        monochrome = true,

        plugin = {
                "pretty",
                "html:target/cucmber-report.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }

)
public class TestRunner extends AbstractTestNGCucumberTests {

}

