package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import gherkin.formatter.model.Feature;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {},
        features = "src/test/resources/features",
        tags = {"~@ignore"},
        glue = {"steps"}
)
public class RunCucumberTest {

    public static WebDriver driver;

    @BeforeClass
    public static void start (){
        driver = new ChromeDriver();
        System.out.println("iniciou");
    }

    @AfterClass
    public static void stop (){
        driver.quit();
        System.out.println("Finalizou");
    }

}
