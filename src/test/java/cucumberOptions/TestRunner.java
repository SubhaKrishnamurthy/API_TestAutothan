package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinition"},
        plugin = {
                "json:target/RunCuke/cucumber.json",
                "pretty","html:target/RunCuke/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},

      // dryRun = true,
      // tags = "@OSP"
        tags = "@Authentication"
    //  tags = "@TC1.1_ValidAccounType_credit_withValidAccessToken"


)
public class TestRunner {


}
