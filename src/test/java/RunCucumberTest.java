import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports",
                "json:target/cucumber-reports/Cucumber.json"
        })

public class RunCucumberTest {
}