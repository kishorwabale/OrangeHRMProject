package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/Features",
        glue = {"StepDefinations","Hooks"},
        plugin = {"pretty",
                "html:target/Cucumber_reports/Execution_report.html"}
)
public class TestRun
{
}
