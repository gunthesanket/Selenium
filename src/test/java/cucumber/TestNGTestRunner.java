package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", glue = "RahulShettyAcademy.StepDefination", monochrome = true, plugin = {
		"html:target/cucumber.html" },tags="@Error2")
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
